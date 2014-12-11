package offlinepageviewer;

import java.util.ArrayList;

/**
 *
 * @author JOTA
 */
public class PaginaHTML extends Arquivo {//implements Downloadable {
    private ArrayList<String> tagsHTML;
    private String conteudo;
    private ArrayList<Arquivo> links;
    
    public PaginaHTML(String url){
        this.URL = url;
    }
    
    public PaginaHTML(String conteudo, String url){
        this.conteudo = conteudo;
        this.URL = url;
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
    public void download(String diretorioDestino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}