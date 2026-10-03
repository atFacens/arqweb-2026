package br.facens.minhaloja.model.dto;

import br.facens.minhaloja.model.Produto;

public class ProdutoDTO {
    private String nome;
    private double valor;

    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNome();
        this.valor = getValor();
    }

    public ProdutoDTO() {
    }

    public Produto toProduto() {
        return new Produto(null, nome, valor);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    
}
