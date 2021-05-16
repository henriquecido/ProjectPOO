package exercicio01;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Conta conta = new Conta();
        int escolha,exit = 0;

        
        do{
            System.out.println("\n\n  -  Caixa Economica  -\n");
            System.out.println(" 1- Criar uma Conta ");
            System.out.println(" 2- Fazer Login ");
            System.out.println(" 3- Sacar ");
            System.out.println(" 4- Transferir ");
            System.out.println(" 5- Depositar ");
            System.out.println(" 6- Saldo ");
            System.out.println(" 7- Extrato ");
            System.out.println(" 8- Remover Conta ");
            System.out.println(" 9- Deslogar ");
            System.out.println(" 0- Sair ");
            System.out.println("-- -- -- -- -- -- -- --");
            System.out.print("Escolha:  ");
            escolha = teclado.nextInt();
            teclado.nextLine();
            switch(escolha){
                case 1:
                    conta.adicionarCliente();
                    break;
                case 2:
                	conta.loginCliente();
                    break;
                case 3:
                	conta.Sacar();
                    break;
                case 4:
                	conta.Transferir();
                    break;
                case 5:
                	conta.Depositar();
                    break;
                case 6:
                	conta.Saldo();
                    break;
                case 7:
                	conta.Extrato();
                    break;
                case 8:
                	conta.removerCliente();
                    break;
                case 9:
                	conta.sairCliente();
                    break;
                case 0:
                	System.out.println("\n Programa Finalizado !");		
                    exit=3;
                	break;
                default:
                	System.out.println("\n Opção Invalida !\n Selecione de 1 a 0 !");		
            }
            
            
            
        }while(exit != 3);
	
	}

}

