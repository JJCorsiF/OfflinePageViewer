package arquivo;

import enums.FormatoImagem;

/**
 *
 * @author JOTA
 */
public class Imagem extends Arquivo {
    private int altura;
    private int largura;
    private FormatoImagem extensao;
    
    public Imagem(){
        super();
        altura = 0;
        largura = 0;
        extensao = FormatoImagem.jpeg;
    }
    
    public Imagem(String link){
        super(link);
        altura = 0;
        largura = 0;
        extensao = FormatoImagem.jpeg;
    }
    
    public Imagem(int altura, int largura, FormatoImagem extensao){
        super();
        this.altura = altura;
        this.largura = largura;
        this.extensao = extensao;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Imagem " + altura + "x" + largura + " do Tipo: " + extensao + "\n";
    }
}