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
		// por que essa indica��o da vari�vel?
		
		
		System.err.println("Ol�, bem vindo ao Fuctura Bank. Vamos cadastrar a sua conta:");
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
		
		System.out.println("Voc� deseja realizar um dep�sito inicial? ");
		System.out.println("1 - SIM | 2 - N�O ");
		
		Scanner recebeResposta = new Scanner(System.in);
		resposta = recebeResposta.nextInt();
		
		// resposta sim para depositar SOMENTE DEP�SITO INICIAL
		
			if (resposta == 1 ) {
				valorDeposito = 0;	
				
				System.out.println("Que bom! Agora, digite o valor que deseja depositar : ");
				Scanner recebeValor = new Scanner(System.in);
				ContaCorrente.valor = recebeValor.nextDouble();
				System.err.println("Criando sua conta... ");
				System.out.println("�timo, " + ContaCorrente.titularConta + ". Sua conta corrente foi aberta com n�mero : " + ContaCorrente.numConta);
				
				ContaCorrente.depositar(); 
				System.err.println("O Saldo atual da sua conta corrente � R$ " + ContaCorrente.getSaldo());
				
				//inicio das op��es do menu para resgate e dados da conta
				System.out.println("Agora que voc� possui uma conta criada, escolha as op��es dispon�veis: ");
				System.err.println("+-------------------------------------+");
			 	System.err.println("1 - RESGATAR POUPAN�A");
			 	System.err.println("2 - SACAR DA CONTA CORRENTE");
			 	System.err.println("3 - INFORMA��ES DAS CONTAS");
				System.err.println("+-------------------------------------+");
								
				Scanner recebeResposta1 = new Scanner(System.in);
				resposta = recebeResposta1.nextInt();
				
				if (resposta == 1 ) {
					
					double recebeValorPoup;
					ContaPoupanca ContaPoupanca = new ContaPoupanca(0, null, 0);
					System.out.println("Op��o Resgatar: Insira o valor que deseja resgatar da poupan�a");
					System.err.println("Saldo dispon�vel para resgate : R$ " + ContaPoupanca.getSaldo());
					Scanner recebeValor1 = new Scanner(System.in);
					recebeValorPoup = recebeValor1.nextDouble();
					ContaPoupanca.valorPoupanca = recebeValorPoup;
					ContaPoupanca.resgatar();
					
					ContaCorrente.valor = recebeValorPoup;
					ContaCorrente.aplicar();
					System.err.println("O Saldo atual da sua conta corrente agora � R$ " + ContaCorrente.getSaldo());
					
					recebeValor1.close();
				}
				
						if (resposta == 2 ) {
						
						double recebeValorPoup;
						System.out.println("Op��o Sacar: Insira o valor que deseja sacar da conta corrente");
						System.err.println("Saldo dispon�vel para saque : R$ " + ContaCorrente.getSaldo());
						Scanner recebeValor1 = new Scanner(System.in);
						recebeValorPoup = recebeValor1.nextDouble();
						
						if (recebeValorPoup <= ContaCorrente.getSaldo()) {
							ContaCorrente.valor = recebeValorPoup;
							ContaCorrente.sacar();
							System.err.println("O Saldo atual da sua conta corrente agora � R$ " + ContaCorrente.getSaldo());
							recebeValor1.close();
						}
							if (recebeValorPoup > ContaCorrente.getSaldo()) {					
							System.err.println("Este valor � maior que o saldo da conta. Saque n�o efetuado!");
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
				System.err.println("Que pena, s� podemos abrir a conta se houver um dep�sito inicial de qualquer valor. \nO Fuctura Bank agradece!");
								
			}
			
		}
	
}
