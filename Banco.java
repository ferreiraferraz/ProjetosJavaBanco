package Pacotes;
import java.util.Scanner;
import java.util.Random;

public class Banco {
	public static void main(String[] args) {
			
		String nome = null;
		int resposta, contarandom;
		double valorDeposito;
		double valorResgate;
		//String valorteste;
		// por que essa indicação da variável?
		
		
		System.err.println("Olá, bem vindo ao Fuctura Bank. Vamos cadastrar a sua conta:");
		System.out.println("Digite o nome do titular da conta: ");
		Scanner inputS = new Scanner(System.in);
		
		ContaCorrente ContaCorrente = new ContaCorrente(nome);
		//instancia da classe ContaCorrente
		
		ContaCorrente.titularConta = inputS.nextLine();
		//o titular da classe ContaCorrente recebe o nome digitado
		
		Random random = new Random();
		contarandom = random.nextInt(10000);
		ContaCorrente.numConta = contarandom;
		//o numero da conta da classe ContaCorrente recebe a conta randomica
		
		System.out.println("Você deseja realizar um depósito inicial? ");
		System.out.println("1 - SIM | 2 - NÃO ");
		
		Scanner recebeResposta = new Scanner(System.in);
		resposta = recebeResposta.nextInt();
		
		// resposta sim para depositar SOMENTE DEPÓSITO INICIAL
		
			if (resposta == 1 ) {
				valorDeposito = 0;	
				
				System.out.println("Que bom! Agora, digite o valor que deseja depositar : ");
				Scanner recebeValor = new Scanner(System.in);
				ContaCorrente.valor = recebeValor.nextDouble();
				System.err.println("Criando sua conta... ");
				System.out.println("Ótimo, " + ContaCorrente.titularConta + ". Sua conta corrente foi aberta com número : " + ContaCorrente.numConta);
				
				ContaCorrente.depositar(); 
				System.err.println("O Saldo atual da sua conta corrente é R$ " + ContaCorrente.getSaldo());
				
				//inicio das opções do menu para resgate e dados da conta
				System.out.println("Agora que você possui uma conta criada, escolha as opções disponíveis: ");
				System.err.println("+-------------------------------------+");
			 	System.err.println("1 - RESGATAR POUPANÇA");
			 	System.err.println("2 - SACAR DA CONTA CORRENTE");
			 	System.err.println("3 - INFORMAÇÕES DAS CONTAS");
				System.err.println("+-------------------------------------+");
								
				Scanner recebeResposta1 = new Scanner(System.in);
				resposta = recebeResposta1.nextInt();
				
				if (resposta == 1 ) {
					
					double recebeValorPoup;
					ContaPoupanca ContaPoupanca = new ContaPoupanca(0, null, 0);
					System.out.println("Opção Resgatar: Insira o valor que deseja resgatar da poupança");
					System.err.println("Saldo disponível para resgate : R$ " + ContaPoupanca.getSaldo());
					Scanner recebeValor1 = new Scanner(System.in);
					recebeValorPoup = recebeValor1.nextDouble();
					ContaPoupanca.valorPoupanca = recebeValorPoup;
					ContaPoupanca.resgatar();
					
					ContaCorrente.valor = recebeValorPoup;
					ContaCorrente.aplicar();
					System.err.println("O Saldo atual da sua conta corrente agora é R$ " + ContaCorrente.getSaldo());
					
					recebeValor1.close();
				}
				
						if (resposta == 2 ) {
						
						double recebeValorPoup;
						System.out.println("Opção Sacar: Insira o valor que deseja sacar da conta corrente");
						System.err.println("Saldo disponível para saque : R$ " + ContaCorrente.getSaldo());
						Scanner recebeValor1 = new Scanner(System.in);
						recebeValorPoup = recebeValor1.nextDouble();
						
						if (recebeValorPoup <= ContaCorrente.getSaldo()) {
							ContaCorrente.valor = recebeValorPoup;
							ContaCorrente.sacar();
							System.err.println("O Saldo atual da sua conta corrente agora é R$ " + ContaCorrente.getSaldo());
							recebeValor1.close();
						}
							if (recebeValorPoup > ContaCorrente.getSaldo()) {					
							System.err.println("Este valor é maior que o saldo da conta. Saque não efetuado!");
							System.err.println("Seu saldo ainda continua R$ " + ContaCorrente.getSaldo());
							}
						
					}
						if (resposta == 3 ) {
							ContaCorrente.dadosDaContaCorrente();
							ContaPoupanca ContaPoupanca = new ContaPoupanca(ContaCorrente.numConta, ContaCorrente.titularConta, 0);
							ContaPoupanca.dadosDaContaPoupanca();
							
						}
				recebeValor.close();
				recebeResposta.close();
				recebeResposta1.close();
			} else {
				ContaCorrente.numConta = 0;
				ContaCorrente.titularConta = "";
				System.err.println("Que pena, só podemos abrir a conta se houver um depósito inicial de qualquer valor. \nO Fuctura Bank agradece!");
								
			}
			
		}
	
}
