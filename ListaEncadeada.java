
public class ListaEncadeada implements ColecaoDeJogos {

	No inicio = null;
	int totalDeJogos = 0;
	
	@Override
	public void adicionarJogo(Jogo jogo) {
		No noNovo = new No(jogo);
		No noAtual = this.inicio;
		this.totalDeJogos++;
		if (this.inicio != null) {
			while (noAtual.proximo != null) {
				noAtual = noAtual.proximo;
			}
			noAtual.proximo = noNovo;
		} else {
			this.inicio = noNovo;
		}
	}

	@Override
	public boolean excluirJogo() {
		No jogoAtual = this.inicio;
		No jogoAnterior = null;

		if (this.inicio != null) {
			while (jogoAtual.proximo != null) {
				jogoAnterior = jogoAtual;
				jogoAtual = jogoAtual.proximo;
			}
			if (jogoAnterior != null) {
				jogoAnterior.proximo = null;
			} else {
				this.inicio = this.inicio.proximo;
			}
			this.totalDeJogos--;
			return true;
		}
		return false;
	}

	@Override
	public Jogo obterJogo(int indiceDoJogo) {
		return null;
	}

	@Override
	public int obterTotalDeJogos() {
		return this.totalDeJogos;
	}

	@Override
	public int buscaSequencialString(String buscarNome, String[] vetorNome, int totalJogos) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ordernarPorAno(MetodoDaBolha metodoDaBolha) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ordernarPorNome(MetodoDaBolha metodoDaBolha) {
		// TODO Auto-generated method stub

	}

	@Override
	public int buscaBinariaRecursiva(String busca, int inicio, int fim, int meio) {
		// TODO Auto-generated method stub
		return 0;
	}
	public Iterador obterIterador() {
		Iterador iterador = new Iterador(this.inicio);
		return iterador;
	}

}
