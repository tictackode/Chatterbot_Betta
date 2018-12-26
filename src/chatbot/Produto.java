/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.text.DecimalFormat;

/**
 *
 * @author Regson
 */
public class Produto {
    
    Produto()
    {
         
    }
        
    public String nome;
    public double valor;
    public String[] ingredientes=new String[4];
    public String[] sinonimos=new String[5];
    
   
    
    public String gera_Frase_Valor()        
    {
        DecimalFormat df = new DecimalFormat("#,###.00");  
        
        return this.nome+" custa R$ "+df.format(this.valor);        
    }
    public String gera_Frase_Adicionado_Ao_Pedido()        
    {
        return this.nome+" anotado! Mais alguma coisa?";       
    }
    
    
}
