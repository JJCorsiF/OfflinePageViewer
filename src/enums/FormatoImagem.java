package enums;

/**
 *
 * @author JOTA
 */
public enum FormatoImagem {
    png("png"),
    gif("gif"),
    jpeg("jpg"),
    bmp("bmp"),
    dib("dib"),
    tif("tif"),
    tiff("tiff"),
    raw("raw"),
    svg("svg"),
    svgz("svgz"),
    webp("webp");
    
    private String descricao;
        
    FormatoImagem(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return this.descricao + "\n";
    }
}