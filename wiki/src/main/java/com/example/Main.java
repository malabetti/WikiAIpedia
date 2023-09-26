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
                    if(ferramentas.size() == 0) {
                        System.out.println("\nPara remover ferramentas, é necessário ter ferramentas já cadastradas!");
                        System.out.print("Enter para continuar...");
                        scanner.nextLine();
                    }
                    else {
                        System.out.println("Digite o id da ferramenta que deseja remover.");
                        System.out.print("Enter para continuar...");
                        scanner.nextLine();
                        for(Ferramenta i : ferramentas) {
                            System.out.println("---------");
                            System.out.println(i.sobre());
                        }
                        System.out.print("---------\n-> ");
                        int id = Integer.parseInt(scanner.nextLine());
                        for(Ferramenta i : ferramentas) {
                            if(i.getId() == id) {
                                ferramentas.remove(i);
                                System.out.println("Ferramenta removida!");
                                System.out.print("Enter para continuar...");
                                scanner.nextLine();
                                break;
                            }
                        }
                    }
                 }
                case 3 -> {
                    if(ferramentas.size() == 0) {
                        System.out.println("\nPara listar ferramentas, é necessário ter ferramentas já cadastradas!");
                    }
                    else {
                        for(Ferramenta i : ferramentas) {
                            System.out.println("---------");
                            System.out.println(i.sobre());
                        }
                        System.out.println("---------");
                    }
                }
                case 4 -> {
                    if(ferramentas.size() == 0) {
                        System.out.println("\nPara editar ferramentas, é necessário ter ferramentas já cadastradas!");
                        System.out.print("Enter para continuar...");
                        scanner.nextLine();
                    }
                    else {
                        System.out.println("Digite o id da ferramenta que deseja editar.");
                        System.out.print("Enter para continuar...");
                        scanner.nextLine();
                        for(Ferramenta i : ferramentas) {
                            System.out.println("---------");
                            System.out.println(i.sobre());
                        }
                        System.out.print("---------\n-> ");
                        int id = Integer.parseInt(scanner.nextLine());
                        int pos = 0;
                        for(Ferramenta i : ferramentas) {
                            if(i.getId() == id) {
                                System.out.println("O que deseja editar:");
                                if(i.getCompleta()){
                                    System.out.print("""
                                        1. Nome
                                        2. Descrição
                                        3. Categoria Principal
                                        4. Reconfigurar Categoria Completa
                                        5. Sair
                                        ->\t""");
                                    int o = Integer.parseInt(scanner.nextLine());
                                    switch (o) {
                                        case 1 -> {
                                            System.out.print("Digite o nome: ");
                                            i.setNome(scanner.nextLine());
                                            System.out.println("Nome alterado com sucesso!");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();
                                        }
                                        case 2 -> {
                                            System.out.print("Digite a decrição: ");
                                            i.setDescricao(scanner.nextLine());
                                            System.out.println("Descrição alterada com sucesso!");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();
                                        }
                                        case 3 -> {
                                            System.out.println("Das seguintes categorias, selecione o id da categoria principal:");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();

                                            for(Categoria j : categorias) {
                                                System.out.println("---------");
                                                System.out.println(j.sobre());
                                            }
                                            System.out.print("---------\n-> ");
                                            int idt = Integer.parseInt(scanner.nextLine());

                                            Categoria principal = i.getCategoriaPrincipal();
                                            for(Categoria j : categorias) {
                                                if(i.getId() == idt) {
                                                    principal = j;
                                                    break;
                                                }
                                            }
                                            i.setCategoriaPrincipal(principal);
                                            System.out.println("Categoria principal alterada com sucesso!");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();
                                        }
                                        case 4 -> {
                                            System.out.print("Digite o site da ferramenta: ");
                                            String site = scanner.nextLine();
                                            System.out.print("Escolha o id das categorias extras separados por espaços:");
                                            ArrayList<Integer> ids = new ArrayList<Integer>();
                                            ArrayList<Categoria> extras = new ArrayList<Categoria>();
                                            String[] s = scanner.nextLine().split(" ");
                                            for(String r : s) {
                                                for(Categoria j : categorias) {
                                                    if(j.getId() == Integer.parseInt(r)) {
                                                        extras.add(j);
                                                    }
                                                }
                                            }
                                            if(categorias.size() == 0) {
                                                System.out.println("Ids digitados são inválidos!");
                                                System.out.print("Enter para continuar...");
                                                scanner.nextLine();
                                            }
                                            else {
                                                ferramentas.set(pos, new FerramentaCompleta(i, extras, site));
                                                System.out.println("Ferramenta completada com sucesso!");
                                                System.out.print("Enter para continuar...");
                                                scanner.nextLine();
                                            }
                                        }
                                        case 5 -> {
                                            break;
                                        }
                                        default -> {
                                            System.out.println("Opção inválida!");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();
                                        }
                                    }
                                    System.out.print("Enter para continuar...");
                                    scanner.nextLine();
                                }
                                else {
                                    System.out.print("""
                                        1. Nome
                                        2. Descrição
                                        3. Categoria Principal
                                        4. Tornar Completa
                                        5. Sair
                                        ->\t""");
                                    int o = Integer.parseInt(scanner.nextLine());
                                    switch (o) {
                                        case 1 -> {
                                            System.out.print("Digite o nome: ");
                                            i.setNome(scanner.nextLine());
                                            System.out.println("Nome alterado com sucesso!");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();
                                        }
                                        case 2 -> {
                                            System.out.print("Digite a decrição: ");
                                            i.setDescricao(scanner.nextLine());
                                            System.out.println("Descrição alterada com sucesso!");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();
                                        }
                                        case 3 -> {
                                            System.out.println("Das seguintes categorias, selecione o id da categoria principal:");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();

                                            for(Categoria j : categorias) {
                                                System.out.println("---------");
                                                System.out.println(j.sobre());
                                            }
                                            System.out.print("---------\n-> ");
                                            int idt = Integer.parseInt(scanner.nextLine());

                                            Categoria principal = i.getCategoriaPrincipal();
                                            for(Categoria j : categorias) {
                                                if(i.getId() == idt) {
                                                    principal = j;
                                                    break;
                                                }
                                            }
                                            i.setCategoriaPrincipal(principal);
                                            System.out.println("Categoria principal alterada com sucesso!");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();
                                        }
                                        case 4 -> {
                                            System.out.print("Digite o site da ferramenta: ");
                                            String site = scanner.nextLine();
                                            System.out.print("Escolha o id das categorias extras separados por espaços:");
                                            ArrayList<Integer> ids = new ArrayList<Integer>();
                                            ArrayList<Categoria> extras = new ArrayList<Categoria>();
                                            String[] s = scanner.nextLine().split(" ");
                                            for(String r : s) {
                                                for(Categoria j : categorias) {
                                                    if(j.getId() == Integer.parseInt(r)) {
                                                        extras.add(j);
                                                    }
                                                }
                                            }
                                            if(categorias.size() == 0) {
                                                System.out.println("Ids digitados são inválidos!");
                                                System.out.print("Enter para continuar...");
                                                scanner.nextLine();
                                            }
                                            else {
                                                ferramentas.set(pos, new FerramentaCompleta(i, extras, site));
                                                System.out.println("Ferramenta completada com sucesso!");
                                                System.out.print("Enter para continuar...");
                                                scanner.nextLine();
                                            }
                                        }
                                        case 5 -> {
                                            break;
                                        }
                                        default -> {
                                            System.out.println("Opção inválida!");
                                            System.out.print("Enter para continuar...");
                                            scanner.nextLine();
                                        }
                                    }
                                }

                            }
                            pos++;
                        }
                    }
                }
                case 5 -> {
                    System.out.println("O que deseja realizar:");
                    System.out.print("""
                                        1. Adicionar categoria
                                        2. Deletar categoria
                                        3. Editar categoria
                                        4. Sair
                                        ->\t""");
                    int o = Integer.parseInt(scanner.nextLine());
                    switch(o) {
                        case 1 -> {
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Descrição: ");
                            String descricao = scanner.nextLine();
                            categorias.add(new Categoria(nome, descricao));
                            System.out.println("Categoria adiconada com sucesso!");
                            System.out.print("Enter para continuar...");
                            scanner.nextLine();
                        }
                        case 2 -> {
                            if(categorias.size() == 0) {
                                System.out.println("Não há categorias cadastradas!");
                                System.out.print("Enter para continuar...");
                                scanner.nextLine();
                            }
                            else {
                                System.out.println("Certifique-se de não ter nenhuma ferramenta cadastrada a categoria que deseje remover!");
                                System.out.println("Das seguintes categorias, selecione o id da categoria que deseja remover:");
                                System.out.print("Enter para continuar...");
                                scanner.nextLine();

                                for(Categoria j : categorias) {
                                    System.out.println("---------");
                                    System.out.println(j.sobre());
                                }
                                System.out.print("---------\n-> ");
                                int id = Integer.parseInt(scanner.nextLine());

                                for(Categoria j : categorias) {
                                    if(j.getId() == id) {
                                        categorias.remove(j);
                                        System.out.println("Categoria removida com sucesso!");
                                        System.out.print("Enter para continuar...");
                                        scanner.nextLine();
                                        break;
                                    }
                                }
                            }
                        }
                        case 3 -> {
                            if(categorias.size() == 0) {
                                System.out.println("Não há categorias cadastradas!");
                                System.out.print("Enter para continuar...");
                                scanner.nextLine();
                            }
                            else {
                                System.out.println("Das seguintes categorias, selecione o id da categoria que deseja editar:");
                                System.out.print("Enter para continuar...");
                                scanner.nextLine();

                                for(Categoria j : categorias) {
                                    System.out.println("---------");
                                    System.out.println(j.sobre());
                                }
                                System.out.print("---------\n-> ");
                                int id = Integer.parseInt(scanner.nextLine());

                                for(Categoria j : categorias) {
                                    if(j.getId() == id) {
                                        System.out.println("O que deseja editar:");
                                        System.out.print("""
                                        1. Nome
                                        2. Descrição
                                        3. Sair
                                        ->\t""");
                                        int o2 = Integer.parseInt(scanner.nextLine());
                                        switch(o2) {
                                            case 1 -> {
                                                System.out.print("Digite o nome: ");
                                                j.setNome(scanner.nextLine());
                                                System.out.println("Nome alterado com sucesso!");
                                                System.out.print("Enter para continuar...");
                                                scanner.nextLine();
                                            }
                                            case 2 -> {
                                                System.out.print("Digite a decrição: ");
                                                j.setDescricao(scanner.nextLine());
                                                System.out.println("Descrição alterada com sucesso!");
                                                System.out.print("Enter para continuar...");
                                                scanner.nextLine();
                                            }
                                            case 3 -> {
                                                break;
                                            }
                                            default -> {
                                                System.out.println("Opção inválida!");
                                                System.out.print("Enter para continuar...");
                                                scanner.nextLine();
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                        case 4 -> {
                            break;
                        }
                        default -> {
                            System.out.println("Opção inválida!");
                            System.out.print("Enter para continuar...");
                            scanner.nextLine();
                        }
                    }
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
                if(j.getId() == Integer.parseInt(i[4])) {
                    a = j;
                    break;
                }
            }
            Ferramenta e = new Ferramenta(i[2], i[3], a);
            if(Boolean.parseBoolean(i[0])) {
                ArrayList<Categoria> categoriasExtras = new ArrayList<Categoria>();
                i[6] = i[6].replace("[", "");
                i[6] = i[6].replace("]", "");
                i[6] = i[6].replace(" ", "");
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