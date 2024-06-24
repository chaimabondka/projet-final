# Product management project 

This microservices-based system was created to control the operations of a product management. The system is made up of several kinds of microservices, each of which was created using a different language or framework and deployed using Docker Compose. The system uses Gateway to route requests to the proper microservice and Eureka for service discovery.

* Microservices

The microservices included in this system are:

products Service: 

order Service: Manages orders and stock

costumer Service: Manages client information

inventory Service: the management of raw materials, components, and finished products

reviews Service: 


* Deployment
Docker Compose is used to deploy the system. The services are listed, along with their configurations, in the docker-compose.yml file. In order to route requests to the correct microservice, the system uses a gateway. Also it uses Eureka for service discovery.

* Configuration
Each microservice's configuration files are located in the config directory. The configuration files detail each microservice's port number, database connection details, and other options.

