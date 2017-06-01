#!/usr/bin/env bash

javac internal/*.java -d
java -verbose:class internal.HelloWorld > internal/log.txt