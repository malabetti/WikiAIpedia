package com.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Categoria c1 = new Categoria("IFSP", "CAMPINAS SP");
        Categoria c2 = new Categoria("UNICAMP", "2ª BRASIL");
        Categoria c3 = new Categoria("MIT", "SONHO");

        ArrayList<Categoria> t = new ArrayList<Categoria>();
        t.add(c1);
        t.add(c2);

        Ferramenta f1 = new Ferramenta("BOCA", "JUDGE DO IF", c1);
        FerramentaCompleta f2 = new FerramentaCompleta("UNIAI", "IA DAS UNIS", c3, t, "emilhas");

        ArrayList<Ferramenta> ferramentas = new ArrayList<Ferramenta>();

        ferramentas.add(f1);
        ferramentas.add(f2);

        Arquivo fileCategorias = new Arquivo("categorias", "csv");

        fileCategorias.escreverFile(c1.toString() + "\n", true);
        fileCategorias.escreverFile(c2.toString() + "\n", false);
        fileCategorias.escreverFile(c3.toString() + "\n", true);

        Arquivo fileFerramentas = new Arquivo("ferramentas", "csv");

        fileFerramentas.escreverFile(f1.toString() + "\n", false);
        fileFerramentas.escreverFile(f2.toString() + "\n", true);
    }
}