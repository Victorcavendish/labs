package negocios;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.*;
import beans.Servico;
import persistencia.ServicoDAO;

@ManagedBean
@SessionScoped
public class ServicoCtrl implements Serializable {
	private static final long serialVersionUID = 1L;
	private Servico servico;
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public List<Servico> getListagem(){
		return ServicoDAO.listagem("");
	}
	
	public String actionGravar() {
		if (servico.getId() == 0) {
			ServicoDAO.inserir(servico);
			return actionInserir();
		}
		else {
			ServicoDAO.alterar(servico);
			return "lista_servico";
		}
	}
	
	public String actionInserir() {
		servico = new Servico();
		return "form_servico";
	}
	
	public String actionExcluir(Servico s) {
		ServicoDAO.excluir(s);
		return "lista_servico";
	}
	
	public String actionAlterar(Servico s) {
		servico = s;
		return "form_servico";
	}
	
	
}
