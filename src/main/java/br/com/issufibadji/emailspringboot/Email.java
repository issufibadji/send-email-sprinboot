package br.com.issufibadji.emailspringboot;

// classe para representar o email a ser enviado
public record Email(String to, String subject, String body) {

}
