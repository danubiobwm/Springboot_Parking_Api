package com.parkingapi.demoparkingapi.web.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioCreateDto {

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "O formato do email é inválido")
    private String username;

    @Size(min = 6, max = 8, message = "A senha deve conter entre 6 e 8 caracteres")
    @NotBlank(message = "O campo senha é obrigatório")
    private String password;

}

