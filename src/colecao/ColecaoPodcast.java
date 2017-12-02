/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecao;

import midia.Midia;
import midia.Podcast;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Leonardo Severo Pedroso
 * <leopedroso45@gmail.com>
 *
 */
public class ColecaoPodcast extends Colecao {

    private List<Podcast> listaDePodcast;

    /**
     * Apenas inicializada um array vazio listaDePodcast
     */
    public ColecaoPodcast(List<Midia> listaDeMidia) {
        super(listaDeMidia);
    }

    /**
     *
     * Método que recebe por param o caminho, cria variaveis dos atributos da
     * class Podcast, e lê cada linha do arquivo fazendo um parser de acordo com
     * seu tipo (quando necessario) e atribuindo os valores nas variaveis
     * indicadas, após isso, instancia um novo objeto com os valores do arquivo!
     *
     * @param caminhoArquivo
     * @throws NumberFormatException
     * @throws NullPointerException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    @Override
    public void importarMidias(String caminhoArquivo) throws NumberFormatException, NullPointerException, IOException, FileNotFoundException, IOException, UnsupportedEncodingException {
        File arquivo = new File(caminhoArquivo);
        if (arquivo.exists()) {
            FileReader reader = new FileReader(arquivo);
            BufferedReader buff = new BufferedReader(reader);

            //Atributos da Super Classe
            String caminho;
            String nome;
            String descricao;

            //Atributos da class Musica
            String idioma;
            List<String> autores = new ArrayList();
            int ano;

            while ((caminho = buff.readLine()) != null) {

                // Atributos da super class sendo lidos
                nome = buff.readLine();
                descricao = buff.readLine();

                // Atributos da class Podcast sendo lidos
                idioma = buff.readLine();
                autores.addAll(Arrays.asList(buff.readLine().split(";")));
                ano = Integer.parseInt(buff.readLine());

                //instancia o objeto com os atributos lidos acima
                super.cadastrarMidia(new Podcast(caminho, nome, descricao, idioma, new ArrayList(autores), ano));

                buff.readLine();
            }

            buff.close();
            reader.close();
        }
    }

    /**
     * Not implemented yet!
     */
    @Deprecated
    @Override
    public void ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
