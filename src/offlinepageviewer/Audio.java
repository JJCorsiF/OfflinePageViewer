package offlinepageviewer;

/**
 *
 * @author JOTA
 */
public class Audio extends Arquivo implements Multimedia {//, Downloadable {
    private int duracao; //em minutos
    private int numeroCanais; //Ex.: 2 - Stereo
    private QualidadeAudio bitRate; //em KBPS
    private MetodoAudio metodo;
    private FrequenciaAudio taxaAmostragem; //em Heartz
    
    public Audio(String link){
        this.URL = link;
    }

    @Override
    public void download(String diretorioDestino) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}