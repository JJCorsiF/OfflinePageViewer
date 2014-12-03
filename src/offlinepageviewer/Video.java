package offlinepageviewer;

/**
 *
 * @author JOTA
 */
public class Video extends Arquivo implements Multimedia {//, Downloadable {
    private int duracao; //em minutos
    private int largura; //em pixels
    private int altura; //em pixels
    private QualidadeVideo qualidade;
    private int aspectRatio; //em pixels
    private int frameRate; //em fps
    private FrequenciaAudio frequencia;
    private CodecVideo codec;
    private FormatoAudio formatoAudio;
    
    public Video(String link){
        this.URL = link;
    }

    @Override
    public void download(String diretorioDestino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}