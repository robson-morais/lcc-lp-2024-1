package exercicios.agenda;

public class AgendaEnderecos {
	
	private int maxContatos;
	private int contContatos;
	private Contato [] contatos;
	
	public AgendaEnderecos(int maxContatos) {
		this.maxContatos = maxContatos;
		this.contContatos = 0;
		this.contatos = new Contato[maxContatos];
	}
	
	public boolean apagaContato(String nomeContato) {
		for (int k=0; k<contContatos; k++) {
			Contato c = this.contatos[k];
			if (c.getNome().equalsIgnoreCase(nomeContato)) {
				while (k<contContatos-1) {
					this.contatos[k]=this.contatos[k+1];
					k++;
				}
				contatos[k] = null;
				contContatos--;
				return true;
			}
		}
		return false;
	}
	
	public boolean cadastraContato(Contato c) {
		if (this.contContatos< maxContatos) {
			this.contatos[contContatos] = c;
			contContatos++;
			return true;
		} else {
			return false;
		}
	}
	public Endereco pesquisaEndereco(String nomeContato) {
		for (int k=0; k<contContatos; k++) {
			Contato c = this.contatos[k];
			if (c.getNome().equalsIgnoreCase(nomeContato)) {
				return c.getEndereco();
			}
		}
		return null;
	}
	public int pesquisarQuantidadeDeContatosDoBairro(String bairro) {
		int cont = 0;
		for (int k=0; k<contContatos; k++) {
			Contato c = this.contatos[k];
			if (c.getEndereco().getBairro().equalsIgnoreCase(bairro)) {
				cont++;
			}
		}
		return cont;
	}

}