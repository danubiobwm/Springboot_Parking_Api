package com.parkingapi.demoparkingapi.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioResposeDto {
    private Long id;
    private String username;
    private  String role;
}
