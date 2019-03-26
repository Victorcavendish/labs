package persistencia;

import java.io.Serializable;
import java.util.List;
import org.hibernate.*;

import beans.Fone;
import beans.Pessoa;

public class FoneDAO implements Serializable{
private static final long serialVersionUID = 1L;
	
	public static void inserir(Fone fone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(fone);
		t.commit();
		sessao.close();
	}
	
	public static void alterar(Fone fone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(fone);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Fone fone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(fone);
		t.commit();
		sessao.close();
	}
	
	public static List<Fone> listagem(String filtro){		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		List<Fone> lista = null;
		if (filtro.trim().length() == 0) {
			consulta = sessao.createQuery("from Pessoa order by pes_nome");
		}
		else {
			consulta = sessao.createQuery("from Pessoa where pes_nome like :parametro order by pes_nome");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		lista = consulta.list();
		sessao.close();
		return lista;
	}
}
