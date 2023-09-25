package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Arquivo fileCategorias = new Arquivo("categorias", "csv");
        Arquivo fileFerramentas = new Arquivo("ferramentas", "csv");

        ArrayList<Ferramenta> ferramentas = new ArrayList<Ferramenta>();
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();

        Scanner scanner = new Scanner(System.in);

        if(fileCategorias.existeFile()) {
            ArrayList<String[]> arr = fileCategorias.lerFile(";");
            categorias = strToCategorias(arr);
            if(fileFerramentas.existeFile()) {
                ArrayList<String[]> arr2 = fileFerramentas.lerFile(";");
                ferramentas = strToFerramentas(arr2, categorias);
            }
            System.out.println("Dados Carregados com Sucesso!");
            System.out.print("Enter para continuar...");
            scanner.nextLine();
        }

        //Menu
        int opc = -1;
        while(opc != 7) {
            System.out.print("""
                    \n1. Adicionar Ferramenta
                    2. Remover Ferramenta
                    3. Listar Ferramentas
                    4. Editar Ferramenta
                    5. Gerenciar Categorias
                    6. Salvar e Carregar
                    7. Sair
                    ->\t""");
            opc = Integer.parseInt(scanner.nextLine());
            switch(opc) {
                case 1 -> {
                    if(categorias.size() == 0) {
                        System.out.println("\nPara criar ferramentas, é necessário ter categorias já cadastradas!");
                        System.out.print("Enter para continuar...");
                        scanner.nextLine();
                    }
                    else {

                    }
                }
                case 2 -> {

                }
                case 3 -> {

                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 6 -> {

                }
                case 7 -> {

                }
                default -> {

                }
            }
        }
    }

    static ArrayList<Categoria> strToCategorias(ArrayList<String[]> arr) {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        for(String[] i : arr) {
            categorias.add(new Categoria(i[0], i[1]));
        }
        return categorias;
    }

    static ArrayList<Ferramenta> strToFerramentas(ArrayList<String[]> arr, ArrayList<Categoria> c) {
        ArrayList<Ferramenta> ferramentas = new ArrayList<Ferramenta>();
        for(String[] i : arr) {
            Categoria a;
            for(Categoria j : c) {
                if(j.getId() == Integer.parseInt(i[1])) {
                    a = j;
                    break;
                }
            }
            Ferramenta e = new Ferramenta(i[2], i[3], a);
            if(Boolean.parseBoolean(i[0])) {
                ArrayList<Categoria> categoriasExtras = new ArrayList<Categoria>();
                i[6] = i[6].replace("[", "");
                i[6] = i[6].replace("]", "");
                String[] s = i[6].split(",");
                for(String j : s) {
                    for(Categoria k : c) {
                        if(Integer.parseInt(j) == k.getId())
                            categoriasExtras.add(k);
                    }

                }
                ferramentas.add(new FerramentaCompleta(e, categoriasExtras, i[5]));
            }
            else {
                Categoria b;
                for(Categoria j : c) {
                    if(j.getId() == Integer.parseInt(i[1])) {
                        b = j;
                        break;
                    }
                }
                ferramentas.add(new Ferramenta(i[2], i[3], b, i[1]));
            }
        }
        return ferramentas;
    }
}