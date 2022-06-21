FROM openjdk:17-slim

RUN groupadd solr-movies && useradd solr-movies -g solr-movies && mkdir -p /opt/solr-movies/config

ARG JAR_FILE
ADD target/$JAR_FILE /opt/solr-movies/solr-movies.jar

RUN chown -R solr-movies:solr-movies /opt/solr-movies

USER solr-movies

WORKDIR /opt/solr-movies/
ENTRYPOINT java -jar solr-movies.jar