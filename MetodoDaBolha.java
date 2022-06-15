
public class MetodoDaBolha implements MetodoDeOrdenacao {

	@Override
	public Jogo[] ordenarAno(Jogo[] listaDeJogos, int totalDeJogos) {
		boolean existiuTroca;
		do {
			existiuTroca = false;
			for (int indice = 0; indice < totalDeJogos-1; indice++) {
				if (listaDeJogos[indice].obterAno() > listaDeJogos[indice + 1].obterAno()) {
					trocaValores(listaDeJogos, indice, indice+1);
					existiuTroca = true;
				}
			}
		} while (existiuTroca);
		for(int i = 0; i< totalDeJogos-1;i++) {
			System.out.println(listaDeJogos[i].obterAno());
		}
		return listaDeJogos;
	}
	
	private void trocaValores(Jogo[] listaDeJogos, int primeiroValor, int segundoValor) {
		Jogo auxiliar;

		auxiliar = listaDeJogos[primeiroValor];
		listaDeJogos[primeiroValor] = listaDeJogos[segundoValor];
		listaDeJogos[segundoValor] = auxiliar;
	}

	@Override
	public Jogo[] ordenarString(Jogo[] listaDeJogos, int totalDeJogos) {
		boolean existiuTroca;
		do {
			existiuTroca = false;
			for (int indice = 0; indice < totalDeJogos - 1; indice++) {
				if (listaDeJogos[indice].nome.compareTo(listaDeJogos[indice + 1].nome) > 0) {
					trocaValores(listaDeJogos, indice, indice + 1);
					existiuTroca = true;
				}
			}
		} while (existiuTroca);
		return listaDeJogos;
	}

}
