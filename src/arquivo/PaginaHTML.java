package arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOTA
 */
public class PaginaHTML extends Arquivo {
    private String conteudo;
    private final ArrayList<Arquivo> links = new ArrayList<>();
    
    public PaginaHTML(){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        URL = "";
        diretorioRelativo = "";
        conteudo = "";
    }
    
    public PaginaHTML(String url){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        diretorioRelativo = "";
        URL = url;
        conteudo = "";
    }
    
    public PaginaHTML(String conteudo, String url){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        diretorioRelativo = "";
        this.conteudo = conteudo;
        URL = url;
    }
    
    public String getConteudo(){
        return this.conteudo;
    }
    
    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }
    
    public ArrayList<Arquivo> getLinks(){
        return this.links;
    }

    @Override
    public void download() {
        FileWriter escritorArquivo;
        PrintWriter printer;
        
        try {
            escritorArquivo = new FileWriter(diretorioRoot + "/" + diretorioRelativo + File.separator + nomeArquivo);
            printer = new PrintWriter(escritorArquivo);
            
            printer.print(conteudo);
            
            printer.close();
            escritorArquivo.close();
            
        } catch (IOException ex) {
            Logger.getLogger(PaginaHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}