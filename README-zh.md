# Tomcat Crash App
## 运行
`start.sh` 中包括mavn打包, docker镜像打包和容器运行

`log.sh` 查看容器日志

## Crash App 崩溃测试App

App 同时复制到`webapps` 和 `mywebapps` 文件夹下，并且部署到`8080`和`8081`端口

```
GET /tomcat/hello
```
查看可用Heap的大小

```
GET /tomcat/leak
```
扩大静态变量，最终引发OOM错误

```
GET /tomcat/crash
```
新建变量，最终引发OOM错误

## 环境
* Tomcat 8.0
* Java 8