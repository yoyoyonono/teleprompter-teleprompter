{
  description = "Teleprompter Python environment";

  inputs.nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";

  outputs = { self, nixpkgs }:
    let
      system = "x86_64-linux";
      pkgs   = nixpkgs.legacyPackages.${system};

      # Native libraries needed by the Python packages and Java AWT/LWJGL.
      runtimeLibs = [
        pkgs.portaudio
        pkgs.alsa-lib
        pkgs.espeak-ng
        pkgs.stdenv.cc.cc.lib
        pkgs.zlib
        pkgs.glib
        pkgs.libGL
        pkgs.libxcb
        pkgs.libX11
        pkgs.libXext
        pkgs.libSM
        pkgs.libICE
        pkgs.libXi
        pkgs.libXrender
        pkgs.libXtst
      ];
    in {
      devShells.${system}.default = pkgs.mkShell {
        packages = [
          pkgs.python312
          pkgs.pkg-config
          pkgs.jdk17
        ] ++ runtimeLibs;

        shellHook = ''
          PROJECT_ROOT="$(git rev-parse --show-toplevel 2>/dev/null || pwd)"
          export LD_LIBRARY_PATH="$PROJECT_ROOT/ui-system/lib/ogl/linux:${pkgs.lib.makeLibraryPath runtimeLibs}:''${LD_LIBRARY_PATH:-}"

          # The OpenCV wheel only ships the xcb Qt platform plugin. Force Qt
          # through XWayland instead of letting it abort looking for Wayland.
          export QT_QPA_PLATFORM=xcb

          VENV="$PROJECT_ROOT/.venv"

          # Recreate the venv if it is missing or has no working pip.
          if [ ! -x "$VENV/bin/python" ] || ! "$VENV/bin/python" -m pip --version >/dev/null 2>&1; then
            echo "Creating virtualenv..."
            rm -rf "$VENV"
            ${pkgs.python312}/bin/python -m venv --without-pip "$VENV"
            "$VENV/bin/python" -m ensurepip --default-pip
          fi

          # nixpkgs' ensurepip only creates pip3, so add the usual `pip` alias.
          if [ ! -e "$VENV/bin/pip" ] && [ -e "$VENV/bin/pip3" ]; then
            ln -sf pip3 "$VENV/bin/pip"
          fi

          export VIRTUAL_ENV="$VENV"
          export PATH="$VENV/bin:$PATH"

          if ! "$VENV/bin/python" -c "import deepface, httpx, openai, cv2, pyaudio, RealtimeSTT, silero_vad, faster_whisper; import os; assert os.path.exists(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')" 2>/dev/null; then
            echo "Installing Python packages..."
            "$VENV/bin/python" -m pip install \
              deepface \
              httpx \
              openai \
              "opencv-contrib-python==4.14.0.94" \
              "opencv-contrib-python-headless==4.14.0.94" \
              pyaudio \
              "RealtimeSTT[faster-whisper,silero-vad]"

            # DeepFace pulls in the headless OpenCV build. Reinstall the GUI
            # build last so cv2.imshow() works.
            "$VENV/bin/python" -m pip install \
              --force-reinstall --no-deps \
              "opencv-contrib-python==4.14.0.94"
          fi

          # Sanity check
          echo "Python: $(command -v python) ($(python --version))"
        '';
      };
    };
}
