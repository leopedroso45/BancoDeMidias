/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecao;

import midia.Midia;
import midia.Musica;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Leonardo Severo Pedroso
 * <leopedroso45@gmail.com>
 *
 */
public class ColecaoMusica extends Colecao {

    public ColecaoMusica(List<Midia> listaDeMidia) {
        super(listaDeMidia);
    }

    /**
     *
     * Método que recebe por param o caminho, cria variaveis dos atributos da
     * class Musica, e lê cada linha do arquivo fazendo um parser de acordo com
     * seu tipo (quando necessario) e atribuindo os valores nas variaveis
     * indicadas, após isso, instancia um novo objeto com os valores do arquivo!
     *
     * @param caminhoArquivo
     * @throws NumberFormatException
     * @throws NullPointerException
     * @throws IOException
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
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
            String genero;
            List<String> autores = new ArrayList();
            List<String> interpretes = new ArrayList();
            int duracao;
            int ano;

            while ((caminho = buff.readLine()) != null) {

                // Atributos da super class sendo lidos
                nome = buff.readLine();
                descricao = buff.readLine();

                // Atributos da class Musica sendo lidos
                idioma = buff.readLine();
                genero = buff.readLine();
                autores.addAll(Arrays.asList(buff.readLine().split(";")));
                interpretes.addAll(Arrays.asList(buff.readLine().split(";")));
                duracao = Integer.parseInt(buff.readLine());
                ano = Integer.parseInt(buff.readLine());

                //instancia o objeto com os atributos lidos acima
                super.cadastrarMidia(new Musica(caminho, nome, descricao, idioma, genero, new ArrayList(autores), new ArrayList(interpretes), duracao, ano));

                buff.readLine();
                autores.clear();
                interpretes.clear();
            }

            buff.close();
            reader.close();
        }
    }

    @Override
    public void ordenar() {
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 0; i < super.listaDeMidias.size() - 2; i++) {
                Musica musica = (Musica) listaDeMidias.get(i);
                Musica musica2 = (Musica) listaDeMidias.get(i + 1);
                if (musica.compareTo(musica2) > 0) {
                    Musica aux = (Musica) listaDeMidias.get(i);
                    listaDeMidias.set(i, listaDeMidias.get(i + 1));
                    listaDeMidias.set(i + 1, aux);
                    houveTroca = true;
                }
            }
            if (!houveTroca) {
                break;
            }
            for (int i = listaDeMidias.size() - 2; i >= 0; i--) {
                Musica musica = (Musica) listaDeMidias.get(i);
                Musica musica2 = (Musica) listaDeMidias.get(i + 1);
                if (musica.compareTo(musica2) > 0) {
                    Musica aux = (Musica) listaDeMidias.get(i);
                    listaDeMidias.set(i, listaDeMidias.get(i + 1));
                    listaDeMidias.set(i + 1, aux);
                    houveTroca = true;
                }
            }

        } while (houveTroca);
    }

}
