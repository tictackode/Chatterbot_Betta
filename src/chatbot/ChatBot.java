/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author Regson
 */
public class ChatBot {
    
    
    public GramaticaDados GD;
    public Janela janela;
    public Pedido pedido;
    
     public String motor(String[] listaPalavras, String[] listaRespostas)
    {
        
        String frase=this.janela.txtEntrada.getText();
        String saida="";
        for(int x=1;x<listaPalavras.length;x++)
        {
           // if (frase.contains(listaPalavras[x]))
            if(frase.matches(".*\\b"+listaPalavras[x]+"\\b.*"))
           {
                   saida=listaRespostas[x];     
           }
        }
         System.out.println("motor() entrou / listaPalavras= "+listaPalavras[0]+" / listaRespostas= "+listaRespostas[0]+" / retorno= "+saida);
        return saida;
    }
     
    public Boolean item_Lista_Esta_Na_Frase(String[] listaPalavras)
    {
        // retorna verdadeiro se um item de uma lista está contido na frase
        String frase=this.janela.txtEntrada.getText();
        Boolean true_or_false=false;
        for(int indice=1;indice<listaPalavras.length;indice++)
        {
             if(frase.matches(".*\\b"+listaPalavras[indice]+"\\b.*"))
             {
                true_or_false=true;
             }
        }
        System.out.println("item_Lista_Esta_Na_Frase() entrou  / array="+listaPalavras[0]+" / retorno= "+true_or_false);
        return true_or_false;
    }
    public Boolean trecho_Esta_Na_Frase(String trecho)
    {
        // retorna verdadeiro se um trecho de texto( uma string) está contido na frase
        String frase=this.janela.txtEntrada.getText();
        Boolean true_or_false=false;
       
             if(frase.matches(".*\\b"+trecho+"\\b.*"))
             {
                true_or_false=true;
             }
        
        System.out.println("trecho_Esta_Na_Frase() entrou  / trecho="+trecho+" / retorno= "+true_or_false);
        return true_or_false;
    }
    
    
    //Recebe como parametro o array de frases e devolve uma frase aleatoriamente
     public String fraseRandom(String[] listaDeFrases)
     {  
         Random r=new Random();
         return listaDeFrases[r.nextInt((listaDeFrases.length-1))+1];
     }
     
     public String buscaPalavraComRetorno(String[] lista)
     {
         
         // este metodo analisa a frase em busca de uma palavra em uma lista 
         // e retorna a palavra encontrada
        String frase=this.janela.txtEntrada.getText();
        String retorno="";
        for(int indice=1;indice<lista.length;indice++)
        {
             if(frase.matches(".*\\b"+lista[indice]+"\\b.*"))
           {
                   retorno=lista[indice];     
           }
        }
        
        System.out.println("buscaPalavraComRetorno() - retornou "+retorno);
        return retorno;
     }
      public Produto buscaProdutoComRetorno(Produto[] lista)
     {
      
         // este metodo analisa a frase em busca de uma palavra em uma lista 
         // e retorna a palavra encontrada
        String frase=this.janela.txtEntrada.getText();
        Produto retorno=lista[0]; //produto nulo
        for(int indice=1;indice<lista.length;indice++)
        {
            for(int x=0;x<lista[indice].sinonimos.length;x++)
            {
             if(frase.matches(".*\\b"+lista[indice].sinonimos[x]+"\\b.*")) // no futuro buscar pelos sinonimos
             {
                   retorno=lista[indice];     
             }
            }
        }
        System.out.println("buscaProdutoComRetorno() entrou frase="+frase+"- retornou "+retorno.nome); 
        return retorno;
     }
      public Integer buscaProdutoRetornandoIndice(Produto[] listaProdutos,Produto produto)
     {
       
        String frase=this.janela.txtEntrada.getText();
        Integer retorno=0; //produto nulo
        
           for(int i=1;i<listaProdutos.length;i++)
           {
                for(int x=0;x<listaProdutos[i].sinonimos.length;x++)
                {
                    if(frase.matches(".*\\b"+listaProdutos[i].sinonimos[x]+"\\b.*")) 
                    {
                          retorno=i;     
                    }

                }
           }
        System.out.println("buscaProdutoRetornandoIndice() entrou frase="+frase+"- retornou "+retorno); 
        return retorno;
     }
      
       public Boolean existe_Produto_Na_Frase(Produto[] produtos)
     {
       
        String frase=this.janela.txtEntrada.getText();
        Boolean retorno=false; 
        Produto produtoLog=new Produto();
            
        for(int indiceExterno=1;indiceExterno<produtos.length;indiceExterno++)
        {
            for(int x=0;x<produtos[indiceExterno].sinonimos.length;x++)
            {
                if(frase.matches(".*\\b"+produtos[indiceExterno].sinonimos[x]+"\\b.*")) // no futuro buscar pelos sinonimos
                {
                      retorno=true;  
                      produtoLog=produtos[indiceExterno];
                }
            }   
        }
        System.out.println("existe_Produto_Na_Frase() entrou / produto Encontrado= "+produtoLog.nome+" / retornou "+retorno); 
        return retorno;
     }
      
