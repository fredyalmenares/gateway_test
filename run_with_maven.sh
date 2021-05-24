#!/usr/bin/env bash
source ./load_env.sh;
mvn clean install -Dmaven.test.skip;
java -jar ./target/*.jar;