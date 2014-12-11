package arquivo;

import enums.CodecVideo;
import enums.FormatoAudio;
import enums.FrequenciaAudio;
import enums.QualidadeVideo;

/**
 *
 * @author JOTA
 */
public class Video extends Arquivo implements Multimedia {//, Downloadable {
    private int duracao; //em minutos
    private int largura; //em pixels
    private int altura; //em pixels
    private boolean is3D;
    private QualidadeVideo qualidade;
    private int aspectRatio; //em pixels
    private int frameRate; //em fps
    private FrequenciaAudio frequencia;
    private CodecVideo codec;
    private FormatoAudio formatoAudio;
    
    public Video(){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        URL = "";
        diretorioRelativo = "";
        duracao = 0;
        largura = 0;
        altura = 0;
        is3D = false;
        qualidade = QualidadeVideo._240p;
        aspectRatio = 0;
        frameRate = 30;
        frequencia = FrequenciaAudio._44100HZ;
        codec = CodecVideo.DivX;
        formatoAudio = FormatoAudio.mp3;
    }
    
    public Video(String url){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        diretorioRelativo = "";
        URL = url;
        duracao = 0;
        largura = 0;
        altura = 0;
        is3D = false;
        qualidade = QualidadeVideo._240p;
        aspectRatio = 0;
        frameRate = 30;
        frequencia = FrequenciaAudio._44100HZ;
        codec = CodecVideo.DivX;
        formatoAudio = FormatoAudio.mp3;
    }
}