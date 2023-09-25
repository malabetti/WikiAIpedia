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
                        System.out.print("Nome da ferramenta: ");
                        String nome = scanner.nextLine();
                        System.out.print("Descrição da ferramenta: ");
                        String descricao = scanner.nextLine();
                        System.out.println("Das seguintes categorias, selecione o id da categoria principal:");
                        System.out.print("Enter para continuar...");
                        scanner.nextLine();

                        for(Categoria i : categorias) {
                            System.out.println("---------");
                            System.out.println(i.sobre());
                        }
                        System.out.print("---------\n-> ");
                        int id = Integer.parseInt(scanner.nextLine());

                        Categoria principal = null;
                        for(Categoria i : categorias) {
                            if(i.getId() == id) {
                                principal = i;
                                break;
                            }
                        }
                        if(principal == null) {
                            System.out.println("Id digitado é inválido!");
                            System.out.print("Enter para continuar...");
                            scanner.nextLine();
                        }
                        else {
                            System.out.print("Você deseja adicionar uma ferramenta completa (s/n) ? ");
                            char c = scanner.nextLine().toLowerCase().charAt(0);
                            if(c == 's') {
                                System.out.print("Digite o site da ferramenta: ");
                                String site = scanner.nextLine();
                                System.out.print("Escolha o id das categorias extras separados por espaços:");
                                ArrayList<Integer> ids = new ArrayList<Integer>();
                                ArrayList<Categoria> extras = new ArrayList<Categoria>();
                                String[] s = scanner.nextLine().split(" ");
                                for(String r : s) {
                                    for(Categoria i : categorias) {
                                        if(i.getId() == Integer.parseInt(r)) {
                                            extras.add(i);
                                        }
                                    }
                                }
                                if(categorias.size() == 0) {
                                    System.out.println("Ids digitados são inválidos!");
                                    System.out.print("Enter para continuar...");
                                    scanner.nextLine();
                                }
                                else {
                                    Ferramenta x = new FerramentaCompleta(nome, descricao, principal, extras, site);
                                    ferramentas.add(x);
                                    System.out.println("Ferramenta adicionada com sucesso!");
                                    System.out.print("Enter para continuar...");
                                    scanner.nextLine();
                                }
                            }
                            else {
                                ferramentas.add(new Ferramenta(nome, descricao, principal));
                                System.out.println("Ferramenta adicionada com sucesso!");
                                System.out.print("Enter para continuar...");
                                scanner.nextLine();
                            }
                        }
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
                    System.out.println("Você deseja:");
                    System.out.println("1. Carregar dados");
                    System.out.println("2. Salvar dados");
                    System.out.print("-> ");
                    int o = Integer.parseInt(scanner.nextLine());

                    if(o == 1) {
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
                    }
                    else if(o == 2) {
                        int t = 0;
                        for(Categoria i : categorias) {
                            if(t == 0) {
                                fileCategorias.escreverFile(i.toString(";")+"\n", false);
                            }
                            else {
                                fileCategorias.escreverFile(i.toString(";")+"\n", true);
                            }
                            t++;
                        }
                        t = 0;
                        for(Ferramenta i : ferramentas) {
                            if(t == 0) {
                                fileFerramentas.escreverFile(i.toString(";")+"\n", false);
                            }
                            else {
                                fileFerramentas.escreverFile(i.toString(";")+"\n", true);
                            }
                            t++;
                        }
                        System.out.println("Dados Salvos com Sucesso!");
                        System.out.print("Enter para continuar...");
                        scanner.nextLine();
                    }
                    else {
                        System.out.println("Opção inválida!");
                        System.out.print("Enter para continuar...");
                        scanner.nextLine();
                    }
                }
                case 7 -> {
                    System.out.println("Saindo!");
                    System.out.print("Enter para continuar...");
                    scanner.nextLine();
                }
                default -> {
                    System.out.println("Opção inválida!");
                    System.out.print("Enter para continuar...");
                    scanner.nextLine();
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
            Categoria a = null;
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
                Categoria b = null;
                for(Categoria j : c) {
                    if(j.getId() == Integer.parseInt(i[1])) {
                        b = j;
                        break;
                    }
                }
                ferramentas.add(new Ferramenta(i[2], i[3], b, Integer.parseInt(i[1])));
            }
        }
        return ferramentas;
    }
}