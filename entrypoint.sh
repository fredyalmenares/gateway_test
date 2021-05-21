#!/bin/bash
curl -s -f -L -o await https://github.com/betalo-sweden/await/releases/download/v0.4.0/await-linux-amd64;
chmod +x await;
MYSQL_URI="mysql://${MYSQL_USERNAME}:${MYSQL_PASSWORD}@${MYSQL_HOST}:${MYSQL_PORT}/${MYSQL_DATABASE}#tables=gateway";
./await -t 10m0s $POSTGRES_URI -- echo "DATABASE is up!";
java -cp app:app/lib/* "com.test.gateway.GatewayApplication";
