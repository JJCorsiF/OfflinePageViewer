package offlinepageviewer;

/**
 *
 * @author JOTA
 */
public enum QualidadeAudio {
    _16kbps("Radio de ondas curtas"),
    _32kbps("Radio AM"),
    _96kbps("Radio FM"),
    _128kbps("Proxima ao CD"),
    _160a180kbps("Transparência perceptiva"),
    _256kbps("Estudio de som");
    
    private final String descricao;
    
    QualidadeAudio(String descricao){
        this.descricao = descricao;
    }
}