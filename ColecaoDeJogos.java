

public interface ColecaoDeJogos {
		
		public void adicionarJogo(Jogo jogo);
		
		public boolean excluirJogo();
		
		public Jogo obterJogo(int indiceDoJogo);
		
		public int obterTotalDeJogos();
		
		public int buscaSequencialString(String buscarNome, String[] vetorNome, int totalJogos);

		public void ordernarPorAno(MetodoDaBolha metodoDaBolha);
		
		public void ordernarPorNome(MetodoDaBolha metodoDaBolha);

		public int buscaBinariaRecursiva(String busca, int inicio, int fim, int meio);

}
