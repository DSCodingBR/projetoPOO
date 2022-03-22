package Modelo;

/**
 *
 * @author lined
 */
public class Pessoa {
    
    private Integer id;
    private String nome;
    private String  mae;
    private String sexo;
    private String nascimento;
    private String email;
    private String rua;
    private String bairro;
    private Integer numerodacasa;
    private String cep;
    private String telefone;
    private String estadocivil;
    private Cidade cidades;
    Cidade cidade = new Cidade();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

	public Cidade getCidades() {
		return cidades;
	}

	public void setCidades(Cidade cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumerodacasa() {
		return numerodacasa;
	}

	public void setNumerodacasa(Integer numerodacasa) {
		this.numerodacasa = numerodacasa;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	 
	

    
}
