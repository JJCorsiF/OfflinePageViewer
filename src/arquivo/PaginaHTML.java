package arquivo;

import enums.FormatoPaginaWeb;
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
    private FormatoPaginaWeb extensao;
    
    public PaginaHTML(){
        super();
        conteudo = "";
        extensao = FormatoPaginaWeb.html;
    }
    
    public PaginaHTML(String url){
        super(url);
        conteudo = "";
        extensao = FormatoPaginaWeb.html;
    }
    
    public PaginaHTML(String conteudo, String url){
        super(url);
        this.conteudo = conteudo;
        extensao = FormatoPaginaWeb.html;
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
    
    @Override
    public String toString(){
        return super.toString() + "Pagina com extensão: " + extensao + "\n";
    }
}