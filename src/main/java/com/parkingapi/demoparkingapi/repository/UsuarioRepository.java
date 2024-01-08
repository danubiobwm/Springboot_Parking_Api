package com.parkingapi.demoparkingapi.repository;

import com.parkingapi.demoparkingapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}