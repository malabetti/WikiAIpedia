package main.java.com.example;

import java.util.ArrayList;

public class FerramentaCompleta extends Ferramenta {
    
    private String site;
    private ArrayList<String> categoriasExtras = new ArrayList<Categoria>();

    FerramentaCompleta(String nome, String descricao, Categoria categoriaPrincipal, ArrayList<Categoria> categoriasAdd, String site) {
        super(nome, descricao, categoriaPrincipal);
        this.site = site;
        this.categoriasExtras = categoriasAdd;
        this.completarFerramenta();
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
}
