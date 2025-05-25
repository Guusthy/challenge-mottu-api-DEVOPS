package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.MarcadorArucoMovelDTO;
import com.fiap.challenge_api.service.MarcadorArucoMovelService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcadores-moveis")
public class MarcadorArucoMovelController {

    @Autowired
    private MarcadorArucoMovelService service;

    @Operation(summary = "Listar todos os marcadores móveis",
            description = "Retorna uma lista com todos os marcadores ArUco móveis cadastrados")
    @GetMapping
    public ResponseEntity<List<MarcadorArucoMovelDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Buscar marcador móvel por ID",
            description = "Retorna os dados de um marcador móvel específico pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<MarcadorArucoMovelDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Buscar marcador móvel por ID da moto",
            description = "Retorna o marcador móvel vinculado a uma moto específica")
    @GetMapping("/por-moto")
    public ResponseEntity<MarcadorArucoMovelDTO> findByMotoId(@RequestParam Long idMoto) {
        return ResponseEntity.ok(service.findByMotoId(idMoto));
    }

    @Operation(summary = "Buscar marcador móvel por código ArUco",
            description = "Retorna um marcador móvel a partir do código ArUco fornecido")
    @GetMapping("/por-codigo")
    public ResponseEntity<MarcadorArucoMovelDTO> findByCodigoAruco(@RequestParam String codigoAruco) {
        return ResponseEntity.ok(service.findByCodigoAruco(codigoAruco));
    }

    @Operation(summary = "Cadastrar novo marcador móvel",
            description = "Cria um novo marcador ArUco móvel no sistema")
    @PostMapping
    public ResponseEntity<MarcadorArucoMovelDTO> insert(@RequestBody @Valid MarcadorArucoMovelDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @Operation(summary = "Atualizar marcador móvel",
            description = "Atualiza os dados de um marcador móvel com base no ID fornecido")
    @PutMapping("/{id}")
    public ResponseEntity<MarcadorArucoMovelDTO> update(@PathVariable Long id, @RequestBody @Valid MarcadorArucoMovelDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Excluir marcador móvel",
            description = "Remove um marcador móvel com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
