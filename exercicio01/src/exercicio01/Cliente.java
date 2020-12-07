package exercicio01;


public class Cliente {

private String nome;
private String endereco;
private String CPF;



public Cliente(String nome, String endereco, String CPF){
    this.nome = nome;
    this.endereco = endereco;
    this.CPF= CPF;
}

public Cliente() {
	
}

public String getNome(){
    return this.nome;
}
public void setNome(String nome){
    this.nome = nome;
}
public String getEndereco(){
    return this.endereco;
}
public void setEndereco(String endereco){
    this.endereco = endereco;
}
public String getCPF(){
    return this.CPF;
}
public void setCPF(String CPF){
    this.CPF = CPF;
}



}
