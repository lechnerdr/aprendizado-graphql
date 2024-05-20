package br.com.richard.aprendizadographql.service;

import br.com.richard.aprendizadographql.controller.CadastrarTipoMultaRequest;
import br.com.richard.aprendizadographql.entity.TipoMultaEntity;
import br.com.richard.aprendizadographql.respository.TipoMultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoMultaService {

    private final TipoMultaRepository tipoMultaRepository;

    public TipoMultaEntity cadastrarTipoMulta(CadastrarTipoMultaRequest request) {

        var tipoMulta = new TipoMultaEntity();
        tipoMulta.setCodigo(request.codigo());
        tipoMulta.setDescricao(request.descricao());
        tipoMulta.setAtivo(request.ativo());

        return tipoMultaRepository.save(tipoMulta);

    }

    public List<TipoMultaEntity> listarTipoMultaAtivas(boolean  ativo) {
        return tipoMultaRepository.findAllByAtivo(ativo);
    }

    public void deleterTipoMulta(Long id) {
        tipoMultaRepository.deleteById(id);
    }

}
