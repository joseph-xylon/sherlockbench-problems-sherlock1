# Sherlock1 Problem-Set

This is a problem-set for the [SherlockBench AI benchmarking system](https://sherlockbench.com).

It is designed to be a hard benchmark which is challenging for even frontier
reasoning models.

## Usage
Copy the source file into your checkout of the
[SherlockBench-API](https://github.com/Xylon2/sherlockbench-api). For example
under `src/clj/extra/`.

Then edit `config.edn` and add it to `:problem-namespaces`.

## Development
It's just a single file.

Run the tests like this:
```
clj -X:test
```
