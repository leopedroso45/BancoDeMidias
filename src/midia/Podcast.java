/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Severo Pedroso
 * <leopedroso45@gmail.com>
 *
 */
public class Podcast extends Midia {

    private String idioma;
    private List<String> autores;
    private int ano;

    /**
     *
     * Construtor da class Podcast
     *
     * @param caminho
     * @param nome
     * @param descricao
     * @param idioma
     * @param autores
     * @param ano
     *
     */
    public Podcast(String caminho, String nome, String descricao, String idioma, List<String> autores, int ano) {
        super(caminho, nome, descricao);
        this.idioma = idioma;
        this.autores = autores;
        this.ano = ano;
    }

    /**
     *
     * Retorna o idioma atual
     *
     * @return idioma
     *
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     *
     * Altera o idioma atual, pelo idioma passado por parametro
     *
     * @param idioma
     *
     */
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    /**
     *
     * Retorna os autores atuais
     *
     * @return autores
     *
     */
    public List<String> getAutores() {
        return autores;
    }

    /**
     *
     * Altera os autores atuais, pelos autores passado por parametro
     *
     * @param autores
     *
     */
    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    /**
     *
     * Retorna o ano atual
     *
     * @return ano
     *
     */
    public int getAno() {
        return ano;
    }

    /**
     *
     * Altera o ano atual, pelo ano passado por parametro
     *
     * @param ano
     *
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    @Deprecated
    public void adicionarAutor(String autor) {
        this.autores.add(autor);
    }

    @Override
    public String toString() {
        return super.toString() + this.idioma + "\n" + super.listToString(this.autores) + "\n" + this.ano + "\n";
    }

}
