#!/bin/sh
echo "Manifest-Version: 1.0" > manifest.tmp
echo "Main-Class: studierstube.Main" >> manifest.tmp
find studierstube/ -name "*.class" > filelist.tmp
find -name "zauberliste.xml" >> filelist.tmp
jar cvfm /tmp/studierstube.jar manifest.tmp @filelist.tmp
rm manifest.tmp filelist.tmp
