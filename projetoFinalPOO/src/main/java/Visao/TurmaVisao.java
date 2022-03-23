package Visao;

import java.util.List;
import java.util.Scanner;
import Controle.TurmaControle;
import Modelo.Turma;

public class TurmaVisao {
	
	private Scanner jIn;
	private TurmaControle tControle;
	
	public TurmaVisao() {
		this.jIn = new Scanner(System.in);
        this.tControle = new TurmaControle();
	}
	
	public Turma salvar() {
		System.out.println("Digite a Hora Inicial da Turma:");
        String horarioInicio = this.jIn.nextLine();
        System.out.println("Digite a Hora Final da Turma: ");
        String horarioFim = this.jIn.nextLine();
        System.out.println("Digite a Data Inicial da Turma: ");
        String dataInicial = this.jIn.nextLine();
        System.out.println("Digite a Data Final da Turma: ");
        String dataFim = this.jIn.nextLine();
        System.out.println("Digite o Id do Curso:");
        Integer curso_id= Integer.parseInt(this.jIn.nextLine());
        System.out.println("Digite o Id do Instrutor:");
        Integer instrutor_id= Integer.parseInt(this.jIn.nextLine());
        System.out.println("Digite o Id da Filial:");
        Integer filial_id= Integer.parseInt(this.jIn.nextLine());
        return this.tControle.salvar(horarioInicio,horarioFim,dataInicial,dataFim,curso_id,instrutor_id,filial_id);
	}
	
	public void atualizar() {
		Turma t = new Turma();
		
		System.out.println("Digite o codigo do Turma:");
        t.setId(Integer.parseInt(jIn.nextLine()));
        System.out.println("Nova Hora de Inicio:");
        t.setHorarioInicio(jIn.nextLine());
        System.out.println("Nova Hora de Fim:");
        t.setHorarioFim(jIn.nextLine());
        System.out.println("Nova Data de Inicio:");
        t.setDataInicial(jIn.nextLine());
        System.out.println("Nova Data de Fim:");
        t.setDataFinal(jIn.nextLine());
    
        tControle.atualizar(t);
	}
	
	public void listar(){
		List<Turma> turmas = tControle.listar();
		System.out.println("-------- LISTA DE TURMAS -------- ");
        for (Turma turma : turmas) {
            System.out.println("\nId: " + turma.getId() + "\nHora INICIO: " +turma.getHorarioInicio()+ 
                    "\nHora FIM:  " + turma.getHorarioFim()+ "\nData INICIO: " +turma.getDataInicial()
                    + "\nData FIM:  " +turma.getDataFinal()+ "\nId do Curso: " +turma.getCurso().getId()
                    +"\nNome do Curso: "+turma.getCurso().getNomeCurso()
                    +"\nId Do INSTRUTOR:  " + turma.getInstrutor().getId()+"\nNome Filial: "+turma.getFilial().getNomeFilial());
        }
	}
	
	public void excluir(){
        System.out.println("Digite o codigo da Turma:");
        tControle.excluir(Integer.parseInt(jIn.nextLine()));
    }
	
}
