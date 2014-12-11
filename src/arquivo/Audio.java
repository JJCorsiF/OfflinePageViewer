package arquivo;

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
    
    public Audio(){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        URL = "";
        diretorioRelativo = "";
        duracao = 0;
        numeroCanais = 1;
        bitRate = QualidadeAudio._16kbps;
        metodo = MetodoAudio.CBR;
        taxaAmostragem = FrequenciaAudio._44100HZ;
    }
    
    public Audio(String link){
        diretorioRoot = "";
        tamanhoArquivo = 0;
        formato = "";
        URL = "";
        diretorioRelativo = "";
        this.URL = link;
    }
}