package br.com.testenetshoes.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=50,nullable=false)
	private String rua;
	
	@Column(length=30)
	private String complemento;
	
	@Column(length=8,nullable=false)
	private String cep;
	
	@Column(length=50)
	private String bairro;
	
	@Column(length=30,nullable=false)
	private String cidade;
	
	@Column(length=2,nullable=false)
	private String estado;
	
	@Column(length=4,nullable=false)
	private String numero;

	/**
	 * Recupera o(a) id.
	 * @return o(a) id.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Configura o(a) id.
	 * @param id o(a) id que será configurado(a).
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Recupera o(a) rua.
	 * @return o(a) rua.
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * Configura o(a) rua.
	 * @param rua o(a) rua que será configurado(a).
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * Recupera o(a) complemento.
	 * @return o(a) complemento.
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * Configura o(a) complemento.
	 * @param complemento o(a) complemento que será configurado(a).
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * Recupera o(a) cep.
	 * @return o(a) cep.
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Configura o(a) cep.
	 * @param cep o(a) cep que será configurado(a).
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Recupera o(a) bairro.
	 * @return o(a) bairro.
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Configura o(a) bairro.
	 * @param bairro o(a) bairro que será configurado(a).
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * Recupera o(a) cidade.
	 * @return o(a) cidade.
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Configura o(a) cidade.
	 * @param cidade o(a) cidade que será configurado(a).
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Recupera o(a) estado.
	 * @return o(a) estado.
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Configura o(a) estado.
	 * @param estado o(a) estado que será configurado(a).
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Recupera o(a) numero.
	 * @return o(a) numero.
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Configura o(a) numero.
	 * @param numero o(a) numero que será configurado(a).
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
