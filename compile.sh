#!/bin/sh

echo "compile karloff"
javacc Karloff.jj
echo "compile java"
javac *.java
echo "execute"
# echo $0 $1 $2
java Karloff $1

