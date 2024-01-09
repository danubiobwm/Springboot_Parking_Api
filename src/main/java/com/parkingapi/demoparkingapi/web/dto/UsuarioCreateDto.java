package com.parkingapi.demoparkingapi.web.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioCreateDto {
    @NonNull
    private String username;
    @NonNull
    private String password;

}

