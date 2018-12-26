package chatbot;

import javax.swing.ImageIcon;

/**
 * @author Regson
 */
public class Main {

    /**
     */
    public static void main(String[] args) {
        
        //Declaração dos objetos
        GramaticaDados Betta=new GramaticaDados();
        Janela Jan=new Janela();
        ChatBot cb=new ChatBot();
   
        Jan.setVisible(true);
        
        Betta.Nome="Betta";
        Betta.idade=21;
      //  Betta.verbos[0]="gosto";
      //  Betta.verbos[1]="quero";
      //  Betta.verbos[2]="sou";
      //  Betta.verbos[3]="tenho";
        //-----------------------
        
        Betta.doces[1]="chocolate";
        Betta.doces[2]="sorvete";
        Betta.doces[3]="bombom";
        Betta.doces[4]="musse";
        Betta.docesRespostas[1]="amo chocolate";
        Betta.docesRespostas[2]="adoro sorvete";
        Betta.docesRespostas[3]="bombom é show";
        Betta.docesRespostas[4]="musse é bom demais";
        
        //Todos cumprimentos são equivalentes, respostas dos cumprimentos tambem
        Betta.cumprimentos[1]="Oi";
        Betta.cumprimentos[2]="oi";
        Betta.cumprimentos[3]="ola";
        Betta.cumprimentos[4]="ola";
        Betta.cumprimentos[5]="bom dia";
        Betta.cumprimentos[6]="boa tarde";
        Betta.cumprimentos[7]="boa noite";
        Betta.cumprimentos[8]="bom dia";
        Betta.cumprimentos[9]="hey";        
        
        Betta.respostasCumprimentos[1]="Oi tudo bem?";
        Betta.respostasCumprimentos[2]="Olá como vai você";
        Betta.respostasCumprimentos[3]="Hey! Tudo certinho?";
        Betta.respostasCumprimentos[4]="Oi! que bom que você apareceu!";
       
        //frases aleatorias de apresentação
        Betta.frasesApresentacao[1]="Olá, meu nome é Betta! Gostaria de olhar o cardápio?";
        Betta.frasesApresentacao[2]="Olá! Sou a Betta, a dona desta lanchonete, posso ajudar?";
        Betta.frasesApresentacao[3]="Oi! Sou a Betta, vou atende-lo hoje. O que deseja?";        
        Betta.frasesApresentacao[4]="Um visitante na lanchonete! Olá, posso ajudar?"; 
        
        
        Produto coca=new Produto();
        coca.nome="coca-cola";
        coca.valor=6;
        coca.ingredientes[0]="água-gaseificada";
        coca.ingredientes[1]="acucar";
        coca.ingredientes[2]="sodio";
        coca.ingredientes[3]="corante de caramelo";
        coca.sinonimos[0]="coca";
        coca.sinonimos[1]="Coca";
        coca.sinonimos[2]="coca-cola";
        coca.sinonimos[3]="diet coke";
        
        Produto guarana=new Produto();
        guarana.nome="guarana";
        guarana.valor=5;
        guarana.ingredientes[0]="água-gaseificada";
        guarana.ingredientes[1]="acucar";
        guarana.ingredientes[2]="sodio";
        guarana.ingredientes[3]="corante de guarana";
        guarana.sinonimos[0]="guaraná";
        guarana.sinonimos[1]="kuat";
        guarana.sinonimos[2]="baré";
        guarana.sinonimos[3]="guarana";
        
        Produto cerveja=new Produto();
        cerveja.nome="cerveja";
        cerveja.valor=7;
        cerveja.ingredientes[0]="água-gaseificada";
        cerveja.ingredientes[1]="alcool";
        cerveja.ingredientes[2]="malte";
        cerveja.ingredientes[3]="cevada";
        cerveja.sinonimos[0]="brahma";
        cerveja.sinonimos[1]="kaiser";
        cerveja.sinonimos[2]="schin";
        cerveja.sinonimos[3]="cerveja";
        
        Produto pizzaCalabresa=new Produto();
        pizzaCalabresa.nome="pizza calabresa";
        pizzaCalabresa.valor=42;
        pizzaCalabresa.ingredientes[0]="calabresa";
        pizzaCalabresa.ingredientes[1]="cebola";
        pizzaCalabresa.ingredientes[2]="queijo";
        pizzaCalabresa.ingredientes[3]="pimentao";
        pizzaCalabresa.sinonimos[0]="calabresinha";
        pizzaCalabresa.sinonimos[1]="pizza";
        pizzaCalabresa.sinonimos[2]="calabresa";
        pizzaCalabresa.sinonimos[3]="pizza calabresa";
        
        Produto nulo=new Produto();
        nulo.nome="nulo";
        nulo.valor=0;
        nulo.ingredientes[0]="";
        nulo.ingredientes[1]="";
        nulo.ingredientes[2]="";
        nulo.ingredientes[3]="";
        nulo.sinonimos[0]="";
        nulo.sinonimos[1]="";
        nulo.sinonimos[2]="";
        nulo.sinonimos[3]="";
        
        
        Betta.listaProdutos[0]=nulo;
        Betta.listaProdutos[1]=coca;
        Betta.listaProdutos[2]=guarana;
        Betta.listaProdutos[3]=cerveja;
        Betta.listaProdutos[4]=pizzaCalabresa;
        
        Betta.frasePadraoProdutos[0]="Vai uma coca bem gelada?";
        
        //Declarando o pedido e setando ele no campo pedido do objeto chatbot
        Pedido atual=new Pedido();
        atual.produtosPedidos[0]=nulo;
        atual.produtosPedidos[1]=nulo;
        atual.produtosPedidos[2]=nulo;
        atual.produtosPedidos[3]=nulo;
        atual.produtosPedidos[4]=nulo;
        atual.produtosPedidos[5]=nulo;
        atual.produtosPedidos[6]=nulo;
        atual.produtosPedidos[7]=nulo;
        atual.produtosPedidos[8]=nulo;
        
        Betta.janela=Jan;
        cb.GD=Betta;
        cb.janela=Jan;
        Jan.cb=cb;
        
        cb.pedido=atual;
        cb.GD.inicializa_Gostos_Sobre_Produtos();
        
        //frase inicial do bot, e a animação da imagem
        cb.janela.falaBot(cb.fraseRandom(cb.GD.frasesApresentacao));
        
        Thread t = new Thread(new Runnable() {
                        public void run()
                        {
                                cb.janela.lbImagem.setIcon(new ImageIcon("img//imagemHappy.jpg"));
                                cb.janela.lbImagem.repaint();
                                 try{
                                   Thread.sleep(3000);
                                }
                                catch(InterruptedException ie)
                                {
                    
                                }
                                 
                                cb.janela.lbImagem.setIcon(new ImageIcon("img//imagemNormal.jpg"));
                                cb.janela.lbImagem.repaint();
                        }
                        });
        
        t.start();
           
    }
    
}
