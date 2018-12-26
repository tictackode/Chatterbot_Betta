/*
 *
 */
package chatbot;

import java.awt.Image;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Regson
 */
public class GramaticaDados {
    
   
    public Janela janela=new Janela();
  
    //Image imagemNormal = ImageIO.read(new File("//img//imagemNormal.jpg"));
    
    GramaticaDados()
    {
        this.verbos[0]="verbos";
        this.palavraInterrogativa[0]="palavraInterrogativa";
        this.doces[0]="doces";
        this.docesRespostas[0]="docesRespostas";
        this.cumprimentos[0]="cumprimentos";
        this.respostasCumprimentos[0]="respostasCumprimentos";
        this.frasesApresentacao[0]="frasesApresentacao";
        
    }
    
    public String Nome;
    public int idade;
   
    //inicialização tem que ser  1 a mais que o ultimo indice utilizado
    public String[] verbos={"verbos","gosto","gosta","quero","sou","tenho","quanto é","quanto custa"};
    public String[] palavraInterrogativa={"palavraInterrogativa","qual","quais","o que","quanto é","quanto custa"};
    public String[] doces=new String[5];
    
    public String[] docesRespostas=new String[5];
    public String[] cumprimentos=new String[10];
    public String[] respostasCumprimentos=new String[5];
    
    public String[] palavrasDespedida={"tchau","xau xau","bye","ate mais","ate logo"};
    public String[] respostasPalavrasDespedida={"obrigada! volte sempre!","Já vai? Obrigada, até a próxima!","Tchau! Obrigada! Até depois!","Bye bye!"};
    
    public Produto[] listaProdutos=new Produto[5];
    public String[] frasePadraoProdutos=new String[3];
    
    public String[] frasesApresentacao=new String[5];
    
    public Boolean[] listaGostaProduto=new Boolean[this.listaProdutos.length+1];
    
    public void inicializa_Gostos_Sobre_Produtos()
    {
          Random r=new Random();
          for(int x=1;x<this.listaProdutos.length;x++)
          {
             this.listaGostaProduto[x]=r.nextBoolean();
           
          }
        
    }    
    
  
                   
                    
    
}
