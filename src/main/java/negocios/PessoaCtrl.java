package negocios;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import beans.Fone;
import beans.Pessoa;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped

public class PessoaCtrl implements Serializable{
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa = new Pessoa();
	//private Pessoa usuarioLogado;
	private Fone fone = new Fone();
	private String filtro = "";
	

	public Fone getFone() {
		return fone;
	}

	public void setFone(Fone fone) {
		this.fone = fone;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa=pessoa;
	}
	public List<Pessoa> getListagem(){
		return PessoaDAO.listagem(filtro);
	}
	
	public void actionGravar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (pessoa.getId() == 0) {
			PessoaDAO.inserir(pessoa);
			context.addMessage(null, new FacesMessage("Sucesso", "Inserido com sucesso!"));
		}
		else {
			PessoaDAO.alterar(pessoa);
			context.addMessage(null, new FacesMessage("Sucesso", "Alterado com sucesso!"));
		}
	}
	
	public void actionInserir() {
		pessoa = new Pessoa();
	}
	
	public void actionExcluir() {
		PessoaDAO.excluir(pessoa);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sucesso", "Excluido com sucesso!"));
	}
	
	public String actionAlterar(Pessoa p) {
		pessoa = p;
		return "lista_pessoa";
	}
	
	public void actionInserirFone() {
		fone = new Fone();
		fone.setPessoa(pessoa);
		pessoa.getFones().add(fone);
	}
	
	public void actionExcluirFone() {
		pessoa.getFones().remove(fone);
	}
	/*
	public String getUsuarioLogado() {
		UserDetails user = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return user.toString();
	}*/
}
