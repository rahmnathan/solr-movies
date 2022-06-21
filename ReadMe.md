<h1>Solr Movies</h1>

[![Build Status](https://jenkins.nathanrahm.com/buildStatus/icon?job=localmovie-media-manager)](https://jenkins.nathanrahm.com/job/localmovie-media-manager/)

This repository is a Spring Boot video streaming service for my media collection.

<h4>APIs</h4>
This service exposes a set of endpoints that facilitate:

- Loading media at a given path ('/Movies', '/Series', etc).
- Streaming a media file.
- Loading media events (for persistent Android clients).
 
<h4>Tech Stack</h4>
 
 - Spring Boot
 - Apache Camel
 - Maven
 - Postgresql
 - [Hashicorp Vault](https://vault.nathanrahm.com)
 - [Keycloak](https://login.nathanrahm.com/)
 
 <h4>Monitoring</h4>
 
 - [Grafana](https://grafana.nathanrahm.com/d/Uvb0ohGnz/localmovies)
 - Prometheus

<h4>CI/CD</h4>

- [Kubernetes](https://kube.nathanrahm.com)
- [Jenkins](https://jenkins.nathanrahm.com)
- Helm (chart located in helm/solr-movies directory)
