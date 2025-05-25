package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.PosicaoDTO;
import com.fiap.challenge_api.service.PosicaoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posicoes")
public class PosicaoController {

    @Autowired
    private PosicaoService service;

    @Operation(summary = "Listar todas as posições",
            description = "Retorna uma lista com todas as posições registradas")
    @GetMapping
    public ResponseEntity<List<PosicaoDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Listar posições por ID da moto",
            description = "Retorna todas as posições associadas à moto com o ID fornecido")
    @GetMapping("/moto/{motoId}")
    public ResponseEntity<List<PosicaoDTO>> findByMotoId(@PathVariable Long motoId) {
        return ResponseEntity.ok(service.findByMotoId(motoId));
    }

    @Operation(summary = "Listar as 10 últimas posições registradas",
            description = "Retorna as últimas 10 posições ordenadas pela data/hora de registro")
    @GetMapping("/ultimas")
    public ResponseEntity<List<PosicaoDTO>> findTop10ByOrderByDataHoraDesc() {
        return ResponseEntity.ok(service.findTop10ByOrderByDataHoraDesc());
    }

    @Operation(summary = "Buscar histórico de posições da moto",
            description = "Retorna o histórico completo de posições associadas a uma moto específica")
    @GetMapping("/historico/{motoId}")
    public ResponseEntity<List<PosicaoDTO>> buscarHistoricoDaMoto(@PathVariable Long motoId) {
        return ResponseEntity.ok(service.buscarHistoricoDaMoto(motoId));
    }

    @Operation(summary = "Listar posições de motos indisponíveis",
            description = "Retorna todas as posições em que há motos marcadas como indisponíveis")
    @GetMapping("/indisponiveis")
    public ResponseEntity<List<PosicaoDTO>> findPosicoesDeMotosIndisponiveis() {
        return ResponseEntity.ok(service.findPosicoesDeMotosIndisponiveis());
    }

    @Operation(summary = "Cadastrar nova posição",
            description = "Insere uma nova posição no sistema")
    @PostMapping
    public ResponseEntity<PosicaoDTO> insert(@RequestBody @Valid PosicaoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @Operation(summary = "Atualizar posição",
            description = "Atualiza os dados de uma posição com base no ID fornecido")
    @PutMapping("/{id}")
    public ResponseEntity<PosicaoDTO> update(@PathVariable Long id, @RequestBody @Valid PosicaoDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Excluir posição",
            description = "Remove uma posição do sistema com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id, @RequestBody @Valid PosicaoDTO dto){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
