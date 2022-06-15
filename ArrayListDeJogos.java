import java.util.ArrayList;

public class ArrayListDeJogos implements ColecaoDeJogos {
	ArrayList <Jogo> listaDeJogos;
	
	public ArrayListDeJogos () {
		this.listaDeJogos = new ArrayList<Jogo>();
	}
	
	@Override
	public void adicionarJogo(Jogo jogo) {
		this.listaDeJogos.add(jogo);		
	}

	@Override
	public boolean excluirJogo() {
		if(this.listaDeJogos.size() > 0) {
			int ultimoJogo = this.listaDeJogos.size() - 1;
			this.listaDeJogos.remove(ultimoJogo);
			return true;
		}
		return false;
	}

	@Override
	public Jogo obterJogo(int indiceDoJogo) {
		return this.listaDeJogos.get(indiceDoJogo);
	}

	@Override
	public int obterTotalDeJogos() {
		return this.listaDeJogos.size();
	}


	@Override
	public int buscaSequencialString(String buscarNome, String[] vetorNome, int totalJogos) {
		// TODO Auto-generated method stub
		return -1;
	}


	@Override
	public void ordernarPorAno(MetodoDaBolha metodoDaBolha) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int buscaBinariaRecursiva(String busca, int inicio, int fim, int meio) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void ordernarPorNome(MetodoDaBolha metodoDaBolha) {
		// TODO Auto-generated method stub
		
	}

}
