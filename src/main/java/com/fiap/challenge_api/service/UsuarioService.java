package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.UsuarioCreateDTO;
import com.fiap.challenge_api.dto.UsuarioDTO;
import com.fiap.challenge_api.mapper.UsuarioMapper;
import com.fiap.challenge_api.model.Patio;
import com.fiap.challenge_api.model.Usuario;
import com.fiap.challenge_api.repository.PatioRepository;
import com.fiap.challenge_api.repository.UsuarioRepository;
import com.fiap.challenge_api.service.exception.EmailNotFoundException;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    PatioRepository patioRepository;

    @Autowired
    private UsuarioMapper mapper;

    public List<UsuarioDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public UsuarioDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public UsuarioDTO findByEmail(String email) {
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(email));
        return mapper.toDTO(usuario);
    }

    public UsuarioDTO insert(UsuarioCreateDTO dto){
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setNome(dto.getNome());


        if (dto.getPatioId() != null) {
            Patio patio = patioRepository.findById(dto.getPatioId())
                    .orElseThrow(() -> new ResourceNotFoundException(dto.getPatioId()));
            usuario.setPatio(patio);
        }

        usuario.setStatus("ativo");

        return mapper.toDTO(repository.save(usuario));
    }

    public UsuarioDTO update(Long id, UsuarioDTO dto){
        Usuario usuarioExist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        usuarioExist.setIdUsuario(dto.getIdUsuario());
        usuarioExist.setNome(dto.getNome());
        usuarioExist.setEmail(dto.getEmail());
        usuarioExist.setStatus(dto.getStatus());

        if (dto.getPatioId() != null){
            Patio patio = new Patio();
            patio.setIdPatio(dto.getPatioId());
            usuarioExist.setPatio(patio);
        }

        Usuario usuarioAtt = repository.save(usuarioExist);
        return mapper.toDTO(usuarioAtt);
    }

    public void delete(Long id){
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(usuario);
    }
}
