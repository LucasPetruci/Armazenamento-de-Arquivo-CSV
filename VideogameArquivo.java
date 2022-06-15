
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class VideogameArquivo {

	public static void main(String[] args) {
		Scanner entradaDoTeclado = new Scanner(System.in);
		int opcaoArmazenamentoEmMemoria, opcaoMenuPrincipal;
		ColecaoDeJogos listaDeJogos = null;
		ArquivoDeJogos arquivoDeJogos;
		System.out.println("1 - Vetor");
		System.out.println("2 - ArrayList");
		System.out.println("3 - Lista Encadeada");
		System.out.println("Qual a estrutura de armazenamento em memória você deseja utilizar?");
		opcaoArmazenamentoEmMemoria = entradaDoTeclado.nextInt();
		if (opcaoArmazenamentoEmMemoria == 1) {
			listaDeJogos = new VetorDeJogos();
		}
		else if (opcaoArmazenamentoEmMemoria == 2) {
			listaDeJogos = new ArrayListDeJogos();
		}
		else if (opcaoArmazenamentoEmMemoria == 3)  {
			listaDeJogos = new ListaEncadeada();
		}
		arquivoDeJogos = new ArquivoTextoDeJogos();
		arquivoDeJogos.lerDoArquivoParaMemoria(listaDeJogos);

		do {
			System.out.println("\n\n*************** Menu de Opções ****************");
			System.out.println("1 - Adicionar jogo");
			System.out.println("2 - Excluir jogo");
			System.out.println("3 - Listar jogos");
			System.out.println("4 - Ordenar lista pelo ano");
			System.out.println("5 - Buscar jogo");
			System.out.println("6 - Ordenar Por Nome");
			System.out.println("7 - Busca Binária");
			System.out.println("0 - Sair do programa");
			opcaoMenuPrincipal = entradaDoTeclado.nextInt();
			switch (opcaoMenuPrincipal) {
			case 1:
				Jogo jogo = criarJogo();
				listaDeJogos.adicionarJogo(jogo);
				break;
			case 2:
				excluirJogo(listaDeJogos);
				break;
			case 3:
				listarJogos(listaDeJogos);
				break;
			case 4:
				buscaSequencial(listaDeJogos);				
				break;
			case 5:
				listaDeJogos.ordernarPorAno(new MetodoDaBolha());
				break;
			case 6:
				listaDeJogos.ordernarPorNome(new MetodoDaBolha());
				break;
			case 7:
				buscaBinaria(listaDeJogos);
				break;
			}
		} while (opcaoMenuPrincipal != 0);
		arquivoDeJogos.escreverDaMemoriaNoArquivo(listaDeJogos);
	}

	private static Jogo criarJogo() {
		Scanner entradaDoTeclado = new Scanner(System.in);
		String nome, plataforma;
		int ano;
		double vendasGlobais;

		System.out.println("Entre com o nome do jogo:");
		nome = entradaDoTeclado.nextLine();
		System.out.println("Entre com a plataforma:");
		plataforma = entradaDoTeclado.nextLine();
		System.out.println("Entre com o ano de lançamento:");
		ano = entradaDoTeclado.nextInt();
		System.out.println("Entre com o total de vendas globais:");
		vendasGlobais = entradaDoTeclado.nextDouble();
		Jogo jogo = new Jogo(nome, plataforma, ano, vendasGlobais);
		return jogo;

	}

	private static void excluirJogo(ColecaoDeJogos listaDeJogos) {
		boolean excluiu;

		excluiu = listaDeJogos.excluirJogo();
		if (excluiu == true) {
			System.out.println("Jogo exclusão com sucesso.");
		} else {
			System.out.println("Jogo não encontrado.");
		}
	}

	public static void listarJogos(ColecaoDeJogos listaDeJogos) {
		int totalDeJogos = listaDeJogos.obterTotalDeJogos();

		if (totalDeJogos > 0) {
			Jogo jogo;
			for (int indiceDoJogo = 0; indiceDoJogo < totalDeJogos; indiceDoJogo++) {
				jogo = listaDeJogos.obterJogo(indiceDoJogo);
				System.out.println("\n------------------------------------------");
				System.out.println("Nome do Jogo:" + jogo.obterNome());
				System.out.println("Plataforma:" + jogo.obterPlataforma());
				System.out.println("Ano de lançamento:" + jogo.obterAno());
				System.out.println("Total de vendas globais:" + jogo.obterVendasGlobais());
			}
		} else {
			System.out.println("Não existem jogos cadastrados na lista.");
		}
	}
	private static void buscaSequencial(ColecaoDeJogos listaDeJogos) {
		Scanner entradaTeclado = new Scanner(System.in);
		VetorDeJogos procurarNome = new VetorDeJogos();
		System.out.println("Digite o jogo que deseja buscar: ");
		String buscarNome = entradaTeclado.nextLine();
		Jogo jogo;
		int totalJogos = listaDeJogos.obterTotalDeJogos();
		String vetorNome[] = new String[totalJogos];

		for (int i = 0; i < totalJogos; i++) {
			jogo = listaDeJogos.obterJogo(i);
			vetorNome[i] = jogo.obterNome();
		}
		int posicaoEncontrada = procurarNome.buscaSequencialString(buscarNome, vetorNome, totalJogos);

		jogo = listaDeJogos.obterJogo(posicaoEncontrada);
		System.out.println("\n------------------------------------------");
		System.out.println("Nome do Jogo:" + jogo.obterNome());
		System.out.println("Plataforma:" + jogo.obterPlataforma());
		System.out.println("Ano de lançamento:" + jogo.obterAno());
		System.out.println("Total de vendas globais:" + jogo.obterVendasGlobais());

	}

	public static void listaOrdenadaAno(Jogo[] listaDeJogos, int totalDeJogos) {
		for(int i = 0; i< totalDeJogos -1;i++) {
			System.out.println(listaDeJogos[i].obterAno());
		}		
	}

	public static void listaOrdenadaNome(Jogo[] listaDeJogos, int totalDeJogos) {
		for(int i = 0; i< totalDeJogos -1;i++) {
			System.out.println(listaDeJogos[i].obterNome());
		}		
	}
	
	private static void buscaBinaria(ColecaoDeJogos listaDeJogos) {

		listaDeJogos.ordernarPorNome(new MetodoDaBolha());
		int inicio = 0;
		int fim = listaDeJogos.obterTotalDeJogos();
		int meio = (inicio + fim) / 2;
		Scanner entradaDoTeclado = new Scanner(System.in);

		System.out.println("Digite o nome a ser buscado: ");
		String busca = entradaDoTeclado.nextLine();
		int teste;
		VetorDeJogos nomeEncontrado = new VetorDeJogos();
		teste = nomeEncontrado.buscaBinariaRecursiva(busca, inicio, fim, meio);
		System.out.println(listaDeJogos.obterJogo(teste));
	}
}
