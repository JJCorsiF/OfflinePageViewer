package offlinepageviewer;

/**
 *
 * @author JOTA
 */
public enum MetodoAudio {
    CBR("Constant BitRate"),
    VBR("Variable BitRate"),
    ABR("Average BitRate");
    
    private final String descricao;
    
    MetodoAudio(String descricao){
        this.descricao = descricao;
    }
}