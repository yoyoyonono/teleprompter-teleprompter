{
  description = "Minimal Python";

  inputs.nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";

  outputs = { self, nixpkgs }:
    let
      system = "x86_64-linux";
      pkgs   = nixpkgs.legacyPackages.${system};
    in {
      devShells.${system}.default = pkgs.mkShellNoCC {
        packages = with pkgs; [
          python314
          python314Packages.httpx
          python314Packages.openai
          espeak-ng
        ];
      };
    };
}
