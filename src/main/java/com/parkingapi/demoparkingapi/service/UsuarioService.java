package com.parkingapi.demoparkingapi.service;
import com.parkingapi.demoparkingapi.exception.EntityNotFoundException;
import com.parkingapi.demoparkingapi.exception.PasswordInvalidException;
import com.parkingapi.demoparkingapi.exception.UserNameUniqueViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.parkingapi.demoparkingapi.entity.Usuario;
import com.parkingapi.demoparkingapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Transactional
    public Usuario salvar(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new UserNameUniqueViolationException(String.format("Usuário {%s}, já existe", usuario.getUsername()));
        }
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário id={%s} não encontrado", id))
        );
    }
    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confimaSenha) {
        if (!novaSenha.equals(confimaSenha)) {
            throw new PasswordInvalidException("Nova senha e confirma senha não são iguais");
        }
       Usuario user = buscarPorId(id);

        if (!user.getPassword().equals(senhaAtual)) {
           throw new PasswordInvalidException("Senha atual não confere");
       }

       user.setPassword(novaSenha);
       return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario com '%s' não encontrado", username))
        );
    }

    @Transactional(readOnly = true)
    public Usuario.Role buscarRolePorUsername(String username) {
        return usuarioRepository.findRoleByUsername(username);
    }
}
