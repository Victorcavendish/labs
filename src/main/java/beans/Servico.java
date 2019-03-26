package beans;

import javax.persistence.*;

@Entity
@Table
public class Servico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ser_id")
	private int id;
	
	@Column(name = "ser_nome", length = 60, nullable = true)
	private String nome;
	
	@Column(name = "ser_descricao", nullable = true)
	private String descricao;
	
	@Column(name = "ser_und", nullable = true)
	private String unidade;
	
	@Column(name = "ser_valor", nullable = true)
	private float valor;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getUnd() {
		return unidade;
	}

	public void setUnd(String unidade) {
		this.unidade = unidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
