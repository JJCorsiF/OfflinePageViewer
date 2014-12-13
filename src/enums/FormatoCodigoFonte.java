package enums;

/**
 *
 * @author JOTA
 */
public enum FormatoCodigoFonte {
    xml("xml"),
    css("css"),
    js("js");
    
    private String descricao;
    
    FormatoCodigoFonte(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return this.descricao + "\n";
    }
}