import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoTextoDeJogos implements ArquivoDeJogos {
	
	@Override
	public void lerDoArquivoParaMemoria(ColecaoDeJogos listaDeJogos) {
		FileReader arquivoDeEntrada = null;
		BufferedReader leituraBufferizada;
		String linhaLidaDoArquivo;
		Jogo jogo;
		
		try {
			arquivoDeEntrada = new FileReader("vgsales.txt");
			leituraBufferizada = new BufferedReader(arquivoDeEntrada);

			linhaLidaDoArquivo = leituraBufferizada.readLine();
			while (linhaLidaDoArquivo != null) {
				jogo = criarObjetoJogo(linhaLidaDoArquivo);
				listaDeJogos.adicionarJogo(jogo);
				linhaLidaDoArquivo = leituraBufferizada.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro de entrada e saida!");
			e.printStackTrace();
		} 
		
		try {
			arquivoDeEntrada.close();
		} 
		catch (IOException e) {
			System.out.println("Erro de entrada e saida!");
			e.printStackTrace();
		} 
		catch (NullPointerException e) {
			System.out.println("Erro: Arquivo não encontrado!");
			e.printStackTrace();
		}
	}
	
	public Jogo criarObjetoJogo(String linhaLidaDoArquivo) {
		String nomeDoJogo, plataforma;
		int ano;
		double vendasGlobais;
		String camposDoArquivo[];
		
		camposDoArquivo = linhaLidaDoArquivo.split(",");
		//System.out.println(camposDoArquivo[0] + "," + camposDoArquivo[1] + "," + camposDoArquivo[2] + "," + camposDoArquivo[3]);
		nomeDoJogo = camposDoArquivo[0];
		plataforma = camposDoArquivo[1];
		ano = Integer.parseInt(camposDoArquivo[2]);			
		vendasGlobais = Double.parseDouble(camposDoArquivo[3]);
		return new Jogo(nomeDoJogo, plataforma, ano, vendasGlobais);
	}
	
	private static void ordenarAno(ColecaoDeJogos listaDeJogos) {
		
		
	}

	@Override
	public void escreverDaMemoriaNoArquivo(ColecaoDeJogos listaDeJogos) {
		FileWriter arquivoDeSaida = null;
		String nomeDoJogo, plataforma;
		int ano;
		double vendasGlobais;
		try {
			arquivoDeSaida = new FileWriter("vgsales.txt");
			int totalDeJogos = listaDeJogos.obterTotalDeJogos();
			
			for (int indiceDoJogo = 0; indiceDoJogo < totalDeJogos; indiceDoJogo++) {
				nomeDoJogo = listaDeJogos.obterJogo(indiceDoJogo).obterNome();
				plataforma = listaDeJogos.obterJogo(indiceDoJogo).obterPlataforma();
				ano = listaDeJogos.obterJogo(indiceDoJogo).obterAno();
				vendasGlobais = listaDeJogos.obterJogo(indiceDoJogo).obterVendasGlobais();
				arquivoDeSaida.write(nomeDoJogo + "," + plataforma + "," + ano + "," + vendasGlobais + "\n");				
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erro de entrada e saida!");
			e.printStackTrace();
		}
		
		try {
			arquivoDeSaida.close();
		} 
		catch (IOException e) {
			System.out.println("Erro de entrada e saida!");
			e.printStackTrace();
		} 
		catch (NullPointerException e) {
			System.out.println("Erro: Arquivo não encontrado!");
			e.printStackTrace();
		}
	}


//	public int buscaBinaria(String busca, int obterTotalDeJogos, Jogo jogo) {
//		int inicio = 0;
//		int fim = obterTotalDeJogos - 1;
//		int meio;
//		String a[] = jogo.toString();
//		while (inicio <= fim) {
//			meio = (inicio + fim / 2);
//			if (busca.compareTo(jogo[meio])) {
//				return meio;
//				
//			} else if (busca < (jogo[meio])) {
//				fim = meio - 1;
//				
//			} else {
//				inicio = meio + 1;
//			}
//			return -1;
//		}
//	}
}
