package br.com.richard.aprendizadographql.controller;

import br.com.richard.aprendizadographql.entity.TipoContaEntity;
import br.com.richard.aprendizadographql.entity.TipoMultaEntity;

import java.util.List;

public record TodosParametrosResponse(List<TipoMultaEntity> tiposMulta,
                                      List<TipoContaEntity> tiposConta) {
}
