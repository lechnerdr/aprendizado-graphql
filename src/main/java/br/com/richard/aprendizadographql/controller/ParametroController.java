package br.com.richard.aprendizadographql.controller;

import br.com.richard.aprendizadographql.entity.TipoMultaEntity;
import br.com.richard.aprendizadographql.service.TipoContaService;
import br.com.richard.aprendizadographql.service.TipoMultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ParametroController {

    private final TipoMultaService tipoMultaService;
    private final TipoContaService tipoContaService;

    @MutationMapping
    public TipoMultaEntity cadastrarTipoMulta(@Argument @Valid CadastrarTipoMultaRequest request) {
        return tipoMultaService.cadastrarTipoMulta(request);
    }

    @MutationMapping
    public Void deletarTipoMulta(@Argument Long id) {
        tipoMultaService.deleterTipoMulta(id);
        return null;
    }

    @QueryMapping
    public TodosParametrosResponse buscarTodosParametros(@Argument Boolean ativo) {

        log.info("Buscando todos os parâmetros, no endpoint unico");

        var tiposMulta = tipoMultaService.listarTipoMultaAtivas(ativo);
        var tiposConta = tipoContaService.listarTipoConta();

        return new TodosParametrosResponse(tiposMulta, tiposConta);

    }

    @QueryMapping
    public List<TipoMultaResponse> buscarTiposMulta(@Argument Boolean ativo) {

        log.info("Buscando todos os tipos de multas, passando parametro ativo: {}", ativo);

        return tipoMultaService.listarTipoMultaAtivas(ativo).stream()
            .map(b -> new TipoMultaResponse(b.getId(), b.getCodigo(), b.getDescricao(), b.getAtivo()))
            .toList();
    }

    @QueryMapping
    public List<TipoContaResponse> buscarTiposConta() {

        log.info("Buscando todos os tipos de conta");

        return tipoContaService.listarTipoConta()
            .stream()
            .map(b -> new TipoContaResponse(b.getId(), b.getCodigo(), b.getDescricao(), b.getAtivo()))
            .toList();
    }

}
