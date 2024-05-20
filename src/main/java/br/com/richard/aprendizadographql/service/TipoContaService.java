package br.com.richard.aprendizadographql.service;

import br.com.richard.aprendizadographql.entity.TipoContaEntity;
import br.com.richard.aprendizadographql.respository.TipoContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoContaService {

    private final TipoContaRepository tipoContaRepository;

    public List<TipoContaEntity> listarTipoConta() {
        return (List<TipoContaEntity>) tipoContaRepository.findAll();
    }

}
