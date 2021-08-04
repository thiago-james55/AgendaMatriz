/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamatriz;

import java.util.Arrays;

/**
 *
 * @author Pichau
 */
public class AgendaMatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Ano primeiro = new Ano(2021);
        
        primeiro.AdicionarNaAgenda(0, 0, 13, "RenovarCNH!"); //Dia 1 de Janeiro as 14:00 - Renovar CNH
        primeiro.ConsultarAgenda(0, 0, 13);
        
        
    }
    
}
