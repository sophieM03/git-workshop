with import <nixpkgs> {}; {
  dev = stdenv.mkDerivation {
    name = "slides";
    buildInputs = [
      pandoc
      nodePackages.nodemon
      ( texlive.combine {
          inherit (texlive) scheme-medium marvosym enumitem bookman titlesec
          hyperref fancyhdr changepage lastpage xcolor xifthen ifmtarg datetime
          footmisc fmtcount;
        }
      )
    ];
  };
}
