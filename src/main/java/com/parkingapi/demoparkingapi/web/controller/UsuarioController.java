package com.parkingapi.demoparkingapi.web.controller;


import com.parkingapi.demoparkingapi.entity.Usuario;
import com.parkingapi.demoparkingapi.service.UsuarioService;
import com.parkingapi.demoparkingapi.web.dto.UsuarioCreateDto;
import com.parkingapi.demoparkingapi.web.dto.UsuarioResponseDto;
import com.parkingapi.demoparkingapi.web.dto.UsuarioSenhaDto;
import com.parkingapi.demoparkingapi.web.dto.mapper.UsuarioMapper;
import com.parkingapi.demoparkingapi.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuários",
        description = "Contém todas as operações relacionadas aos recursos de cadastro " +
                "de usuários, editar senha e buscar todos os usuários")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Operation(summary = "Criar um novo usuário",
            description = "Cria um novo usuário",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Usuário criado com sucesso",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UsuarioResponseDto.class))),
                    @ApiResponse(responseCode = "409",
                            description = "Já existe um usuário com o email informado",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "422",
                            description = "Recursos não processados por dados de entrada inválidos",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)))
            })
    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto createDto) {
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @Operation(summary = "Buscar um usuário por id",
            description = "Buscar um usuário por id",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Recurso recuperado com  sucesso",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UsuarioResponseDto.class))),

                    @ApiResponse(responseCode = "404",
                            description = "Recursos não encontrado",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)))
            })
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id) {
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }


    @Operation(summary = "Editar senha de um usuário",
            description = "Editar senha de um usuário",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Senha editada com sucesso"),

                    @ApiResponse(responseCode = "404",
                            description = "Recursos não encontrado",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Void.class))),
                    @ApiResponse(responseCode = "422",
                            description = "Recursos não processados por dados de entrada inválidos",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)))
            })
    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @Valid @RequestBody UsuarioSenhaDto dto) {
        Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(), dto.getConfimaSenha());
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar todos os usuários",
            description = "Buscar todos os usuários",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Recursos recuperados com sucesso",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = UsuarioResponseDto.class))),

                    @ApiResponse(responseCode = "404",
                            description = "Recursos não encontrado",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorMessage.class)))
            })
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> getAll() {
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(UsuarioMapper.toListDto(users));
    }
}
