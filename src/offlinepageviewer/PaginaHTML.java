package offlinepageviewer;

import java.util.ArrayList;

/**
 *
 * @author JOTA
 */
public class PaginaHTML extends Arquivo {//implements Downloadable {
    private ArrayList<String> tagsHTML;
    private String conteudo;
    
    public PaginaHTML(String link){
        this.URL = link;
    }
    
    public PaginaHTML(String conteudo, String link){
        this.conteudo = conteudo;
        this.URL = link;
    }
    
    public String getConteudo(){
        return this.conteudo;
    }

    @Override
    public void download(String diretorioDestino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}