package enums;

/**
 *
 * @author JOTA
 */
public enum FormatoVideo {
    avi("avi"),
    rmvb("rmvb"),
    mpeg("mpg"),
    mp4("mp4"),
    mov("mov"),
    mkv("mkv"),
    vob("vob"),
    wmv("wmv"),
    flv("flv");
    
    private String descricao;
    
    FormatoVideo(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return this.descricao + "\n";
    }
}