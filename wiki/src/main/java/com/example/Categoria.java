package com.example;

import java.util.ArrayList;

public class Categoria {

    static int quantidade = 0;
    static ArrayList<Categoria> categorias = new ArrayList<Categoria>();

    private String nome;
    private String descricao;
    private int id;

    Categoria(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        quantidade++;
        this.id = quantidade;
        categorias.add(this);
    }

    String getNome() {
        return this.nome;
    }

    String getDescricao() {
        return this.descricao;
    }

    int getId() {
        return this.id;
    }

    void setNome(String s) {
        this.nome = s;
    } 

    void setDescricao(String s) {
        this.descricao = s;
    }

    public String sobre() {
        return "Nome: " + this.nome +
                "\nDescrição: " + this.descricao +
                "\nId: " + this.id;
    }

    @Override
    public String toString() {
        return this.id + "," + this.nome + "," + this.descricao;
    }
}
