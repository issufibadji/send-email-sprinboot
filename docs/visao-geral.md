# Visao Geral do Projeto

## O que e este projeto?

API REST desenvolvida com Spring Boot para envio de e-mails via SMTP. O projeto demonstra como integrar o modulo `spring-boot-starter-mail` para enviar mensagens de forma simples e desacoplada.

## Tecnologias

| Tecnologia | Versao | Finalidade |
|---|---|---|
| Java | 21 (compativel com 26) | Linguagem principal |
| Spring Boot | 3.1.5 | Framework base |
| Spring MVC | 6.x | Camada REST (controller) |
| Spring Mail | 6.x | Integracao com SMTP |
| Maven | 3.x | Gerenciamento de dependencias |
| Mailtrap | - | Sandbox SMTP para testes |

## Arquitetura

```
Cliente (HTTP)
     |
     v
EmailController   <- recebe POST /email
     |
     v
EmailService      <- monta e envia a mensagem
     |
     v
JavaMailSender    <- abstração Spring para SMTP
     |
     v
Servidor SMTP (Mailtrap)
```

## Estrutura de Pacotes

```
src/
  main/
    java/br/com/issufibadji/emailspringboot/
      Email.java                    # Record com os dados do e-mail
      EmailController.java          # Endpoint REST POST /email
      EmailService.java             # Logica de envio
      EmailSpringbootApplication.java  # Ponto de entrada
    resources/
      application.properties        # Configuracoes SMTP
  test/
    java/...
      EmailSpringbootApplicationTests.java
```
