package Modelo;

/**
 *
 * @author lined
 */
public class Turma {
    private Integer id;
    private String dataInicial; 
    private String dataFinal;
    private String horarioInicio;
    private String horarioFim;
    private Curso cursos;
    private Instrutor instrutores;
    private Filial filiais;
    
    Curso curso = new Curso();
    Filial filial = new Filial();
    Instrutor instrutor = new Instrutor();
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public String getHorarioFim() {
		return horarioFim;
	}
	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}
	public Curso getCursos() {
		return cursos;
	}
	public void setCursos(Curso cursos) {
		this.cursos = cursos;
	}
	public Instrutor getInstrutores() {
		return instrutores;
	}
	public void setInstrutores(Instrutor instrutores) {
		this.instrutores = instrutores;
	}
	public Filial getFiliais() {
		return filiais;
	}
	public void setFiliais(Filial filiais) {
		this.filiais = filiais;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Filial getFilial() {
		return filial;
	}
	public void setFilial(Filial filial) {
		this.filial = filial;
	}
	public Instrutor getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

    
}
