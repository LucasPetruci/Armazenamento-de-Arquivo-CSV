

public class Jogo {
	String nome, plataforma;
	int ano;
	double vendasGlobais;
	
	public Jogo(String nome, String plataforma, int ano, double vendasGlobais) {
		this.nome = nome;
		this.plataforma = plataforma;
		this.ano = ano;
		this.vendasGlobais = vendasGlobais;
	}
	
	public String obterNome() {
		return nome;
	}

	public void definirNome(String nome) {
		this.nome = nome;
	}

	public String obterPlataforma() {
		return plataforma;
	}

	public void definirPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int obterAno() {
		return ano;
	}

	public void definirAno(int ano) {
		this.ano = ano;
	}

	public double obterVendasGlobais() {
		return vendasGlobais;
	}

	public void definirVendasGlobais(double vendasGlobais) {
		this.vendasGlobais = vendasGlobais;
	}
		
}
