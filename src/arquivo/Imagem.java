package arquivo;

/**
 *
 * @author JOTA
 */
public class Imagem extends Arquivo {
    private int altura;
    private int largura;
    
    public Imagem(){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        URL = "";
        diretorioRelativo = "";
        altura = 0;
        largura = 0;
    }
    
    public Imagem(String link){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        URL = link;
        diretorioRelativo = "";
        altura = 0;
        largura = 0;
    }
}