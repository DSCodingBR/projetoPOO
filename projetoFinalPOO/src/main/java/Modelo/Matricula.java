package Modelo;

/**
 *
 * @author lined
 */
public class Matricula {
    private Integer id;
    private String estatus;
    private String dataMatricula;
    private Aluno alunos;
    private Turma turmas;
    
    Aluno aluno = new Aluno();
    Turma turma = new Turma();
    Instrutor instrutor = new Instrutor();
    Curso curso = new Curso();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

	public Aluno getAlunos() {
		return alunos;
	}

	public void setAlunos(Aluno alunos) {
		this.alunos = alunos;
	}

	public Turma getTurmas() {
		return turmas;
	}

	public void setTurmas(Turma turmas) {
		this.turmas = turmas;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
    
    
    
    
}
