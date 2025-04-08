# Sherlock1 Problem-Set

This is a problem-set for the [SherlockBench AI benchmarking system](https://sherlockbench.com).

This problem-set has some easy problems and lots of hard problems which are
challenging for even frontier reasoning models.

## Usage
Copy the source file into your checkout of the
[SherlockBench-API](https://github.com/Xylon2/sherlockbench-api)
under `src/clj/`.

Then edit `config.edn` and add it to `:problem-namespaces`.

## Development
It's just a single file.

Run the tests like this:
```
clj -X:test
```

## Version
This is Sherlock1v2
