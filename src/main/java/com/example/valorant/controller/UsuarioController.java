package com.example.valorant.controller;

import com.example.valorant.service.UsuarioService;
import com.example.valorant.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/login")
    public String loginUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.buscarPorEmail(usuario.getEmail());
        if (usuarioExistente != null && usuarioService.verificarSenha(usuario.getSenha(), usuarioExistente.getSenha())) {
            return "Login bem-sucedido!";
        } else {
            return "Credenciais inválidas!";
        }
    }
}
