#!/bin/sh
javac -classpath ./junit-4.10.jar *.java
if [ $? -eq 0 ]; then
	java -cp ".:/d/Test/tdd/junit-4.10.jar" junit.textui.TestRunner AllTest
fi