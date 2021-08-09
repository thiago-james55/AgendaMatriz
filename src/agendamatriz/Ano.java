/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendamatriz;

import javax.swing.JOptionPane;

/**
 *
 * @author Pichau
 */
public class Ano {
    
    private String[][][] agenda = new String[12][31][24]; // Mes, Dia , Hora!
    
    private int ano;
    
    private boolean bissexto;

    public Ano(int ano) {
        
        this.setAno(ano);
        
    }
    
       
    
    public void Bissexto(int ano){ // verifica se o ano é bissexto
		
						
		if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))){
                        
                    this.bissexto = true;

                }
                
		else{
                    
                    this.bissexto = false;
			
		}
	} // Final Metodo Bissexto

    //public String[][][] getAgenda() {
    //    return agenda;
    //}

    public void AdicionarNaAgenda(int mes, int dia , int hora, String compromisso) {
        
        //int mes = Integer.parseInt(mesString);
        //int dia = Integer.parseInt(diaString);
        //int hora = Integer.parseInt(horaString);
        
        boolean diaValido = true;
          
        
        //Serie de testes para ver se o dia é valido!
        if (!this.bissexto && mes == 1 && dia > 27 ) {
            
            diaValido = false;
            JOptionPane.showMessageDialog(null, "Erro! Dia maximo em fevereiro neste ano é 28!");
            
        } else if (this.bissexto && mes == 1 && dia > 28) {
            
            diaValido = false;
            JOptionPane.showMessageDialog(null, "Erro! Dia maximo em fevereiro neste ano é 29!");
            
        } else if ( (mes == 3 || mes == 5 || mes == 8 || mes == 10) && dia > 29 ) {
            
            diaValido = false;
            JOptionPane.showMessageDialog(null, "Erro! Dia maximo deste mês é 30!");
                        
        } 
        
        if (hora > 23) {
            
            diaValido = false;
            JOptionPane.showMessageDialog(null, "Erro! Hora maxima permitida é 23!");
            
        }
        
        
        
        if (diaValido) {
            
            this.agenda[mes][dia][hora] = compromisso;
            
        } else {
            
            
            
        }
        
        
    } // final set agenda
    
    public String ConsultarAgenda(int mes , int dia , int hora, boolean todos) {
        
        String semCompromissos = "Sem compromissos marcados neste dia!";
        boolean existeCompromissos = false;
        
        for (int i = 0; i < 24; i++) {
            
            if (this.agenda[mes][dia][i] != null) {
                
                existeCompromissos = true;
                
            }
            
        }
        
        if (existeCompromissos) {
            
            if (todos) {
                
                String compromissos = "<html> ";
                
                for (int i = 0; i < 24; i++) {
            
                if (this.agenda[mes][dia][i] != null) {
                
                    compromissos += (i) +":00 - " + this.agenda[mes][dia][i] + "<br>" ;
                
                }
            
                }
                
                compromissos += " </html>";
                
                return compromissos;
                     
            
            
            } else {
            
            if (this.agenda[mes][dia][hora] != null) {
            
                return this.agenda[mes][dia][hora];
            
            } else {
            
            return semCompromissos;
            
            }
        
            }
            
        } else {
            
            return semCompromissos;
            
        }
        
        
        
        
                
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
        this.Bissexto(ano);
    }

    public boolean isBissexto() {
        return bissexto;
    }

    
    
    
    
    
    
}
