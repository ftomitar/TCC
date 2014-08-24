/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPSolveComunication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @OriginalAuthor felipe
 * @author xD alexandre
 */
public class FileManager {

    private String _nomeArquivo = "";
    private BufferedWriter _output = null;
    private PrintWriter _writer = null;
    private boolean _arquivoAberto = false;

    public FileManager(String nomeArquivo) {
        _nomeArquivo = nomeArquivo;
    }

    public void abrirArquivoEscrita() {
        boolean append = false;

        if (_arquivoAberto) {
            fecharArquivo();
        }

        try {
            _output = new BufferedWriter(new FileWriter(_nomeArquivo, append));
            _writer = new PrintWriter(_output);
            _arquivoAberto = true;

        } catch (IOException ex) {
            System.out.println("Arquivo não foi encontrado - " + ex.getMessage());
        }
    }

    public void escreverLinha(String linha) {
        if (_arquivoAberto) {
            _writer.println(linha);
        }
    }

    public boolean arquivoAberto() {
        return _arquivoAberto;
    }

    public void fecharArquivo() {
        if (_arquivoAberto) {
            try {
                _output.close();
            } catch (IOException ex) {
                System.out.println("Arquivo não foi encontrado - " + ex.getMessage());
            }
        }
    }
}
