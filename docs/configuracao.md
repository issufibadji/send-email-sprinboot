# Configuracao

## Pre-requisitos

- Java 17+ instalado (projeto usa 21, testado com 26)
- JAVA_HOME configurado no ambiente
- Maven Wrapper incluido (`./mvnw`) — nao precisa instalar Maven

## Configurar JAVA_HOME (Windows)

Definir para a sessao atual do PowerShell:
```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-26.0.1"
```

Definir permanentemente para o usuario:
```powershell
[System.Environment]::SetEnvironmentVariable("JAVA_HOME", "C:\Program Files\Java\jdk-26.0.1", "User")
```

## Configuracao SMTP (application.properties)

```properties
spring.mail.host=sandbox.smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=SEU_USERNAME
spring.mail.password=SUA_SENHA
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

## Usando Mailtrap (sandbox para testes)

1. Crie conta gratuita em https://mailtrap.io
2. Acesse **Email Testing -> Inboxes -> SMTP Settings**
3. Copie `username` e `password` para o `application.properties`
4. Os e-mails enviados aparecem no painel do Mailtrap — nao chegam em caixas reais

## Usando Gmail (producao)

Substitua as configuracoes no `application.properties`:
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seu@gmail.com
spring.mail.password=sua-senha-de-app
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> Para Gmail, gere uma **Senha de App** em: Conta Google -> Seguranca -> Verificacao em duas etapas -> Senhas de app
