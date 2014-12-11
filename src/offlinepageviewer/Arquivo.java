package offlinepageviewer;

/**
 *
 * @author JOTA
 */
public abstract class Arquivo implements Downloadable {
    protected static String diretorioRoot;
    protected int tamanhoArquivo;
    protected String formato;
    protected String URL;
    protected String diretorioRelativo;
}