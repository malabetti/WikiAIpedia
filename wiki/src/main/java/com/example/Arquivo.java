package com.example;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    private File file;
    private FileWriter writer;
    private FileReader reader;
    private BufferedReader bufferedReader;
    private String nome;
    private String tipo;

    Arquivo(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        file = new File(this.nome + "." + this.tipo);
    }

    ArrayList<String[]> lerFile(String sep) {
        try {
            this.reader = new FileReader(this.file);
            this.bufferedReader = new BufferedReader(this.reader);
            ArrayList<String[]> linhas = new ArrayList<String[]>();
            String linha;
            while((linha = bufferedReader.readLine()) != null){
                linhas.add(linha.split(sep));
            }
            bufferedReader.close();
            return linhas;
        }
        catch (IOException e) {
            System.out.println("Erro: " + e);
            return null;
        }
    }

    boolean existeFile() {
        return this.file.exists();
    }

    boolean escreverFile(String line, boolean x) {
        try {
            writer = new FileWriter(file, x);
            writer.write(line);
            writer.close();
            return true;
        }
        catch (IOException e) {
            System.out.println("Erro: " + e);
            return false;
        }
    }

    @Override
    public String toString() {
        return "File: " + this.nome + "." + this.tipo;
    }
}
