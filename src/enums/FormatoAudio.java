package enums;

/**
 *
 * @author JOTA
 */
public enum FormatoAudio {
    mp3("mp3"),
    wav("wav"),
    rma("rma"),
    pcm("pcm"),
    flac("flac"),
    aac("aac"),
    ogg("ogg"),
    wma("wma"),
    aiff("aiff"),
    dts("dts"),
    ac3("ac3");
    
    private String descricao;
    
    FormatoAudio(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return this.descricao + "\n";
    }
}