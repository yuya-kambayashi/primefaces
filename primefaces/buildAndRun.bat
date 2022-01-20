@echo off
call mvn clean package
call docker build -t yuya-kambayashi/primefaces .
call docker rm -f primefaces
call docker run -d -p 9080:9080 -p 9443:9443 --name primefaces yuya-kambayashi/primefaces