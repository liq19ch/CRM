# CRM
## An simple GUI to manage customers
This is a UI for managing cutomers. Actions contain "add", "delete", and "update".
This is a Maven project, use Spring boot framework to work with thymeleaf. Also use SpringData JPA to decrease the codes of traditional DAO layer.

## Technologies
* Java
* Spring Boot
* MySQL
* JPA
* HTML
* Bootstrap

## Demo screenshots
Home page: list all customer
![Home](https://github.com/liq19ch/CRM/blob/master/img-folder/listpage.jpg)
Delete: pop-up alert before action
![Delete](https://github.com/liq19ch/CRM/blob/master/img-folder/delete.jpg)
Save: create a new customer info
![Save](https://github.com/liq19ch/CRM/blob/master/img-folder/add.jpg)
Update: read data from DB and allow to be updated
![Update](https://github.com/liq19ch/CRM/blob/master/img-folder/update.jpg)


## 3 versions to implement (use findAll as an example)
Native Hibernate JPA (EntityManager to get currentSession)
![currentSession](https://github.com/liq19ch/CRM/blob/master/img-folder/hibernate.jpeg)
Standard JPA (EntityManager)
![EntityManager](https://github.com/liq19ch/CRM/blob/master/img-folder/standard.jpeg)
Spring Data JPA (JpaRepository)
![JpaRepository](https://github.com/liq19ch/CRM/blob/master/img-folder/springdata.jpeg)


## Data in JSON format
![PostMan GetMapping (all)](https://github.com/liq19ch/CRM/blob/master/img-folder/postman-findall.jpg)
![PostMan GetMappint (byID)](https://github.com/liq19ch/CRM/blob/master/img-folder/postman-findbyid.jpg)
![PostMan PostMapping (save object)](https://github.com/liq19ch/CRM/blob/master/img-folder/postman-save.jpg)
![PostMan DeleteMapping (byID)](https://github.com/liq19ch/CRM/blob/master/img-folder/postman-delete.jpg)
![PostMan PutMapping (update)](https://github.com/liq19ch/CRM/blob/master/img-folder/postman-update.jpg)
![No service & controller, use Spring rest dependency. (Get all)](https://github.com/liq19ch/CRM/blob/master/img-folder/spring-rest.jpg)
