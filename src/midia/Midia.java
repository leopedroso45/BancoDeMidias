/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midia;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Leonardo Severo Pedroso
 * <leopedroso45@gmail.com>
 *
 */
public abstract class Midia {

    private String caminho;
    private String titulo;
    private String descricao;

    public Midia(String caminho, String titulo, String descricao) {
        this.setCaminho(caminho);
        this.setTitulo(titulo);
        this.setDescricao(descricao);
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) throws IllegalArgumentException {
        if (this.verificarConsistencia(caminho)) {
            throw new IllegalArgumentException("O caminho não pode ser vazio.");
        }

        this.caminho = caminho;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) throws IllegalArgumentException {
        if (this.verificarConsistencia(titulo)) {
            throw new IllegalArgumentException("O titulo não pode ser vazio.");
        }
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws IllegalArgumentException {
        if (this.verificarConsistencia(descricao)) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }

        this.descricao = descricao;
    }

    public boolean contains(String pesquisa) {
        return (this.caminho.toUpperCase()).contains(pesquisa.toUpperCase()) || (this.titulo.toUpperCase()).contains(pesquisa.toUpperCase());
    }

    @Override
    public String toString() {
        return this.caminho + "\r\n" + this.titulo + "\r\n" + this.descricao + "\r\n";
    }

    protected String listToString(List<String> lista) {
        String temp = "";
        for (String string : lista) {
            temp += string + ";";
        }
        return temp;
    }

    protected boolean verificarConsistencia(String campo) {
        return (campo == null || campo.equals("") || !(campo instanceof String));
    }

    protected boolean verificarConsistencia(List lista) {
        return (lista == null || lista.isEmpty());
    }
    
    protected boolean verificarConsistencia(int numero){
        return ((String.valueOf(numero) == null || String.valueOf(numero).equals("")) || numero < 0);
    }

    protected boolean verificarConsistenciaAno(int ano) {
        return (String.valueOf(ano) == null || String.valueOf(ano).equals("")) || (ano < 0 || ano >  LocalDateTime.now().getYear());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.caminho);
        hash = 37 * hash + Objects.hashCode(this.titulo);
        hash = 37 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Midia outro = (Midia) obj;
        
        if (!Objects.equals(this.caminho, outro.caminho)) {
            return false;
        }
        
        if (!Objects.equals(this.titulo, outro.titulo)) {
            return false;
        }
        
        if (!Objects.equals(this.descricao, outro.descricao)) {
            return false;
        }
        
        return true;
    }
    
    
}