     public void motorVerbal(String verbo,Produto aux)
     {
         
         //este metodo receberá uma string contendo um verbo retornado pelo método analisa verbo
         
         switch(verbo)
         {
             
             case "quanto é":
             case "quanto custa": 
             case "gosto":   this.janela.falaBot(aux.gera_Frase_Valor());  break;    
                                                                                         
             case "gosta":   this.janela.falaBot(this.gera_Frase_Gosta_Produto(this.buscaProdutoRetornandoIndice(this.GD.listaProdutos,aux))); break;
             
             case "quero":   this.janela.falaBot(aux.gera_Frase_Adicionado_Ao_Pedido()); this.pedido.produtosPedidos[this.pedido.indiceAtual]=aux; this.pedido.indiceAtual++; break;
             
             case "sou":     break;
             
             case "tenho":   break;
             
                 
         
             
                 
             
         }
         
         System.out.println("motorVerbal() entrou / verbo= "+verbo+" / produto Aux="+aux.nome);
     }   
     
    public Boolean verificarPergunta()
    {
        Boolean retorno=false;
        System.out.println("verificarPergunta() entrou");
        Produto produtoAux=null;
        
        if(this.item_Lista_Esta_Na_Frase(this.GD.palavraInterrogativa))
        {
            retorno=true;
        }
        System.out.println("verificarPergunta() entrou - retornou "+retorno.toString());
        return retorno;
    }
    
      public String gera_Frase_Gosta_Produto(Integer indiceProduto)
    {
        String retorno="";
        if(this.GD.listaGostaProduto[indiceProduto]==true)
        {
            retorno="Eu gosto de "+this.GD.listaProdutos[indiceProduto].nome;
             this.janela.lbImagem.setIcon(new ImageIcon("img//imagemHappy.jpg"));
             this.janela.repaint();
                   
        }
        else
        {
            retorno="Eu não gosto de "+this.GD.listaProdutos[indiceProduto].nome; 
            this.janela.lbImagem.setIcon(new ImageIcon("img//imagemSad.jpg"));
            this.janela.lbImagem.repaint();
        }
        
      
        System.out.println("gera_Frase_Gosta_Produto() / produto= "+this.GD.listaProdutos[indiceProduto]+" / retorno= "+retorno);
        return retorno;
    }
     public void executaIA()
     {
            this.janela.lbImagem.setIcon(new ImageIcon("img//imagemNormal.jpg"));
            
            String verboAtual="";
            Produto produtoAtual=new Produto();
        
            
            if(this.item_Lista_Esta_Na_Frase(this.GD.cumprimentos))
            {
                this.janela.falaBot(this.fraseRandom(this.GD.respostasCumprimentos));
                this.janela.lbImagem.setIcon(new ImageIcon("img//imagemHappy.jpg"));
            }    
            else if(this.item_Lista_Esta_Na_Frase(this.GD.palavrasDespedida))
            {
                this.janela.falaBot(this.fraseRandom(this.GD.respostasPalavrasDespedida));
                this.janela.lbImagem.setIcon(new ImageIcon("img//imagemShy.jpg"));
            }    
            else if(this.item_Lista_Esta_Na_Frase(this.GD.verbos))
            {
               
                    //Salva verbo na variavel auxiliar
                    verboAtual=this.buscaPalavraComRetorno(this.GD.verbos);
                      
                      //Verifica se há um produto
                      if(this.existe_Produto_Na_Frase(this.GD.listaProdutos))
                      {   
                        //Salva Produto na variavel auxiliar
                        produtoAtual=this.buscaProdutoComRetorno(this.GD.listaProdutos);
                        
                        this.motorVerbal(verboAtual,produtoAtual);
                        
                       }  
                      
                    System.out.println("verboAtual= "+verboAtual+" / produtoAtual= "+produtoAtual.nome);
                    
                    //limpando valores
                    verboAtual="";
                    produtoAtual=new Produto();
                  
                //Se não há verbo
                }
                else if(this.item_Lista_Esta_Na_Frase(this.GD.doces))
                {
                
                    this.janela.falaBot(this.motor(this.GD.doces, this.GD.docesRespostas));
                    
                    
                }
                else
                {
                    this.janela.lbSaida.setText("Hummm...");
                }
              
            
            
            if(this.trecho_Esta_Na_Frase("fechar o pedido")||this.trecho_Esta_Na_Frase("quanto deu o total"))
            {
                this.janela.falaBot("O pedido deu um total de "+this.pedido.valorTotalPedido()+" reais");
            }
        
        this.janela.txtEntrada.setText("");
        System.out.println("----------------------------------");
     }
}
