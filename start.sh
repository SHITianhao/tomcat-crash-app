cd ./crashapp &&
mvn install &&
mvn clean package &&
cd .. &&
cp ./crashapp/target/tomcat.war ./tomcat.war &&
docker build . --tag crashapp &&
docker run -it --rm -p 8009:8009 -p 8005:8005 -p 8080:8080 -p 8081:8081 --name crashapp -e JAVA_OPTS='-Xmx128m' -d crashapp