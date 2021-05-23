#!/bin/bash
MYSQL_URI="mysql://root:${MYSQL_PASSWORD}@${MYSQL_TEST_HOST}:${MYSQL_PORT}/${MYSQL_TEST_DATABASE}";
/await -t 10m0s $MYSQL_URI -- echo "DATABASE is up!";
mvn test;