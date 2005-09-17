#!/bin/sh
echo "Manifest-Version: 1.0" > manifest.txt
echo "Main-Class: studierstube.Main" >> manifest.txt
jar cfm studierstube.jar manifest.txt studierstube/
