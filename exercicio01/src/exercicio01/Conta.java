package exercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Conta {

Scanner teclado = new Scanner(System.in);


List<Cliente> listclientes;

List<String> listlogados;

List<Conta> listcontas;

private double saldo;
private String numConta;
private Cliente c;
int digito,num;
String nome,endereco,CPF;



Random numAleatorio = new Random();


public Conta(Cliente c) {
	this.saldo = 0.0;
	num = numAleatorio.nextInt(500-100)+100;
	digito = numAleatorio.nextInt(9);
	this.numConta = num + "-" + digito;
	this.c = c;
}

public Conta() {
	listclientes = new ArrayList<>();
	listlogados = new ArrayList<>();
	listcontas = new ArrayList<>();
}

public void Saldo() {
	if(!listlogados.isEmpty()) {
		int x=0;
		for(int i=0; i < listcontas.size();i++) {
        	if(listlogados.get(0).equals(listcontas.get(i).c.getCPF())) {
        		x=i;
        		break;
        	}
		}
		System.out.println("\n Conta - "+listcontas.get(x).numConta);
		System.out.println("\n Seu Saldo é "+listcontas.get(x).saldo);
	}else {
		System.out.println("\n Não existe Conta Logada ! \n");
	}
}

public void Extrato() {
	if(!listlogados.isEmpty()) {
		System.out.println("\n Sua Conta não tem Extrato Ativo ! \n");
	}else {
		System.out.println("\n Não existe Conta Logada ! \n");
	}
}

public void Sacar(){
	if(!listlogados.isEmpty()) {
		int x=0;
		System.out.print("\n Valor do Saque:  ");
		double valor = teclado.nextDouble();
		for(int i=0; i < listcontas.size();i++) {
        	if(listlogados.get(0).equals(listcontas.get(i).c.getCPF())) {
        		x=i;
        		break;
        	}
		}
	    if(listcontas.get(x).saldo > 0 && valor <= listcontas.get(x).saldo){
	        listcontas.get(x).saldo-=valor;
	        System.out.println("\nSaque Realizado com Sucesso !");
	    	System.out.println("\nSeu novo Saldo é "+listcontas.get(x).saldo);       
	    }else{
	        System.out.println("\nValor Invalido ou Saldo Indisponivel !\n");
	    }
	}else {
		System.out.println("\n Não existe Conta Logada ! \n");
	}
}

public void Depositar(){
	if(!listlogados.isEmpty()) {
		System.out.print("\n Valor do Deposito:  ");
		double valor = teclado.nextDouble();
	    if(valor > 0){
	    	for(int i=0; i < listcontas.size();i++) {
	        	if(listlogados.get(0).equals(listcontas.get(i).c.getCPF())) {
	        		listcontas.get(i).saldo+=valor;
	    	        System.out.println("\nDeposito Realizado com Sucesso !");
	    	        System.out.println("\nSeu novo Saldo é "+listcontas.get(i).saldo);
	    	        break;
	        	}
	    	}
	    }else{
	        System.out.println("\nValor de Deposito Invalido !\n");
	    }
	}else {
		System.out.println("\n Não existe Conta Logada ! \n");
	}
}

public void Transferir(){
	if(!listlogados.isEmpty()) {
		int x=0,y=0;
		System.out.print("\n Valor da Transferencia:  ");
		double valor = teclado.nextDouble();
		teclado.nextLine();
		System.out.print("\n Num da Conta:  ");
		String nuConta = teclado.nextLine();
		for(int i=0; i < listcontas.size();i++) {
        	if(listlogados.get(0).equals(listcontas.get(i).c.getCPF())) {
        		x=i;
        		break;
        	}
		}
		for(int i=0; i < listcontas.size();i++) {
        	if(nuConta.equals(listcontas.get(i).numConta)) {
        		y=i;
        		break;
        	}
		}
	    if(listcontas.get(x).saldo > 0 && valor <= listcontas.get(x).saldo ){
	    	listcontas.get(x).saldo-=valor;
	    	listcontas.get(y).saldo+=valor;
	    	System.out.println("\nTransferencia Realizado com Sucesso !");
	        System.out.println("\nSeu novo Saldo é "+listcontas.get(x).saldo);
	    }else {
	    	System.out.println("\nValor de Deposito Invalido ou Conta Invalida !\n");
	    }
	}else {
		System.out.println("\n Não existe Conta Logada ! \n");
	}
}


public void adicionarCliente(){
	if(listlogados.isEmpty()) {
		c = new Cliente();
		System.out.println("\n\n\n-- -- -- -- -- -- -- --");
	    System.out.println("  -  Cadastro  -");
	    System.out.println("-- -- -- -- -- -- -- --\n");
	    System.out.print(" Nome:  ");
	    c.setNome(teclado.nextLine());
	    System.out.print(" Endereco:  ");
	    c.setEndereco(teclado.nextLine());
	    System.out.print(" CPF:  ");
	    c.setCPF(teclado.nextLine());
	    listclientes.add(c);
	    Conta cc =new Conta(c);
	    listcontas.add(cc);
	    System.out.println("\n Cadastrado com Sucesso ! ");
	}else {
		System.out.println("\n Voce está Logado ! \n Deslogue para criar uma nova Conta ! \n");
	}
}



public void removerCliente(){
	if(!listlogados.isEmpty()) {
		for(int i=0; i < listclientes.size();i++) {
			if(listclientes.get(i).getCPF().equals(listlogados.get(0))) {
				System.out.println("\n -- Dados da Conta -- \n");
				System.out.println(" Nome: "+listclientes.get(i).getNome());
				System.out.println(" Endereço: "+listclientes.get(i).getEndereco());
				System.out.println(" CPF: "+listclientes.get(i).getCPF());
				listclientes.remove(i);
				listlogados.remove(0);
			}
		}
		System.out.println("\n Conta Removida com Sucesso ! \n");
		System.out.println("\n  -  Você foi Deslogado - \n");
	}else{
		System.out.println("\n Não existe Conta Logada ! \n");
	}
}



public void loginCliente(){
	int v = 0;
	if(listlogados.isEmpty()) {	
		System.out.println("\n\n\n-- -- -- -- -- -- -- --");
	    System.out.println("  -  Login  -");
	    System.out.println("-- -- -- -- -- -- -- --\n");
	    System.out.print(" Nome:  ");
	    nome = teclado.nextLine();
	    System.out.print(" CPF:  ");
	    CPF = teclado.nextLine();
	    
	    for(Cliente c : listclientes) {
	    	if(c.getNome().equals(nome) && c.getCPF().equals(CPF)) {
	    	    listlogados.add(c.getCPF());
	    		v=1;
	    		break;
	    	}
	    }
	    
	    if(v != 0) {
	    	System.out.println("\n\n Login realizado com Sucesso !\n\n");
	    	for(int i=0; i< listcontas.size();i++) {
		    	if(listlogados.get(0).equals(listcontas.get(i).c.getCPF())) {
			    	System.out.println("\n\nNome:  "+listcontas.get(i).c.getNome());
					System.out.println("Endereco:  "+listcontas.get(i).c.getEndereco());
					System.out.println("CPF:  "+listcontas.get(i).c.getCPF());
					System.out.println("Numero da Conta:  "+listcontas.get(i).numConta);
					System.out.println("saldo da Conta:  "+listcontas.get(i).saldo+"\n\n");
					break;
		    	}
    	
	    	}
	    	
	    }else {
	    	System.out.println("\n Login Invalido ! \n");
	    }
	}else {
		System.out.println("\n Você já está Logado ! \n");
	}
}



public void sairCliente(){
	if(!listlogados.isEmpty()) {
		listlogados.remove(0);
		System.out.println("\n Deslogado com Sucesso ! \n");
	}else {
		System.out.println("\n Não existe Conta Logada ! \n");
	}
}


public double getSaldo(){
    return this.saldo;
}
public void setSaldo(double saldo){
    this.saldo = saldo;
}
public String getnumConta(){
    return this.numConta;
}
public Cliente getCliente() {
	c = new Cliente();
	return c;
}
public void setCliente(Cliente c) {
	this.c = c;
}




}

