package com.parkingapi.demoparkingapi.web.dto.mapper;

import com.parkingapi.demoparkingapi.entity.Vaga;
import com.parkingapi.demoparkingapi.web.dto.VagaCreateDto;
import com.parkingapi.demoparkingapi.web.dto.VagaResponseDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class VagaMapper {

    public static Vaga toVaga(VagaCreateDto dto) {
        return new ModelMapper().map(dto, Vaga.class);
    }

    public static VagaResponseDto toDto(Vaga vaga) {
        return new ModelMapper().map(vaga, VagaResponseDto.class);
    }
}
