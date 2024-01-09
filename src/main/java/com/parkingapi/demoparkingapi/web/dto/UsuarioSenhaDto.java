package com.parkingapi.demoparkingapi.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioSenhaDto {
    private String senhaAtual;
    private String novaSenha;
    private String confimaSenha;
}
