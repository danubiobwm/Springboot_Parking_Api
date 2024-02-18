package com.parkingapi.demoparkingapi;

import com.parkingapi.demoparkingapi.jwt.JwtToken;
import com.parkingapi.demoparkingapi.web.dto.UsuarioLoginDto;
import org.springframework.test.web.reactive.server.WebTestClient;

import org.springframework.http.HttpHeaders;
import java.util.function.Consumer;

public class JwtAuthentication {
    public static Consumer<HttpHeaders> getHeaderAuthorization(WebTestClient client, String username, String password) {
       String token = client
               .post()
               .uri("/api/v1/auth")
               .bodyValue(new UsuarioLoginDto(username, password))
               .exchange()
               .expectStatus().isOk()
               .expectBody(JwtToken.class)
               .returnResult()
               .getResponseBody()
               .getToken();

         return headers -> headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }
}
