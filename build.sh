#!/bin/sh
javac -classpath /d/Test/AgileJava/junit-4.10.jar -Xlint:deprecation sis/studentinfo/*.java
#javadoc -package -classpath "/d/Test/AgileJava:/d/Test/AgileJava/junit-4.10.jar" studentinfo
if [ $? -eq 0 ]; then
	java -cp "/d/Test/AgileJava:/d/Test/AgileJava/junit-4.10.jar" junit.textui.TestRunner sis.studentinfo.AllTest
fi