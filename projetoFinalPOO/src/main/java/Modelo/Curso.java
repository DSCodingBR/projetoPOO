package Modelo;

/**
 *
 * @author lined
 */
public class Curso {
    private Integer id;
	private String nomeCurso;
	private Integer ch;
	private Area area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Integer getCh() {
        return ch;
    }

    public void setCh(Integer ch) {
        this.ch = ch;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
        
        
}
