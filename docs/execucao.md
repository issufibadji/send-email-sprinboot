# Como Executar

## 1. Clonar o repositorio

```bash
git clone https://github.com/issufibadji/email-springboot.git
cd email-springboot
```

## 2. Compilar o projeto

```bash
./mvnw clean package -DskipTests
```

O JAR gerado estara em `./target/email-springboot-0.0.1-SNAPSHOT.jar`.

## 3. Executar

```bash
java -jar ./target/email-springboot-0.0.1-SNAPSHOT.jar
```

A aplicacao inicia na porta **8080**. Aguarde a mensagem:
```
Started EmailSpringbootApplication in X.XX seconds
```

## 4. Testar o envio de e-mail

### Com HTTPie (recomendado — instale com `pip install httpie`)

```bash
http POST :8080/email to="destino@email.com" subject="assunto" body="mensagem"
```

### Com PowerShell (Invoke-WebRequest)

```powershell
Invoke-WebRequest -Uri http://localhost:8080/email `
  -Method POST `
  -ContentType "application/json" `
  -Body '{"to":"destino@email.com","subject":"assunto","body":"mensagem"}'
```

### Com curl.exe (Windows)

```powershell
curl.exe -X POST http://localhost:8080/email `
  -H "Content-Type: application/json" `
  -d "{\"to\":\"destino@email.com\",\"subject\":\"assunto\",\"body\":\"mensagem\"}"
```

### Com curl (Linux/Mac)

```bash
curl -X POST http://localhost:8080/email \
  -H "Content-Type: application/json" \
  -d '{"to":"destino@email.com","subject":"assunto","body":"mensagem"}'
```

## Resposta esperada

- **HTTP 200** — e-mail enviado com sucesso (corpo vazio)
- **HTTP 400** — JSON mal formatado ou campos ausentes
- **HTTP 500** — erro de conexao com o servidor SMTP (verifique as credenciais)
