package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.UsuarioCreateDTO;
import com.fiap.challenge_api.dto.UsuarioDTO;
import com.fiap.challenge_api.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @Operation(summary = "Listar todos os usuários",
            description = "Retorna uma lista com todos os usuários cadastrados")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Buscar usuário por ID",
            description = "Retorna um usuário específico com base no ID informado")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Buscar usuário por e-mail",
            description = "Retorna o usuário correspondente ao e-mail informado")
    @GetMapping("/por-email")
    public ResponseEntity<UsuarioDTO> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @Operation(summary = "Cadastrar novo usuário",
            description = "Cria um novo usuário com os dados fornecidos")
    @PostMapping
    public ResponseEntity<UsuarioDTO> insert(@RequestBody @Valid UsuarioCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @Operation(summary = "Atualizar usuário",
            description = "Atualiza as informações de um usuário existente com base no ID informado")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody @Valid UsuarioDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Excluir usuário",
    description = "Remove um usuário do sistema com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
