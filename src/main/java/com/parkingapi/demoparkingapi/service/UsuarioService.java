package com.parkingapi.demoparkingapi.service;
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
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );
    }
    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confimaSenha) {
        if (!novaSenha.equals(confimaSenha)) {
            throw new RuntimeException("Nova senha e confirma senha não são iguais");
        }
       Usuario user = buscarPorId(id);

        if (!user.getPassword().equals(senhaAtual)) {
           throw new RuntimeException("Senha atual não confere");
       }

       user.setPassword(novaSenha);
       return user;
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }
}
