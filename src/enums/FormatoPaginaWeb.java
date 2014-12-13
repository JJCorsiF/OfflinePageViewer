package enums;

/**
 *
 * @author JOTA
 */
public enum FormatoPaginaWeb {
    htm("htm"),
    html("html"),
    php("php"),
    asp("asp");
    
    private String descricao;
    
    FormatoPaginaWeb(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return this.descricao + "\n";
    }
}