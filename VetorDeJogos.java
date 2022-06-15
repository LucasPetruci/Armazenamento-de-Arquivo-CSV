
public class VetorDeJogos implements ColecaoDeJogos {
	Jogo listaDeJogos[];
	int totalDeJogos;

	public VetorDeJogos() {
		this.listaDeJogos = new Jogo[17000];
		this.totalDeJogos = 0;
	}

	public VetorDeJogos(int tamanhoMaximoDaLista) {
		this.listaDeJogos = new Jogo[tamanhoMaximoDaLista];
		this.totalDeJogos = 0;
	}

	@Override
	public void adicionarJogo(Jogo jogo) {
		this.listaDeJogos[totalDeJogos] = jogo;
		this.totalDeJogos++;
	}

	@Override
	public boolean excluirJogo() {
		if (this.totalDeJogos > 0) {
			this.totalDeJogos--;
			return true;
		}
		return false;
	}

	@Override
	public Jogo obterJogo(int indiceDoJogo) {
		return this.listaDeJogos[indiceDoJogo];
	}

	@Override
	public int obterTotalDeJogos() {
		return this.totalDeJogos;
	}

	@Override
	public void ordernarPorAno(MetodoDaBolha metodoDaBolha) {
		metodoDaBolha.ordenarAno(this.listaDeJogos, this.totalDeJogos);
		VideogameArquivo.listaOrdenadaAno(this.listaDeJogos, totalDeJogos);
	}

	@Override
	public void ordernarPorNome(MetodoDaBolha metodoDaBolha) {
		metodoDaBolha.ordenarString(this.listaDeJogos, this.totalDeJogos);
		VideogameArquivo.listaOrdenadaNome(this.listaDeJogos, this.totalDeJogos);
	}

	@Override
	public int buscaSequencialString(String buscarNome, String[] vetorNome, int totalJogos) {
		for (int i = 0; i < totalJogos; i++) {
			if (vetorNome[i].equals(buscarNome)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int buscaBinariaRecursiva(String busca, int inicio, int fim, int meio) {

		while (inicio <= fim) {
			if (fim < inicio) {
				return -1;
			} else if (listaDeJogos[meio].nome.compareTo(busca) == 0) {
				return meio;
			} else if (listaDeJogos[meio].nome.compareTo(busca) < 0) {
				return buscaBinariaRecursiva(busca, inicio, fim, meio + 1);
			} else if (listaDeJogos[meio].nome.compareTo(busca) > 0) {
				return buscaBinariaRecursiva(busca, inicio, fim, meio - 1);
			}
		}
		return meio;
	}
}
