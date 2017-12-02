/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.List;

import midia.Midia;

/**
 *
 * @author Leonardo Severo Pedroso / Gustavo Bittencourt Satheler
 * <leopedroso45@gmail.com>
 * <gustavosatheler@gmail.com>
 */
public interface IColecao {

    /**
     * Adiciona uma mídia a coleção.
     *
     * @param midia Midia a ser inserida.
     */
    public void cadastrarMidia(Midia midia);

    /**
     * Remove a Midia com a palavra informada.
     *
     * @param pesquisa Parâmetro utilizado para a pesquisa.
     * @return True se a nota for removida com sucesso e False caso contrário.
     */
    public boolean removerMidia(String pesquisa);

    /**
     * Altera a mídia com a palavra informada.
     *
     * @param pesquisa Parâmetro utilizado para a pesquisa.
     * @param midia Midia com as novas informações.
     * @return True se a mídia foi corretamente atualizada e False caso
     * contrário.
     */
    public boolean editarMidia(String pesquisa, Midia midia);

    /**
     * Exibe a primeira mídia encontrada na coleção que contém a palavra
     * pesquisada.
     *
     * @param pesquisa Parâmetro utilizado para a pesquisa.
     * @return Uma lista de mídias com a palavra pesquisada.
     */
    public Midia consultarMidia(String pesquisa);

    /**
     * Exibe todas as mídias adicionadas a coleção que contém a palavra
     * pesquisada.
     *
     * @param pesquisa Parâmetro utilizado para a pesquisa.
     * @return Uma lista de mídias com a palavra pesquisada.
     */
    public List consultarMidias(String pesquisa);

    /**
     * Exibe todas as mídias adicionadas a coleção.
     *
     * @return Uma Lista de com todas as mídias.
     */
    public List exibirMidia();

    /**
     * Adiciona uma ou várias mídias a coleção a partir de um arquivo de texto.
     *
     * @param caminhoArquivo Caminho do arquivo
     * @throws java.lang.NumberFormatException
     * @throws java.lang.NullPointerException
     * @throws java.io.IOException
     */
    public void importarMidias(String caminhoArquivo) throws NumberFormatException, NullPointerException, IOException;

    /**
     * Exporta a partir de uma lista de mídias de uma coleção para um arquivo de
     * texto.
     *
     * @param nomeArquivo Caminho do arquivo
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     * @throws java.io.IOException
     */
    public void exportarMidias(String nomeArquivo) throws FileNotFoundException, UnsupportedEncodingException, IOException;

    /**
     * Ordena o a lista de coleção.
     *
     */
    public void ordenar();
}
