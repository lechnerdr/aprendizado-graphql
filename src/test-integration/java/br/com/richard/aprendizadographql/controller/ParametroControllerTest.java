package br.com.richard.aprendizadographql.controller;

import br.com.richard.aprendizadographql.entity.TipoContaEntity;
import br.com.richard.aprendizadographql.entity.TipoMultaEntity;
import br.com.richard.aprendizadographql.service.TipoContaService;
import br.com.richard.aprendizadographql.service.TipoMultaService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@GraphQlTest(ParametroController.class)
class ParametroControllerTest extends GraphQlBaseTeste {

    @MockBean
    private TipoMultaService tipoMultaService;

    @MockBean
    private TipoContaService tipoContaService;

    @SneakyThrows
    @Test
    void deveCriarTipoMulta() {

        var cadastrarTipoMultaRequest = new CadastrarTipoMultaRequest("123", "Multa por excesso de velocidade", true);

        when(tipoMultaService.cadastrarTipoMulta(cadastrarTipoMultaRequest))
            .thenReturn(new TipoMultaEntity(1L, "123", "Multa por excesso de velocidade", true));

        var response = getGraphQlTester().documentName("criar-tipo-multa")
            .variable("request", cadastrarTipoMultaRequest)
            .execute()
            .path("cadastrarTipoMulta")
            .entity(TipoMultaEntity.class)
            .get();

        assertAll(() -> {
            assertEquals(1L, response.getId());
            assertEquals("123", response.getCodigo());
            assertEquals("Multa por excesso de velocidade", response.getDescricao());
        });

        verify(tipoMultaService).cadastrarTipoMulta(cadastrarTipoMultaRequest);

    }

    @Test
    void deveListarTodosTiposContaETiposMultaAtivos() {

        when(tipoMultaService.listarTipoMultaAtivas(true)).thenReturn(List.of(
            new TipoMultaEntity(1L, "123", "Multa por excesso de velocidade", true),
            new TipoMultaEntity(2L, "124", "Multa por estacionar em local proibido", true)
        ));

        when(tipoContaService.listarTipoConta()).thenReturn(List.of(
            new TipoContaEntity(1L, "123", "Conta corrente", true),
            new TipoContaEntity(2L, "124", "Conta poupança", true)
        ));

        var retorno = getGraphQlTester()
            .documentName("buscar-todos-parametros-endpoint-unico")
            .variable("ativo", true)
            .execute()
            .path("buscarTodosParametros")
            .entity(TodosParametrosResponse.class)
            .get();

        assertEquals(2, retorno.tiposMulta().size());
        assertEquals(2, retorno.tiposConta().size());

        verify(tipoMultaService).listarTipoMultaAtivas(true);
        verify(tipoContaService).listarTipoConta();

    }

}