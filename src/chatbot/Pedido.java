/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

/**
 *
 * @author Regson
 */
public class Pedido {
    
    public Produto[] produtosPedidos=new Produto[9];
    public int indiceAtual=0;
    
    
    public double valorTotalPedido()
    {
        double total=0;
        for(int x=0;x<produtosPedidos.length;x++)
        {
            total=total+produtosPedidos[x].valor;
        }
        
        return total;
    }
    
}
