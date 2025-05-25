package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.MarcadorArucoMovelDTO;
import com.fiap.challenge_api.mapper.MarcadorArucoMovelMapper;
import com.fiap.challenge_api.model.MarcadorArucoMovel;
import com.fiap.challenge_api.model.Moto;
import com.fiap.challenge_api.repository.MarcadorArucoMovelRepository;
import com.fiap.challenge_api.service.exception.MarcadorNotFoundException;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MarcadorArucoMovelService {

    @Autowired
    private MarcadorArucoMovelRepository repository;

    @Autowired
    private MarcadorArucoMovelMapper mapper;

    public List<MarcadorArucoMovelDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public MarcadorArucoMovelDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public MarcadorArucoMovelDTO findByMotoId(Long motoId) {
        return repository.findByMoto_IdMoto(motoId)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(motoId));
    }

    public MarcadorArucoMovelDTO findByCodigoAruco(String codigo) {
        return repository.findByCodigoAruco(codigo)
                .map(mapper::toDTO)
                .orElseThrow(() -> new MarcadorNotFoundException(codigo));
    }

    public MarcadorArucoMovelDTO insert(MarcadorArucoMovelDTO dto){
        MarcadorArucoMovel marcadorArucoMovel = mapper.toEntity(dto);
        marcadorArucoMovel.setDataInstalacao(LocalDate.now());
        return mapper.toDTO(repository.save(marcadorArucoMovel));
    }

    public MarcadorArucoMovelDTO update(Long id,MarcadorArucoMovelDTO dto){
        MarcadorArucoMovel marcadorExist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        marcadorExist.setCodigoAruco(dto.getCodigoAruco());

        if (dto.getIdMoto() != null) {
            Moto moto = new Moto();
            moto.setIdMoto(dto.getIdMoto());
            marcadorExist.setMoto(moto);
        }
        MarcadorArucoMovel marcadorAtt = repository.save(marcadorExist);
        return mapper.toDTO(marcadorAtt);
    }

    public void delete(Long id){
        MarcadorArucoMovel marcadorArucoMovel = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(marcadorArucoMovel);
    }


}
