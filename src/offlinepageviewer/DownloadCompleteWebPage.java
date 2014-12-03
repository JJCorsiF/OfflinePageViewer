package offlinepageviewer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author JOTA
 */
public class DownloadCompleteWebPage {
    
    public static Queue<Arquivo> filaDownloads;
    
    public static void main(String[] args) {
        String url = JOptionPane.showInputDialog("Digite o link do dominio que deseja baixar para visualização offline:");
        JFileChooser escolherArquivo = new JFileChooser();
        escolherArquivo.setDialogTitle("Escolha a pasta onde salvará os arquivos:");
        escolherArquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        escolherArquivo.showSaveDialog(null);//new Component(){});
        File pastaRoot = escolherArquivo.getCurrentDirectory();
        
        if (!url.startsWith("http://")){
            JOptionPane.showMessageDialog(null, "URL inválida");
            System.exit(-1);
        }
        
        //new PaginaHTML(url).download(pastaRoot.getAbsolutePath());
        
        try {
            String pagina = url;
            URL link = new URL(pagina);
            URLConnection conexaoURL = link.openConnection();
            InputStream streamEntrada = conexaoURL.getInputStream();
            InputStreamReader leitorStreamEntrada = new InputStreamReader(streamEntrada);

            int numCharsLidos;
            char[] arrayChars = new char[1024];
            StringBuilder criadorDeStrings = new StringBuilder();
            while ((numCharsLidos = leitorStreamEntrada.read(arrayChars)) > 0) {
                criadorDeStrings.append(arrayChars, 0, numCharsLidos);
            }
            String conteudoPagina = criadorDeStrings.toString();
            
            System.out.println("*** INÍCIO DA PÁGINA ***");
            System.out.println(conteudoPagina);
            System.out.println("*** FIM DA PÁGINA ***");
            
            int indexBusca = 0, inicio1, inicio2, inicio, fim1, fim2, fim;
            
            while (indexBusca >= 0){
                inicio1 = conteudoPagina.indexOf("src=", indexBusca);
                inicio2 = conteudoPagina.indexOf("href=", indexBusca);
                inicio = inicio1 < inicio2 ? inicio1 : inicio2;
                fim1 = conteudoPagina.indexOf("\'", inicio);
                fim2 = conteudoPagina.indexOf("\"", inicio);
                fim = fim1 < fim2 ? fim1 : fim2;
                
                String encontrado = conteudoPagina.substring(inicio, fim);
                
                if(encontrado.indexOf("/", 7) >= 0){
                    //Se achou um subdiretorio
                }
                
                String ex[] = new String[20];
                FormatoAudio[] extensoesAudio = FormatoAudio.values();
                int i = 0;
                for(FormatoAudio f : extensoesAudio){
                    ex[i] = f.toString();
                    i++;
                }
                for(String formatoAudio : ex){
                    if(encontrado.endsWith(formatoAudio)){
                        filaDownloads.add(new Audio(pastaRoot.getAbsolutePath() + "/"));
                        break;
                    }
                }
                
                ex = new String[20];
                FormatoVideo[] extensoesVideo = FormatoVideo.values();
                i = 0;
                for(FormatoVideo f : extensoesVideo){
                    ex[i] = f.toString();
                    i++;
                }
                for(String formatoVideo : ex){
                    if(encontrado.endsWith(formatoVideo)){
                        filaDownloads.add(new Video(pastaRoot.getAbsolutePath() + "/"));
                        break;
                    }
                }
                
                ex = new String[20];
                FormatoImagem[] extensoesImagem = FormatoImagem.values();
                i = 0;
                for(FormatoImagem f : extensoesImagem){
                    ex[i] = f.toString();
                    i++;
                }
                for(String formatoImagem : ex){
                    if(encontrado.endsWith(formatoImagem)){
                        filaDownloads.add(new Video(pastaRoot.getAbsolutePath() + "/"));
                        break;
                    }
                }
                
                if(encontrado.endsWith(".htm") || encontrado.endsWith(".html")){
                    filaDownloads.add(new PaginaHTML(pastaRoot.getAbsolutePath() + "/"));
                }
                
                indexBusca = fim;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DownloadCompleteWebPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DownloadCompleteWebPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Arquivo arquivo : filaDownloads){
            arquivo.download(pastaRoot.getAbsolutePath());
        }
    }
}