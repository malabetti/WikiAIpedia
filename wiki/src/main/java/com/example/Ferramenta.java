package com.example;

import java.util.ArrayList;

public class Ferramenta {

    static int quantidade = 0;
    
    private int id;
    private String nome;
    private String descricao;
    private Categoria categoriaPrincial;
    private boolean completa = false;

    Ferramenta(String nome, String descricao, Categoria categoriaPrincipal) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoriaPrincial = categoriaPrincipal;
        quantidade++;
        this.id = quantidade;
    }

    Ferramenta(String nome, String descricao, Categoria categoriaPrincipal, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoriaPrincial = categoriaPrincipal;
        this.id = id;
        quantidade = id;
    }

    String getNome() {
        return this.nome;
    }

    String getDescricao() {
        return this.descricao;
    }

    Categoria getCategoriaPrincipal() {
        return this.categoriaPrincial;
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

    void setCategoriaPrincipal(Categoria s) {
        this.categoriaPrincial = s;
    } 

    FerramentaCompleta completarFerramenta(ArrayList<Categoria> categoriasAdd, String site) {
        this.completa = true;
        return new FerramentaCompleta(this, categoriasAdd, site);
    }

    void setCompleta() {
        this.completa = true;
    }

    public String toString(String sep) {
        return this.completa + sep + this.id + sep + this.nome + sep + this.descricao + sep + this.categoriaPrincial.getId();
    }

    public String sobre() {
        return "Nome: " + this.nome +
                "\nDescrição: " + this.descricao +
                "\nId: " + this.id +
                "\nCompleta: " + this.completa +
                "\nCategoria principal: " + this.categoriaPrincial.getNome();
    }
}
