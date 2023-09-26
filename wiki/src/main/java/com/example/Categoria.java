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

    Categoria(String nome, String descricao, int id) {
        this.nome = nome;
        this.descricao = descricao;
        quantidade = id;
        this.id = id;
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

    public String toString(String sep) {
        return this.id + sep + this.nome + sep + this.descricao;
    }
}
