package com.parkingapi.demoparkingapi.web.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioSenhaDto {
    @Size(min = 6, max = 8, message = "A senha deve conter entre 6 e 8 caracteres")
    @NotBlank(message = "A senha não pode ser vazia")
    private String senhaAtual;

    @Size(min = 6, max = 8, message = "A senha deve conter entre 6 e 8 caracteres")
    private String novaSenha;

    @Size(min = 6, max = 8, message = "A senha deve conter entre 6 e 8 caracteres")
    private String confimaSenha;
}
