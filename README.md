# Fatura Api
*Esse projeto é uma Api de fatura, utilizando Java e angular no frontend, a aplicação tem usuários, associação com faturas e tratamentos de exceções. Esse projeto tem como princípio estudar sobre as exceções e aprimoramento dos trabalhos com angular em componentes,
services, rotas e módulos.*

### Link para fatura-api
https://invoice-api-ludmylla.herokuapp.com/invoices

### Link para fatura-app link
https://invoice-api.netlify.app/list

![img](https://i.imgur.com/4vjZSgA.png)

## Tecnologias usadas
- Spring web
  - Spring Data Jpa
  - MapStruct
  - Swagger
  - PostgreSQL
  - Maven
  - Java Web

## Passos para configuração

**1. Clone a aplicação**

```bash
git clone https://github.com/LudmyllaArielly/invoice-api-springboot.git
```
**2. Execute o aplicativo usando maven**

```bash
mvn invoice-api:run
```
**3. Pré-requisitos**
```bash
mvn --version
```
Veja a indicação da versão do maven instalada, bem como a versão do JDK, entre outras. Esses requisitos são obrigátorios, portanto é necessário definir corretamento as variáveis de ambiente JAVA_HOME, M2_HOME

&nbsp;O aplicativo começará a ser executado em: <http://localhost:8080>

**4. Compila**

```bash
mvn compile
```
Este comando compila o projeto e deposita os resultados no diretório de destino.

**5. Executando a Rest Api**

```bash
java -jar target/api.jar
or
mvn invoice-api:run
```
Neste caminho A Api foi geradada pelo pacote mvn package -P e esta sendo executada na porta 8080.

&nbsp;Exemplo de endereço:http://localhost:8080/invoices

&nbsp;Exemplo de endereço com swagger:http://localhost:8080/swagger-ui.html#/

## Explorar Rest APIs

### Faturas

| Method | Url | Description |
| ------ | --- | ----------- |
| GET    | /invoices | Lista todas faturas| 
| POST   | /invoices | Cria fatura | 
| PUT    | /invoices | Atualiza fatura | 
| GET    | /invoices/{id} | Busca fatura por id | 
| DELETE | /invoices/{id} | Deleta fatura | 
| GET    | /invoices/findInvoiceWithUserCpf/{id} | Busca fatura por id e retorna todos os dados do usuário | 
| PATCH  | /invoices/status | Atualiza o status da fatura | 

## Usuários
| Method | Url | Description | 
| ------ | --- | ----------- | 
| GET    | /users | Lista todos usuários | 
| POST   | /users | Cria usuário | 
| PUT    | /users | Atualiza usuário | 
| GET    | /users/{id} |Busca usuário por id | 
| GET    | /users/findCpf/{cpf} | Busca usuário por cpf | 

## Exemplo de corpo de solicitações válidas

##### Cria usuário
```json
{
	"firstName": "Anna",
	"lastName": "Greyth",
	"cpf": "74125879622",
	"DateOfBirth": "1987-09-18"
}
```

##### Atualiza usuário
```json
{
  "id": 1,
	"firstName": "Anna",
	"lastName": "Greyth",
	"cpf": "74125879622",
	"DateOfBirth": "1987-09-18"
}
```

##### Cria fatura
```json
{
  "companyName": "Industry Mack",
  "dueDate": "2021-06-17",
  "status": "PAYABLE",
  "userCpfDTO": {
    "cpf": "74125879622"
  },
  "value": 325.78
}
```
##### Atualiza fatura
```json
{
  "id": 1,
  "companyName": "Industry Mack",
  "dueDate": "2021-06-17",
  "status": "PAYABLE",
  "userCpfDTO": {
    "cpf": "74125879622"
  },
  "value": 325.78
}
```
##### Atualiza status da fatura
```json
{
  "id": 1,
  "status": "PAID_OUT"
}
```
# Invoice APP
Esse projeto foi gerado com Angular CLI version 11.2.11.

### Servidor de desenvolvimento
Execute ng serve para startar o servidor. Navegue até http://localhost:4200/. O aplicativo será recarregado automaticamente se você alterar qualquer um dos arquivos de origem.

### Gerando componentes
Execute ng generate component component-name para gerar um novo componente. Você também pode usar ng generate directive|pipe|service|class|guard|interface|enum|module.

### Build
Execute ng build para fazer o build do projeto.Os artefatos de construção serão armazenados no diretório dist /. Use o sinalizador --prod para uma construção de produção.

### Clone o repositório
```
git clone https://github.com/LudmyllaArielly/invoice-api-springboot.git
cd invoice-app
```

### Servidor da aplicação

Nosso servidor de aplicativos backend é um aplicativo NodeJS que depende de alguns pacotes npm de terceiros. Você precisa instalar estes:

* Instale as dependências locais (da pasta raiz do projeto):
    ```
    cd server
    npm install
    cd ..
    ```

  (Isso instalará as dependências declaradas no arquivo server / package.json)
  
### Execute a aplicação

- Se você tiver yarn instalado
 - yarn start
- Npm
 - npm start
- Ng
 - ng serve




