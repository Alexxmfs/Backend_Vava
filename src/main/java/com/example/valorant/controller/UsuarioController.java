package com.example.valorant.controller;

import com.example.valorant.service.UsuarioService;
import com.example.valorant.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastro")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/auth")
    public ResponseEntity<?> loginUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.buscarPorEmail(usuario.getEmail());
        if (usuarioExistente != null) {
            String senhaArmazenada = usuarioExistente.getSenha();
            String senhaFornecida = usuario.getSenha();
            if (usuarioService.verificarSenha(senhaFornecida, senhaArmazenada)) {
                System.out.println("Login bem-sucedido");
                return ResponseEntity.ok(usuarioExistente);
            } else {
                System.out.println("Senha incorreta");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }
        } else {
            System.out.println("Usuário não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }
}
