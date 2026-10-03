package br.facens.minhaloja.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // tabela no BD
public class Produto {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3, 4...
    private Integer id;
    private String nome;
    private double valor;

    public Produto() {
    }

    public Produto(Integer id, String nome, double valor) {
        if (id != null) {
            this.id = id;
        }
        this.nome = nome;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
