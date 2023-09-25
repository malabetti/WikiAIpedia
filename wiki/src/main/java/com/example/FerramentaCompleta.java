package com.example;

import java.util.ArrayList;

public class FerramentaCompleta extends Ferramenta {
    
    private String site;
    private ArrayList<Categoria> categoriasExtras = new ArrayList<Categoria>();

    FerramentaCompleta(String nome, String descricao, Categoria categoriaPrincipal, ArrayList<Categoria> categoriasAdd, String site) {
        super(nome, descricao, categoriaPrincipal);
        this.site = site;
        this.categoriasExtras = categoriasAdd;
        this.setCompleta();
    }

    FerramentaCompleta(Ferramenta e, ArrayList<Categoria> categoriasAdd, String site) {
        super(e.getNome(), e.getDescricao(), e.getCategoriaPrincipal());
        this.categoriasExtras = categoriasAdd;
        this.site = site;
    }

    String getSite() {
        return this.site;
    }

    ArrayList<Categoria> getCategoriasExtras() {
        return this.categoriasExtras;
    }

    void setSite(String s) {
        this.site = s;
    }

    void setCategoriasExtras(ArrayList<Categoria> categoriasAdd) {
        this.categoriasExtras = categoriasAdd;
    }

    @Override
    public String sobre() {
        ArrayList<String> nomes = new ArrayList<String>();
        for(Categoria i : categoriasExtras) {
            nomes.add(i.getNome());
        }
        return super.sobre() + "\nCategorias extras: " + nomes;
    }

    @Override
    public String toString(String sep) {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for(Categoria i : categoriasExtras) {
            ids.add(i.getId());
        }
        return super.toString(";") + sep + this.site + sep + ids;
    }
}
