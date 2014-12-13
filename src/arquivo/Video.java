package arquivo;

import enums.CodecVideo;
import enums.FormatoAudio;
import enums.FormatoVideo;
import enums.FrequenciaAudio;
import enums.QualidadeVideo;

/**
 *
 * @author JOTA
 */
public class Video extends Arquivo implements Multimedia {
    private int duracao; //em minutos
    private int largura; //em pixels
    private int altura; //em pixels
    private boolean is3D;
    private QualidadeVideo qualidade;
    private int aspectRatio; //em pixels
    private int frameRate; //em fps
    private FrequenciaAudio frequencia;
    private CodecVideo codec;
    private FormatoVideo extensao;
    private FormatoAudio formatoAudio;
    
    public Video(){
        super();
        duracao = 0;
        largura = 0;
        altura = 0;
        is3D = false;
        qualidade = QualidadeVideo._240p;
        aspectRatio = 0;
        frameRate = 30;
        frequencia = FrequenciaAudio._44100HZ;
        codec = CodecVideo.DivX;
        extensao = FormatoVideo.mp4;
        formatoAudio = FormatoAudio.mp3;
    }
    
    public Video(String url){
        super(url);
        duracao = 0;
        largura = 0;
        altura = 0;
        is3D = false;
        qualidade = QualidadeVideo._240p;
        aspectRatio = 0;
        frameRate = 30;
        frequencia = FrequenciaAudio._44100HZ;
        codec = CodecVideo.DivX;
        extensao = FormatoVideo.mp4;
        formatoAudio = FormatoAudio.mp3;
    }
    
    public Video(int duracao, int altura, int largura){
        super();
        this.duracao = duracao;
        this.altura = altura;
        this.largura = largura;
        is3D = false;
        qualidade = QualidadeVideo._240p;
        aspectRatio = 0;
        frameRate = 30;
        frequencia = FrequenciaAudio._44100HZ;
        codec = CodecVideo.DivX;
        extensao = FormatoVideo.mp4;
        formatoAudio = FormatoAudio.mp3;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Video " + (is3D ? "3D" : "") + " do Tipo: " + extensao + "\n";
    }
    
}