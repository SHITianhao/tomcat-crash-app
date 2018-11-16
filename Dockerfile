FROM tomcat:8.0

RUN apt update && apt install vim -y
RUN mkdir /usr/local/tomcat/mywebapps
COPY tomcat.war /usr/local/tomcat/webapps/tomcat.war
COPY tomcat.war /usr/local/tomcat/mywebapps/tomcat.war
COPY server.xml /usr/local/tomcat/conf/server.xml
COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml