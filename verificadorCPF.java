/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import javax.swing.JOptionPane;

/** Verificador de CPF;
 * 
 * @author NetBeans Project by João Lucas (24/09/23)
 */
public class verificadorCPF {
    
    //Definindo a função para o cálculo do segundo digíto do CPF
    public static int calcular_dig2(int[] intCPF){
        
        int somar = 0;
        for (int i = 0; i < 10; i++){
            somar += intCPF[i] * (11 - i);
        }
        int resto2 = (somar * 10) % 11;
        return resto2;
    }
    
    public static void main(String[] args){
        
        boolean continuar = true;
        
        do{
            //Entrada do CPF do usuário
            String input_cpf = JOptionPane.showInputDialog("Digite o CPF: ");

            //Desconsiderando os CPFs de tamanho diferentes de 11
            if (input_cpf.length() != 11){
                JOptionPane.showMessageDialog(null,"CPF inválido!");
            }
            //Desconsiderando os CPFs com números iguais
            else if (input_cpf.equals("00000000000")||input_cpf.equals("11111111111")
                   ||input_cpf.equals("22222222222")||input_cpf.equals("33333333333")
                   ||input_cpf.equals("44444444444")||input_cpf.equals("55555555555")
                   ||input_cpf.equals("66666666666")||input_cpf.equals("77777777777")
                   ||input_cpf.equals("88888888888")||input_cpf.equals("99999999999")){
                JOptionPane.showMessageDialog(null,"CPF inválido!");
            }
            else{
                //Declarando e definindo o tamanho do vetor charCPF
                char[] charCPF = new char[11];  

                //Armazenando cada char do input_cpf no vetor charCPF
                input_cpf.getChars(0, 11, charCPF, 0);

                //Declarando e definindo o tamanho do vetor intCPF
                int[] intCPF = new int[charCPF.length];

                for(int i = 0; i < charCPF.length; i++){

                    //Convertendo cada char para inteiro
                    int n = Integer.parseInt(String.valueOf(charCPF[i]));

                    //Armazenando ao vetor intCPF os valores convertidos
                    intCPF[i] = n;    
                }

                int soma = 0;
                for(int i = 0; i <= 8; i++){

                    //Adicionando à variável soma a multiplicação dos digitos 1 ao 9 pelos seus respectivos multiplicadores
                    soma += intCPF[i] * (10 - i);
                }
                //Atribuindo os dois últimos digítos à variáveis
                int dig1 = intCPF[9], dig2 = intCPF[10], resto;

                resto = (soma * 10) % 11;

                if(resto == dig1){

                    resto = calcular_dig2(intCPF);

                    if(resto == dig2){
                        JOptionPane.showMessageDialog(null, "CPF válido!");
                    }
                    else if (resto > 9){
                        resto = 0;

                        if(resto == dig2){
                            JOptionPane.showMessageDialog(null, "CPF válido!");
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "CPF inválido!");
                        }
                    }
                }
                else if (resto > 9){
                    resto = 0;

                    if (resto == dig1){

                        resto = calcular_dig2(intCPF);

                        if (resto == dig2){
                            JOptionPane.showMessageDialog(null, "CPF válido!");
                        }
                        else if (resto > 9){
                            resto = 0;

                            if (resto == dig2){
                                JOptionPane.showMessageDialog(null, "CPF válido!");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "CPF inválido!");
                            }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"CPF inválido!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"CPF inválido!");
                }
            }
            
            //Perguntando ao usuário se ele gostaria de conferir outro CPF
            String cont = JOptionPane.showInputDialog("Deseja conferir outro CPF?\nSe sim, digite 'SIM'\nSe não, digite 'NÃO'");
            
            if (cont.equals("SIM") ||cont.equals ("Sim") ||cont.equals("sim")){
                continuar = true;
                JOptionPane.showMessageDialog(null,"Programa reiniciado!");
            }
            else if(cont.equals("NÃO")||cont.equals("Não")||cont.equals("não")){
                continuar = false;
                JOptionPane.showMessageDialog(null,"Programa encerrado!");
            }
            else{
                continuar = false;
                JOptionPane.showMessageDialog(null,"Comando inválido!!\nPrograma encerrado!!");
            }
            
        }while(continuar != false);
    }
}