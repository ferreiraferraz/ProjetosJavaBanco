package Pacotes;

public class ContaCorrente {
public int numConta;
public String titularConta;
private	double saldoConta;
public double valor;

public ContaCorrente(int numConta, String titularConta, double saldoConta) {
	this.numConta = numConta;
	this.titularConta = titularConta;
	this.saldoConta = saldoConta;
}
public ContaCorrente(String titularConta) {
	this.titularConta = titularConta;
	
}

//public ContaCorrente(double saldoConta) {
//	this.saldoConta = saldoConta;
//}

public Double getSaldo() {
	return saldoConta;
}
public Double setSaldo() {
	return saldoConta;
		
}

 void sacar() {
	 //realizar um teste do valor do saque para não ultrapassar o saldoConta na classe Banco
	 saldoConta = getSaldo() - valor;
	 System.err.println("\nSaque realizado com sucesso!");
}
 void depositar() {
	//ja usei
	saldoConta = getSaldo() + valor;
	System.err.println("\nSeu Depósito foi realizado!");
}

 void saldoDaConta() {
		System.out.println("O Saldo atual da sua conta é : R$ " + saldoConta);
}
 
 void aplicar() {
	 	saldoConta = getSaldo() + valor;
	 	System.out.println("Saldo de: R$ " + valor + " aplicado na conta corrente com sucesso! ");
	 	
}

 void dadosDaContaCorrente() {
	 	System.err.println("+-------------------------------------+");
	 	System.err.println("      DADOS DA CONTA                   ");
		System.err.println("TITULAR DA CONTA CORRENTE : " + titularConta);
		System.err.println("NÚMERO DA CONTA : " + numConta);
		System.err.println("SALDO ATUAL : " + saldoConta);
		System.err.println("+-------------------------------------+");
	}

}
