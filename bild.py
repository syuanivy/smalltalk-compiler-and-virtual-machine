#!/usr/bin/env python

# bootstrap by downloading bilder.py if not found
import urllib
import os
import glob

if not os.path.exists("bilder.py"):
    print "bootstrapping; downloading bilder.py"
    urllib.urlretrieve(
        "https://raw.githubusercontent.com/parrt/bild/master/src/python/bilder.py",
        "bilder.py")

# assumes bilder.py is in current directory
from bilder import *

CP = "src:gen:out:test/src:resources:"+\
    JARCACHE+"/antlr-4.5-complete.jar:"+\
    JARCACHE+"/junit-4.10.jar:"+\
    JARCACHE+"/symtab-1.0.1.jar"

def init():
    download("http://www.antlr.org/download/symtab-1.0.1.jar", JARCACHE)
    download("http://search.maven.org/remotecontent?filepath=junit/junit/4.10/junit-4.10.jar", JARCACHE)


def parser():
    antlr4(srcdir="src/smalltalk/compiler", trgdir="gen",
           package="smalltalk.compiler",
           version="4.5",
           args=["-visitor","-listener"])


def compile():
    require(init)
    require(parser)
    javac("src", "out", javacVersion="1.8", cp=CP)
    javac("test", "out", javacVersion="1.8", cp=CP)


def test(java_test_filename):
    test_name = os.path.basename(java_test_filename)
    test_name = os.path.splitext(test_name)[0]
    junit_runner('smalltalk.test.'+test_name, cp=CP)


def tests():
    require(compile)
    for file in glob.glob("test/src/smalltalk/test/Test*.java"):
        test(file)


def clean():
    rmdir("out")
    rmdir("gen")


def all():
    tests()

processargs(globals())
