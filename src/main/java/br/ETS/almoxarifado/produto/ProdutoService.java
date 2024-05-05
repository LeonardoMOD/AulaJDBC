package br.ETS.almoxarifado.produto;

import br.ETS.almoxarifado.RegraDaAplicacaoException;

import java.util.ArrayList;

public class ProdutoService {
   private ArrayList<Produto> produtos = new ArrayList<>();


    public void adicionarNovoProduto(DadosProduto dadosProduto){
        var produto = new Produto(dadosProduto);
        if(produtos.contains(produto)){
            throw new RegraDaAplicacaoException("Já existe um tipo de produto com este ID");
        }
        produtos.add(produto);
    }

    public ArrayList<Produto> exibirProdutosDoAlmoxarifado(){
        return produtos;
    }

    public Produto encontrarProdutoPeloID(int id) {
     return produtos
             .stream()
             .filter(produto -> produto.getId() == id)
             .findFirst()
             .orElseThrow(()-> new RegraDaAplicacaoException("Produto com este ID não foi encontrado"));
    }

    /*alterado o corpo do método de adicionarQuantidadeDeUmProduto*/
    public void adicionarQuantidadeDeUmProduto(int id, int quantiadadeASerAdicionada){
        var produto = encontrarProdutoPeloID(id);
        if (quantiadadeASerAdicionada <= 0){
            throw new RegraDaAplicacaoException("Quantidade a ser adicionada deve ser maior que 0");
        }
        produto.setQuantidade(produto.getQuantidade() + quantiadadeASerAdicionada);

    }

    /*alterado o corpo do método de removerQuantidadeDeUmProduto*/
    public void removerQuantidadeDeUmProduto(int id, int quantiadadeASerRemovida){
        var produto = encontrarProdutoPeloID(id);
        if (quantiadadeASerRemovida <= 0){
            throw new RegraDaAplicacaoException("Quantidade a ser adicionada deve ser maior que 0");
        }
        if(produto.getQuantidade() < quantiadadeASerRemovida ){
            throw new RegraDaAplicacaoException("Essa determinada quantidade não está disponivel");
        }
        produto.setQuantidade(produto.getQuantidade() - quantiadadeASerRemovida);
    }

    /* adicionando o removerOProdutoDoAlmoxarifado*/
    public void removerOProdutoDoAlmoxarifado(int id){
        var produto = encontrarProdutoPeloID(id);
        produtos.remove(produto);
    }


}

