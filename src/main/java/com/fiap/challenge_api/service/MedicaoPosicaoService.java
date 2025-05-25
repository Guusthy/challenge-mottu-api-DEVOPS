package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.MedicaoPosicaoDTO;
import com.fiap.challenge_api.mapper.MedicaoPosicaoMapper;
import com.fiap.challenge_api.model.MedicaoPosicao;
import com.fiap.challenge_api.repository.MedicaoPosicaoRepository;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicaoPosicaoService {

    @Autowired
    private MedicaoPosicaoRepository repository;

    @Autowired
    private MedicaoPosicaoMapper mapper;

    @Cacheable("medicoes")
    public List<MedicaoPosicaoDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public MedicaoPosicaoDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<MedicaoPosicaoDTO> findByPosicaoIdPosicao(Long idPosicao) {
        List<MedicaoPosicao> medicoes = repository.findByPosicaoIdPosicao(idPosicao);
        return mapper.toDtoList(medicoes);
    }

    public List<MedicaoPosicaoDTO> findByMarcadorFixoId(Long idMarcadorFixo) {
        List<MedicaoPosicao> medicoes = repository.findByMarcadorFixoIdMarcadorArucoFixo(idMarcadorFixo);
        return mapper.toDtoList(medicoes);
    }

    public Long contarPorPosicao(Long idPosicao) {
        return repository.contarMedicoesPorPosicao(idPosicao);
    }

    @CacheEvict(value = "medicoes", allEntries = true)
    public MedicaoPosicaoDTO insert(MedicaoPosicaoDTO dto){
        MedicaoPosicao medicaoPosicao = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(medicaoPosicao));
    }

    public void delete(Long id){
        MedicaoPosicao medicaoPosicao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(medicaoPosicao);
    }

}
