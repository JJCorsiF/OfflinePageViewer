package arquivo;

/**
 *
 * @author JOTA
 */
public class CodigoFonte extends Arquivo {
    
    public CodigoFonte(){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        URL = "";
        diretorioRelativo = "";
    }
    
    public CodigoFonte(String url){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        URL = url;
        diretorioRelativo = "";
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