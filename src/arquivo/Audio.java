package arquivo;

import enums.FormatoAudio;
import enums.FrequenciaAudio;
import enums.MetodoAudio;
import enums.QualidadeAudio;

/**
 *
 * @author JOTA
 */
public class Audio extends Arquivo implements Multimedia {
    private int duracao; //em minutos
    private int numeroCanais; //Ex.: 2 - Stereo
    private QualidadeAudio bitRate; //em KBPS
    private MetodoAudio metodo;
    private FrequenciaAudio taxaAmostragem; //em Heartz
    private FormatoAudio extensao;
    
    public Audio(){
        super();
        duracao = 0;
        numeroCanais = 1;
        bitRate = QualidadeAudio._16kbps;
        metodo = MetodoAudio.CBR;
        taxaAmostragem = FrequenciaAudio._44100HZ;
        extensao = FormatoAudio.mp3;
    }
    
    public Audio(String link){
        super(link);
        duracao = 0;
        numeroCanais = 1;
        bitRate = QualidadeAudio._16kbps;
        metodo = MetodoAudio.CBR;
        taxaAmostragem = FrequenciaAudio._44100HZ;
        extensao = FormatoAudio.mp3;
    }
    
    public Audio(int duracao){
        super();
        this.duracao = duracao;
    }
    
    @Override
    public String toString(){
        return super.toString() + "Audio do Tipo: " + extensao + "\n";
    }
}