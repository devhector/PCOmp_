#!/bin/sh

rm -rf build

mkdir build

find . -type f -name "*.java" > sources.txt

javac -d ./build/ @sources.txt


