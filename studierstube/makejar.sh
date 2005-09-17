#!/bin/sh
rm studierstube.jar
echo "Manifest-Version: 1.0" > manifest.tmp
echo "Main-Class: studierstube.Main" >> manifest.tmp
find studierstube/ -name "*.class" > filelist.tmp
find -name "*.xml" >> filelist.tmp
jar cfm studierstube.jar manifest.tmp @filelist.tmp
rm manifest.tmp filelist.tmp
