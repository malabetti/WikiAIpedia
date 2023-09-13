package main.java.com.example;

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

    void completarFerramenta() {
        this.completa = true;
    }
}
