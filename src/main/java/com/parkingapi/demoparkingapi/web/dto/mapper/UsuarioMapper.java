package com.parkingapi.demoparkingapi.web.dto.mapper;

import com.parkingapi.demoparkingapi.entity.Usuario;
import com.parkingapi.demoparkingapi.web.dto.UsuarioCreateDto;
import com.parkingapi.demoparkingapi.web.dto.UsuarioResposeDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {
    public static Usuario toUsuario(UsuarioCreateDto createDto) {
        return new ModelMapper().map(createDto, Usuario.class);
    }

    public static UsuarioResposeDto toDto(Usuario usuario) {
        String role = usuario.getRole().name().substring("ROLE_".length());
        PropertyMap<Usuario, UsuarioResposeDto> props = new PropertyMap<Usuario, UsuarioResposeDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };
        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(usuario, UsuarioResposeDto.class);
    }

    public static List<UsuarioResposeDto> toListDto(List<Usuario> usuarios) {
        return usuarios.stream().map(user -> toDto(user)).collect(Collectors.toList());
    }
}
