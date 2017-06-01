#!/usr/bin/env bash

javac -sourcepath src/office/*.java -d out/production/java_note
java -verbose:class -classpath out/production/java_note office.Office office.Word > out/log.txt