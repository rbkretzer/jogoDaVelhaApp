
package application;

import java.util.Scanner;

public class JogoDaVelha {
	
	private Mapa jogoMapa;
	private Jogador jogoJogador;
	private PC jogoPC;

	private JogoDaVelha() {
		Scanner teclado = new Scanner(System.in);
		this.jogoMapa = new Mapa();
		this.jogoJogador = new Jogador(this.jogoMapa);
		this.jogoPC = new PC(this.jogoMapa);
		char resposta;
		do {
			jogar(teclado);
			System.out.println("\n________________________\nDeseja jogar novamente (s/n)? ");
			resposta = teclado.next().trim().toLowerCase().charAt(0);
			while(resposta!='n' && resposta!='s') {
				System.out.println("Resposta inválida!");
				resposta = teclado.next().trim().toLowerCase().charAt(0);
			}
		} while (resposta != 'n');
		System.out.println("--- FIM ---");
		teclado.close();
	}

	private void jogar(Scanner teclado) {
		int numeroJogadas = 0;
		boolean alguemVenceu = false;

		this.jogoMapa.limpar();
		int quemComeca = this.jogoMapa.sortear(0, 2);
		
		do{
			this.jogoMapa.desenhar(numeroJogadas);
			if(quemComeca%2 == 0){
				alguemVenceu = this.jogoPC.jogar();

			}else{
				alguemVenceu = this.jogoJogador.jogar(teclado);

			}
			quemComeca ++;
			numeroJogadas ++;
		}while(numeroJogadas < 9 && !alguemVenceu);
		if (numeroJogadas == 9 && !alguemVenceu) {
			System.out.println(" ... EMPATOU!");
		}
		this.jogoMapa.desenhar(numeroJogadas);
	}

	public static void main(String[] args) {
		new JogoDaVelha();
	}
}
