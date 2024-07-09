package com.alura.forohub.controllers;

import com.alura.forohub.DTO.UsuarioSistemaDTOin;
import com.alura.forohub.DTO.UsuarioSistemaDTOout;
import com.alura.forohub.entities.UsuarioSistema;
import com.alura.forohub.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid UsuarioSistemaDTOin datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.nombreUsuario(),
                datosAutenticacionUsuario.contrasena());
        Authentication usuarioAutenticado = null;
            usuarioAutenticado = authenticationManager.authenticate(authToken);
            var JWTtoken = tokenService.generarToken((UsuarioSistema) usuarioAutenticado.getPrincipal());
            return ResponseEntity.ok(new UsuarioSistemaDTOout(JWTtoken).JWTtoken());
    }

}
