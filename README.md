# Lego Monolith
A monolith microservice POC.

## Overview
For many organizations a full microservice architecture will present many organizational and technological problems. In order to be "tall enough" to use a full microservices architecture an organization should meet the following basic characteristics (http://martinfowler.com/bliki/MicroservicePrerequisites.html):

1. Rapid provisioning of new servers. Ideally cloud native.
1. Monitoring. Concepts such as correlated tracing, circuit breaking and self-healing services require a high degree of maturity in your monitoring capabilities.
1. Rapid application deployment. Continuous Deployment. A DevOps culture.
1. Autoscaling. Ability to scale a single service when load increases.
1. Governance around service contracts.

Many organizations struggle with several aspects of this; the lego monolith will allow product teams to embrace several aspects of microservices without having to meet all the prerequisites. The benefits:

1. Decoupled Design. Each service lives in it's own bounded context that can only communicate with other services over decoupled interfaces, e.g. REST or SOAP.
1. Choice of language. Not to the same extent as a true microservice architecture, however each service can be build in any JVM language. e.g. Java, Groovy, Scala, Kotlin, etc.
1. Choice of persistence. Each service should own the data source. e.g. traditional RDBMS, document DBs, flat files, etc.
1. Asynchronous. This POC includes an ActiveMQ message broker that services can publish and listen to.

## Run the application
The application can be run from the command line:
`./gradlew bootRun`
