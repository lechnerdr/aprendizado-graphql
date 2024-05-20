package br.com.richard.aprendizadographql.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastrarTipoMultaRequest(@NotBlank String codigo,
                                        @NotBlank String descricao,
                                        @NotNull Boolean ativo) {}
