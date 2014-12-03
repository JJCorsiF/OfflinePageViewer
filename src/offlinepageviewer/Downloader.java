package offlinepageviewer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Utilitário para baixar um arquivo de uma URL.
 * @author JOTA
 */
public class Downloader {
    private static final int BUFFER_SIZE = 4096;

    /**
     * Faz o download de um arquivo a partir de uma URL
     * @param urlDoArquivo URL HTTP do arquivo a ser baixado
     * @param diretorioDestino caminho do diretorio onde o arquivo será salvo
     * @throws IOException
     */
    public static void download(String urlDoArquivo, String diretorioDestino) throws IOException {
        URL link = new URL(urlDoArquivo);
        // para funcionar em servidores não-locais, é preciso habilitar os cookies para a sessão
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        
        HttpURLConnection ConexaoHTTP = (HttpURLConnection) link.openConnection();
        int codigoRespostaHTTP = ConexaoHTTP.getResponseCode();

        // sempre checa primeiro o código de resposta HTTP
        if (codigoRespostaHTTP == HttpURLConnection.HTTP_OK) {
            String nomeArquivo = "";
            String disposition = ConexaoHTTP.getHeaderField("Content-Disposition");
            String tipoConteudo = ConexaoHTTP.getContentType();
            int tamanhoConteudo = ConexaoHTTP.getContentLength();

            if (disposition != null) {
                // extrai o nome do arquivo do cabeçalho
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                        nomeArquivo = disposition.substring(index + 10,
                                        disposition.length() - 1);
                }
            } else {
                // extrai o nome do arquivo da URL
                nomeArquivo = urlDoArquivo.substring(urlDoArquivo.lastIndexOf("/") + 1,
                                urlDoArquivo.length());
            }

            System.out.println("Content-Type: " + tipoConteudo);
            System.out.println("Content-Disposition: " + disposition);
            System.out.println("Tamanho do arquivo: " + tamanhoConteudo + " Bytes");
            System.out.println("Nome do arquivo: " + nomeArquivo);

            // abre stream de entrada da conexão HTTP
            InputStream streamEntrada = ConexaoHTTP.getInputStream();
            String diretorioSalvarArquivo = diretorioDestino + File.separator + nomeArquivo;

            // abre stream de saída para salvar o arquivo
            FileOutputStream streamSaida = new FileOutputStream(diretorioSalvarArquivo);

            int bytesLidos = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesLidos = streamEntrada.read(buffer)) != -1) {
                    streamSaida.write(buffer, 0, bytesLidos);
            }

            streamSaida.close();
            streamEntrada.close();

            System.out.println("Arquivo " + nomeArquivo + " salvo em " + diretorioDestino + " com sucesso.");
        } else {
            System.out.println("Nenhum arquivo foi baixado. Código de resposta do Servidor HTTP: " + codigoRespostaHTTP);
        }
        ConexaoHTTP.disconnect();
    }
}