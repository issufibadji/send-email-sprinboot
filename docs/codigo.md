# Explicacao do Codigo

## Email.java — Record de dados

```java
public record Email(String to, String subject, String body) {}
```

`record` e um recurso do Java 16+ que cria automaticamente construtor, getters, `equals`, `hashCode` e `toString`. Funciona como um DTO imutavel para transportar os dados do e-mail recebidos no corpo da requisicao.

---

## EmailController.java — Camada REST

```java
@RestController
@RequestMapping("email")
public class EmailController {

  private final EmailService emailService;

  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping
  public void sendEmail(@RequestBody Email email) {
    emailService.sendEmail(email);
  }
}
```

- `@RestController` — combina `@Controller` + `@ResponseBody`
- `@RequestMapping("email")` — mapeia a rota base `/email`
- `@PostMapping` — mapeia `POST /email`
- `@RequestBody` — desserializa o JSON da requisicao para o record `Email`
- Injecao de dependencia via construtor (sem `@Autowired`)

---

## EmailService.java — Logica de envio

```java
@Service
public class EmailService {

  private final JavaMailSender mailSender;

  public EmailService(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void sendEmail(Email email) {
    var message = new SimpleMailMessage();
    message.setFrom("noreply@email.com");
    message.setTo(email.to());
    message.setSubject(email.subject());
    message.setText(email.body());
    mailSender.send(message);
  }
}
```

- `JavaMailSender` — interface Spring auto-configurada com base no `application.properties`
- `SimpleMailMessage` — mensagem de texto puro (sem HTML, sem anexos)
- `mailSender.send()` — abre conexao SMTP e envia a mensagem

---

## Fluxo de uma requisicao

```
POST /email {"to":"x","subject":"y","body":"z"}
  -> EmailController.sendEmail(@RequestBody Email)
  -> EmailService.sendEmail(email)
  -> SimpleMailMessage (monta cabecalhos)
  -> JavaMailSender.send() (envia via SMTP)
  -> HTTP 200 (resposta vazia)
```
