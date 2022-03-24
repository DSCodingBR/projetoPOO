package Visao;

import java.util.List;
import java.util.Scanner;
import Controle.MatriculaControle;
import Modelo.Curso;
import Modelo.Instrutor;
import Modelo.Matricula;




public class MatriculaVisao {
	
	private Scanner jIn;
	private MatriculaControle mControle;
	
	public MatriculaVisao() {
		this.jIn = new Scanner(System.in);
        this.mControle = new MatriculaControle();
	}
	
	public Matricula salvar() {
		System.out.println("Digite a Data da Matricula: ");
		String dataMatricula = this.jIn.nextLine();
		System.out.println("Digite o Status da Matricula: ");
		String estatus = this.jIn.nextLine();
		System.out.println("Digite o Id do Aluno: ");
		Integer aluno_id = Integer.parseInt(this.jIn.nextLine());
		System.out.println("Digite o Id da Turma: ");
		Integer turma_id= Integer.parseInt(this.jIn.nextLine());
		return this.mControle.salvar(dataMatricula,estatus,aluno_id, turma_id);
	}
	
	public void atualizar() {
		
		Matricula m = new Matricula();
		
		System.out.println("Digite A Matricula ao Qual Deseja fazer a Alteracao: ");
		m.setId(Integer.parseInt(jIn.nextLine()));
		System.out.println("Ok, Agora Digite o Novo ID da Turma: ");
		m.getTurma().setId(Integer.parseInt(jIn.nextLine()));
		System.out.println("Digite a Nova Data de Matricula: ");
		m.setDataMatricula(jIn.nextLine());
		System.out.println("Digite o Novo Estatus do Aluno: ");
		m.setEstatus(jIn.nextLine());
		
		mControle.atualizar(m);
	}
	
	public void listar(){
		List<Matricula> matriculas = mControle.listar();
		Instrutor instrutor = new Instrutor();
		Curso curso = new Curso();
		System.out.println("-------- LISTA DE TURMAS -------- ");
        for (Matricula matricula : matriculas) {
            System.out.println("\nId Matricula: " + matricula.getId() +"\nData da Matricula: "+matricula.getDataMatricula()
            		+"\nStatus da Matricula: "+matricula.getEstatus()+ "\nId do Aluno: " +matricula.getAluno().getId()+ 
                    "\nNome do Aluno:  " +matricula.getAluno().getNome() + "\nId da Turma: " +matricula.getTurma().getId()
                    + "\nNome do Instrutor:  " +matricula.getInstrutor().getNome()+ "\nNome do Curso: " +matricula.getCurso().getNomeCurso());
        }
	}
	
	public void excluir(){
        System.out.println("Digite ID da Matricula: ");
        mControle.excluir(Integer.parseInt(jIn.nextLine()));
    }
	
}
