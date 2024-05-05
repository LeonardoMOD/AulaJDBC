package br.ETS.almoxarifado.produto;

public record DadosProduto(int id,
                           String produto,
                           String partnumber,
                           String divisao,
                           int quantidade) {
}
