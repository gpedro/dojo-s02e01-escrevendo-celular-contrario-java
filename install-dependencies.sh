#!/bin/bash

# go to lib folder
cd lib

# download dependencies
wget -q -O hamcrest-core.jar http://search.maven.org/remotecontent?filepath=org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar
wget -q -O junit.jar http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar

# back to project folder
cd -