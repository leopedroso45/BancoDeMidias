/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecao;

import midia.Midia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Severo Pedroso / Gustavo Bittencourt Satheler
 * <leopedroso45@gmail.com>
 * <gustavosatheler@gmail.com>
 *
 */
public abstract class Colecao implements IColecao {

    protected List<Midia> listaDeMidias;

    public Colecao(List<Midia> listaDeMidias) {
        this.listaDeMidias = new ArrayList(listaDeMidias);
    }

    public List<Midia> getListaDeMidias() {
        return listaDeMidias;
    }

    /**
     *
     * Recebe uma midia por parametro e a adiciona ao array listaDeMidias
     *
     * @param midia
     */
    @Override
    public void cadastrarMidia(Midia midia) throws IllegalArgumentException, NumberFormatException {
        if (!this.listaDeMidias.add(midia)) {
            throw new IllegalArgumentException("Essa mídia não pôde ser inserida.\nVerifique os dados informados.");
        }
        ordenar();
    }

    /**
     *
     * Recebe uma String pesquisa, percorre a listaDeMidias, usa o método
     * contains pra fazer a comparação e quando encontrada a midia especifica,
     * remove-a
     *
     * @param pesquisa
     * @return
     */
    @Override
    public boolean removerMidia(String pesquisa) {
        for (Midia midia : listaDeMidias) {
            if (midia.contains(pesquisa)) {
                if (this.listaDeMidias.remove(midia)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * Método para recebe uma String e uma midia, depois, percorre a
     * listaDeMidias, e compara as midias presentes no array, para poder setar
     *
     * @param pesquisa
     * @param midia
     * @return
     */
    @Override
    public boolean editarMidia(String pesquisa, Midia midia) {
        for (int i = 0; i < listaDeMidias.size(); i++) {
            Midia midiaTemp = listaDeMidias.get(i);
            if (midiaTemp.contains(pesquisa)) {
                this.listaDeMidias.set(i, midia);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * Recebe uma String pesquisa, e percorre a listaDeMidias até encontrar a
     * midia especifica e encontrada pelo método contains, retornando a primeira
     * que encontrar.
     *
     * @param pesquisa
     * @return
     */
    @Override
    public Midia consultarMidia(String pesquisa) {
        for (Midia midia : listaDeMidias) {
            if (midia.contains(pesquisa)) {
                return midia;
            }
        }
        return null;
    }

    /**
     *
     * Recebe uma String pesquisa, e percorre a listaDeMidias até encontrar a
     * midia especifica e encontrada pelo método contais, adicionando-a a uma
     * nova lista e a retornando!
     *
     * @param pesquisa
     * @return
     */
    @Override
    public List consultarMidias(String pesquisa) {
        List<Midia> lista = new ArrayList();
        for (Midia midia : listaDeMidias) {
            if (midia.contains(pesquisa)) {
                lista.add((Midia) midia);
            }
        }
        return lista;
    }

    /**
     *
     * Apenas retorna a listaDeMidias para visualização!
     *
     * @return listaDeMidias
     */
    @Override
    public List exibirMidia() {
        ordenar();
        return this.listaDeMidias;
    }

    /**
     *
     * Recebe por parametro o nomedoarquivo, cria o arquivo, e chama o método
     * toString para escrever os atributos no arquivo!
     *
     * @param nomeArquivo
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws NullPointerException
     * @throws ClassCastException
     * @throws IOException
     */
    @Override
    public void exportarMidias(String nomeArquivo) throws FileNotFoundException, UnsupportedEncodingException, NullPointerException, ClassCastException, IOException {
        FileOutputStream outFile;
        BufferedWriter buff;

        outFile = new FileOutputStream(new File(nomeArquivo));
        buff = new BufferedWriter(new OutputStreamWriter(outFile, "UTF-8"));

        for (Midia midia : listaDeMidias) {

            buff.write(midia.toString());
            buff.write("\r\n");
        }

        buff.close();
        outFile.close();
    }
}
