/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamatriz;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class OperacoesAgenda {
    
    private ArrayList<Ano> agenda = new ArrayList<>();

    
    public String ConsultaAgendaAnoMesDiaHora(int ano, int mes, int dia , int hora, boolean todos) {
        
        boolean existeAnoCadastrado = false;
        int posicaoAno = 0;
        
        PROCURA_AGENDA: for (int i = 0; i <= this.agenda.size(); i++) {
            
            if (this.agenda.get(i).getAno() == ano) {
                
                existeAnoCadastrado = true;
                posicaoAno = i;
                break PROCURA_AGENDA;
                            
                
            
            } //IF
            
            
        } //FOR
        
        if (existeAnoCadastrado) {
            
            return this.agenda.get(posicaoAno).ConsultarAgenda(mes, dia, hora,todos);
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Não existe esse ano cadastrado");
            return "Erro!";
            
        }
        
        
        
        
    }

    public void CadastrarCompromisso(int ano, int mes, int dia , int hora,String compromisso) {
        
        for (int i = 0; i < this.agenda.size(); i++) {
            
            if (this.agenda.get(i).getAno() == ano) {
                
                this.agenda.get(i).AdicionarNaAgenda(mes, dia, hora, compromisso);
                
                if (!"Sem compromissos marcados neste dia!".equals(this.agenda.get(i).ConsultarAgenda(mes, dia, hora, false))) {
                    
                JOptionPane.showMessageDialog(null, "Compromisso salvo com sucesso!");
                
                }
                
                break;
                
            }
            
            
            
        }
        
    }
    
    public void CadastrarNovoAno(int ano) {
        
        Ano novoAno = new Ano(ano);
        
        boolean existeAnoCadastrado = false;
        
         PROCURA_AGENDA: for (int i = 0; i < this.agenda.size(); i++) {
            
             if (this.agenda.size() > 0) {
                 
            if (this.agenda.get(i).getAno() == ano) {
                
                existeAnoCadastrado = true;
                break PROCURA_AGENDA;
                            
             } else {
                
             }
 
             
                
            
            } //IF
            
            
        } //FOR
        
        if (existeAnoCadastrado) {
            
            
        JOptionPane.showMessageDialog(null, "Erro! Ano já cadastrado");
            
        } else {
            
        JOptionPane.showMessageDialog(null, "Ano cadastrado com sucesso");
        
        this.agenda.add(novoAno);
        
        }
        
 
        
    }
    
    
    public int TamanhoAgenda() {
            
        return this.agenda.size();
            
    }

    public ArrayList<Ano> getAgenda() {
        
        
        
        return agenda;
    }
    
    
}
