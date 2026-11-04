{
  description = "Python dev shell with Anthropic library";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = nixpkgs.legacyPackages.${system};
        python = pkgs.python312;
        pythonEnv = python.withPackages (ps: [
          ps.anthropic
        ]);
      in
      {
        devShells.default = pkgs.mkShell {
          name = "python-anthropic";

          packages = [
            pythonEnv
          ];

          shellHook = ''
            echo "🐍 Python $(python --version) ready"
            echo "📦 anthropic $(python -c 'import anthropic; print(anthropic.__version__)')"
          '';
        };
      });
}
