package Pacotes;

public class ContaPoupanca extends ContaCorrente {
	public double valorPoupanca;
	public double saldoPoupanca = 300;
	
	public Double getSaldo() {
		return saldoPoupanca;
	}
	public Double setSaldo() {
		return saldoPoupanca;
			
	}
	
	public ContaPoupanca(int numConta, String titularConta, double saldoConta) {
		super(numConta, titularConta, saldoConta);
		
	}
	
	public ContaPoupanca(int numConta, String titularConta, double saldoConta, double valorPoupanca) {
		super(numConta, titularConta, saldoConta);
		this.valorPoupanca = valorPoupanca;
	}
	
	void resgatar() {
		saldoPoupanca = getSaldo() - valorPoupanca;
		System.err.println("Resgate realizado! \nO Saldo atual da conta poupança é R$: " + getSaldo());
	}
	
	void saldoPoupanca() {
		System.out.println("O Saldo atual da sua conta poupança é : R$ " + getSaldo());
}
	void dadosDaContaPoupanca() {
	 	System.err.println("+-------------------------------------+");
	 	System.err.println("TITULAR DA POUPANÇA : " + titularConta);
		System.err.println("NÚMERO DA CONTA : " + numConta + "-1");
		System.err.println("SALDO ATUAL : " + getSaldo());
		System.err.println("+-------------------------------------+");
	}
}
