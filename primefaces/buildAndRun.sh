#!/bin/sh
mvn clean package && docker build -t yuya-kambayashi/primefaces .
docker rm -f primefaces || true && docker run -d -p 9080:9080 -p 9443:9443 --name primefaces yuya-kambayashi/primefaces