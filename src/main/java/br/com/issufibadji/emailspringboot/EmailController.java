package br.com.issufibadji.emailspringboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {
  private final EmailService emailService;

  // injetar emailService no construtor
  public EmailController(EmailService emailService) {
    this.emailService = emailService;
  }

  // enviadop no corpo da requesiçao post
  @PostMapping
  public void sendEmail(@RequestBody Email email) {
    emailService.sendEmail(email);
  }
}
