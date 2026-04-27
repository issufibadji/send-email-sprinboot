<h1 align="center">
  Email Spring Boot
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Github&message=@issufibadji&color=8257E5&labelColor=000000" alt="@issufibadji" />
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Demo&color=8257E5&labelColor=000000" alt="Demo" />
</p>

 Enviou e-mails de forma simples e eficaz utilizando o poderoso framework Spring Boot em conjunto com a biblioteca JavaMail.

## Demo

<p align="center">
  <img src="src/img/senderEmail.png" alt="Demo envio de e-mail" width="800"/>
</p>

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Email](https://docs.spring.io/spring-framework/reference/integration/email.html)

## Como Executar

- Clonar repositório git:
  ```
  git clone https://github.com/issufibadji/email-springboot.git
  ```

- Construir o projeto:
  ```
  ./mvnw clean package
  ```

- Configurar credenciais do servidor de email

- Executar:
  ```
  java -jar ./target/email-springboot-0.0.1-SNAPSHOT.jar
  ```

- Testar ( com [httppie](https://httpie.io) ):

  ```
  http POST :8080/email to="issufibjsis@gmail.com" subject="demo spring mail" body="Olá, Mundo"
  ```
  mas antes instala:
  ```
   pip install httpie
 ```
ou
  ```
  Invoke-WebRequest -Uri http://localhost:8080/email -Method POST -ContentType "application/json" -Body '{"to":"gptibj@gmail.com","subject":"teste spring","body":"funcionou!"}'
  ```
