package com.parkingapi.demoparkingapi.web.dto.mapper;

import com.parkingapi.demoparkingapi.entity.ClienteVaga;
import com.parkingapi.demoparkingapi.web.dto.EstacionamentoCreateDto;
import com.parkingapi.demoparkingapi.web.dto.EstacionamentoResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClienteVagaMapper {
    public static ClienteVaga toClienteVaga(EstacionamentoCreateDto dto){
        return new ModelMapper().map(dto, ClienteVaga.class);
    }
    public static EstacionamentoResponseDTO toDto(ClienteVaga clienteVaga){
        return new ModelMapper().map(clienteVaga, EstacionamentoResponseDTO.class);
    }
}
