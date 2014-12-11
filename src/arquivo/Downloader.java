package arquivo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import enums.FormatoAudio;
import enums.FormatoCodigoFonte;
import enums.FormatoImagem;
import enums.FormatoPaginaWeb;
import enums.FormatoVideo;

/**
 *
 * @author JOTA
 */
public class Downloader {
    
    public static Queue<PaginaHTML> filaDownloads;
    
    public static ArrayList<String> dominios;
    
    public static void main(String[] args) {
        //TODO Code:
        //1. Usuario escolhe a pagina que quer baixar completamente. X
        //2. Usuario escolhe onde quer salvar o conteúdo do site. X
        //3. Verificar consistencia do link da pagina requerida pelo usuario.
        //4. Abre uma conexão HTTP e baixa a página original.
        //5. Ler a pagina original em busca de links para outras páginas ou arquivos multimedia.
        //6. Identificar o tipo de cada link como Imagem, Video, Audio, ou outros (PaginaHTML).
        //7. Adicionar esses arquivos na fila de downloads para ser salvos em seus respectivos diretorios.
        //8. Editar cada link da pagina original para "linkar" para os arquivos locais.
        //9. Salvar o arquivo modificado no diretorio escolhido pelo usuario.
        //10. Ir para o próximo arquivo da fila e o processo de 4. até 9. se repete até que não existam mais links para serem baixados.
        
        String diretorioServidor = JOptionPane.showInputDialog("Digite o link do dominio que deseja baixar para visualização offline:").trim();
        JFileChooser escolhedorDeArquivo = new JFileChooser();
        escolhedorDeArquivo.setDialogTitle("Escolha o diretório onde salvará os arquivos:");
        escolhedorDeArquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        escolhedorDeArquivo.showSaveDialog(null);//new Component(){});
        
        //testa se o link fornecido pelo usuário usa o protocolo HTTP explicitamente
        if (!(diretorioServidor.split(":")[0].startsWith("http") || diretorioServidor.split(":")[0].startsWith("https"))){
            diretorioServidor = "http://" + diretorioServidor;
        }
        
        if(!diretorioServidor.endsWith("/")){
            diretorioServidor += "/";
        }
        
        dominios.add(diretorioServidor.substring(diretorioServidor.indexOf("://") + 3, diretorioServidor.indexOf("/", 7)));
        
        PaginaHTML paginaPrincipal = new PaginaHTML(diretorioServidor);
        paginaPrincipal.diretorioRoot = escolhedorDeArquivo.getCurrentDirectory().getAbsolutePath();
        filaDownloads.add(paginaPrincipal);
        
        for(String dominio : dominios){
            for(PaginaHTML webPage : filaDownloads){
                webPage.diretorioRoot = paginaPrincipal.diretorioRoot;
                try {
                    URL link = new URL(webPage.URL);
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

                    int indexBusca = 0, inicio1, inicio2, menorInicio, fim1, fim2, menorFim;

                    while (indexBusca >= 0){
                        inicio1 = conteudoPagina.indexOf("src=", indexBusca) + 5;
                        inicio2 = conteudoPagina.indexOf("href=", indexBusca) + 6;
                        menorInicio = inicio1 < inicio2 ? inicio1 : inicio2;

                        if(menorInicio < 6){
                            break;
                        }

                        fim1 = conteudoPagina.indexOf("\'", menorInicio);
                        fim2 = conteudoPagina.indexOf("\"", menorInicio);
                        menorFim = fim1 < fim2 ? fim1 : fim2;

                        if(menorFim < 0){
                            break;
                        }

                        String encontrado = conteudoPagina.substring(menorInicio, menorFim);

                        String copia = encontrado;

                        String paginaRoot;

                        if(copia.contains("?")){
                            //se tem codigo GET adicionado na url
                            copia = copia.substring(0, copia.indexOf("?"));
                        }

                        if(copia.contains("#")){
                            //se tem codigo GET adicionado na url
                            copia = copia.substring(0, copia.indexOf("#"));
                        }

                        if(copia.endsWith("/")){
                            copia = copia.substring(0, copia.length() - 1);
                        }
                        
                        boolean encontrouFormato = false;
                        Arquivo arquivo = new PaginaHTML();
                        while(true){
                            for(FormatoAudio formato : FormatoAudio.values()){
                                if(copia.toLowerCase().endsWith(formato.toString())){
                                    //encontrado o formato de audio
                                    arquivo = new Audio();
                                    webPage.getLinks().add(arquivo);
                                    encontrouFormato = true;
                                    break;
                                }
                            }

                            if(encontrouFormato){
                                break;
                            }

                            for(FormatoCodigoFonte formato : FormatoCodigoFonte.values()){
                                if(copia.toLowerCase().endsWith(formato.toString())){
                                    //encontrado o formato de codigo fonte
                                    arquivo = new CodigoFonte();
                                    webPage.getLinks().add(arquivo);
                                    encontrouFormato = true;
                                    break;
                                }
                            }

                            if(encontrouFormato){
                                break;
                            }

                            for(FormatoImagem formato : FormatoImagem.values()){
                                if(copia.toLowerCase().endsWith(formato.toString())){
                                    //encontrado o formato de imagem
                                    arquivo = new Imagem();
                                    webPage.getLinks().add(arquivo);
                                    encontrouFormato = true;
                                    break;
                                }
                            }

                            if(encontrouFormato){
                                break;
                            }

                            for(FormatoVideo formato : FormatoVideo.values()){
                                if(copia.toLowerCase().endsWith(formato.toString())){
                                    //encontrado o formato de video
                                    arquivo = new Video();
                                    webPage.getLinks().add(arquivo);
                                    encontrouFormato = true;
                                    break;
                                }
                            }

                            if(encontrouFormato){
                                break;
                            }

                            for(FormatoPaginaWeb formato : FormatoPaginaWeb.values()){
                                if(copia.toLowerCase().endsWith(formato.toString())){
                                    //encontrado o formato de pagina web
                                    //webPage.getLinks().add(novaPagina);
                                    filaDownloads.add((PaginaHTML) arquivo);
                                    encontrouFormato = true;
                                    break;
                                }
                            }
                        }

                        if(copia.toLowerCase().startsWith("http://") || copia.toLowerCase().startsWith("https://")){
                            //é um link http
                            copia = copia.substring(copia.indexOf("://") + 3);
                            arquivo.diretorioRelativo = copia.substring(copia.indexOf("/") + 1);

                            paginaRoot = copia.substring(0, copia.indexOf("/"));
                            if(!paginaRoot.equalsIgnoreCase(diretorioServidor.substring(diretorioServidor.indexOf("://") + 3))){
                                //é um link de outro dominio
                                String resposta = JOptionPane.showInputDialog("Deseja incluir o dominio " + paginaRoot + " na fila de downloads? (Padrão: Não)\n0-Sim\n1-Não");

                                if(resposta.startsWith("0") || resposta.equalsIgnoreCase("Sim")){
                                    //incluir o dominio na fila
                                    dominios.add(paginaRoot);
                                }
                                else{
                                    //inclui apenas o link na fila
                                    webPage.getLinks().add(new PaginaHTML(paginaRoot));
                                }
                            }
                        }
                        else{
                            //é um link relativo ao mesmo domínio requerido pelo usuario
                            //também incluir o link na fila
                            arquivo.diretorioRelativo = copia;
                            encontrado = diretorioServidor + encontrado;
                        }
                        
                        arquivo.URL = encontrado;
                        
                        webPage.getLinks().add(arquivo);

                        conteudoPagina = conteudoPagina.substring(0, menorInicio) + arquivo.diretorioRoot + arquivo.diretorioRelativo + conteudoPagina.substring(menorFim);

                        webPage.setConteudo(conteudoPagina);

                        indexBusca = menorFim;
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        for(PaginaHTML pagina : filaDownloads){
            pagina.download();
            for(Arquivo arquivo : pagina.getLinks()){
                try {
                    arquivo.download();
                } catch (IOException ex) {
                    Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            filaDownloads.remove(pagina);
        }
    }
}