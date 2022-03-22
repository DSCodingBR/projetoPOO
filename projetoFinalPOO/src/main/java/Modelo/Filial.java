package Modelo;

/**
 *
 * @author lined
 */
public class Filial {
    private Integer id; 
    private String nomeFilial;
    private String rua;
    private String bairro;
    private Integer numerodolocal;
    private Cidade cidade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
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

    public Integer getNumerodolocal() {
        return numerodolocal;
    }

    public void setNumerodolocal(Integer numerodolocal) {
        this.numerodolocal = numerodolocal;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    
}
