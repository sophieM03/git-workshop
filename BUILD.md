# Build

The slides for this workshop are available as markdown in the [README](./README.md).

The generate of a PDF document from that requires the [Pandoc](https://pandoc.org/) utility.
Then the following command can be used.

    pandoc -t beamer README.md -o slides.pdf
