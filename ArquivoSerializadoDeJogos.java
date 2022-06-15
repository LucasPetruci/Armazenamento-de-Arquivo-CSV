import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ArquivoSerializadoDeJogos implements ArquivoDeJogos {
	ObjectInputStream arquivoLeitura = null;
	int dado;
	Jogo jogo;

	@Override
	public void lerDoArquivoParaMemoria(ColecaoDeJogos listaDeJogos) {
		try {
			arquivoLeitura = new ObjectInputStream(new FileInputStream("vgsales.txt"));
			dado = arquivoLeitura.read();

			while (dado != -1) {
				jogo = (Jogo) arquivoLeitura.readObject();

				if (jogo != null) {
					listaDeJogos.adicionarJogo(jogo);
				}

			}
			arquivoLeitura.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void escreverDaMemoriaNoArquivo(ColecaoDeJogos listaDeJogos) {
		ObjectOutputStream arquivoEscrita = null;

		try {
			arquivoEscrita = new ObjectOutputStream(new FileOutputStream("vgsales.txt"));
			for (int indiceJogo = 0; indiceJogo < 1600; indiceJogo++) {
				arquivoEscrita.writeObject(jogo);
			}
			arquivoEscrita.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
