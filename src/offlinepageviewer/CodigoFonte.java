package offlinepageviewer;

/**
 *
 * @author JOTA
 */
public class CodigoFonte extends Arquivo {
    
    public CodigoFonte(String url){
        this.URL = url;
    }

    @Override
    public void download(String diretorioDestino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}