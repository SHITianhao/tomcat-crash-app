# Tomcat Crash App
# [中文](./README-zh.md)
## RUN
`start.sh` includes maven packing, building docker image and runing docker container.

`log.sh` for checking container's logs

## Crash App

App will be copied under `webapps` and `mywebapps` folder. It will also be deployed behind `8080` and `8081` port

```
GET /tomcat/hello
```
Checking free heap size

```
GET /tomcat/leak
```
Increasing static member for OOM exception

```
GET /tomcat/crash
```
Increasing new local variable for OOM exception

## Env
* Tomcat 8.0
* Java 8