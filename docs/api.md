# Documentacao da API

## POST /email

Envia um e-mail via SMTP configurado.

### Request

**URL:** `http://localhost:8080/email`  
**Method:** `POST`  
**Content-Type:** `application/json`

**Body:**

```json
{
  "to": "destinatario@email.com",
  "subject": "Assunto do e-mail",
  "body": "Corpo da mensagem"
}
```

| Campo | Tipo | Obrigatorio | Descricao |
|---|---|---|---|
| `to` | string | sim | E-mail do destinatario |
| `subject` | string | sim | Assunto da mensagem |
| `body` | string | sim | Corpo da mensagem em texto puro |

### Responses

| Status | Descricao |
|---|---|
| `200 OK` | E-mail enviado com sucesso |
| `400 Bad Request` | JSON invalido ou campos ausentes |
| `500 Internal Server Error` | Falha na conexao com o servidor SMTP |

### Exemplo de chamada

```bash
http POST :8080/email to="usuario@email.com" subject="Ola" body="Mensagem de teste"
```

### Observacoes

- O campo `from` e fixo como `noreply@email.com` (definido em `EmailService.java`)
- O endpoint nao retorna corpo na resposta — apenas o status HTTP
- Nao ha autenticacao implementada nesta versao
