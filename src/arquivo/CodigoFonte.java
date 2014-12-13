package arquivo;

import enums.FormatoCodigoFonte;

/**
 *
 * @author JOTA
 */
public class CodigoFonte extends Arquivo {
    
    private FormatoCodigoFonte extensao;
    
    public CodigoFonte(){
        super();
        extensao = FormatoCodigoFonte.css;
    }
    
    public CodigoFonte(String url){
        super(url);
        extensao = FormatoCodigoFonte.css;
    }
    
    public CodigoFonte(FormatoCodigoFonte extensao){
        super();
        this.extensao = extensao;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Codigo do Tipo: " + extensao + "\n";
    }
    
    /*
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
    */
}