# Invoice Api, Spring framework, PostgreSQL, MaspStruct, Swagger
*This project is an invoice API using spring boot and angular as front end. In it we work with relationships and endpoints, such as saving, changing, modifying, listing. 
In addition to being a responsive and agile app.*

![img](https://i.imgur.com/4vjZSgA.png)

<p align="center">
  <img src="https://i.imgur.com/ZnGBMSh.png">
  <img src="https://i.imgur.com/0Nh2nxZ.png">
</p>

## Technologies used
- Spring web
  - Spring Data Jpa
  - MapStruct
  - Swagger
  - PostgreSQL

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/coma123/Spring-Boot-Blog-REST-API.git
```
**2. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## Explore Rest APIs

### Invoices

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| GET    | /invoices | Find all invoices | |
| POST   | /invoices | Create a invoice | |
| PUT    | /invoices | Updated the invoice | |
| GET    | /invoices/{id} | Find the invoice by id | |
| DELETE | /invoices/{id} | Deleted the invoice | |
| GET    | /invoices/findInvoiceWithUserCpf/{id} | Finds invoice by id and returns all user data | |
| PATCH  | /invoices/status | Updated status of the invoice | |
