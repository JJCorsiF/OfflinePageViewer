package offlinepageviewer;

/**
 *
 * @author JOTA
 */
public class Imagem extends Arquivo { //implements Multimedia, Downloadable {
    private int altura;
    private int largura;
    
    public Imagem(String link){
        this.URL = link;
    }

    @Override
    public void download(String diretorioDestino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}