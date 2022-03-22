package Visao;

import java.util.List;
import java.util.Scanner;
import Controle.AlunoControle;
import Modelo.Aluno;

public class AlunoVisao {
	private Scanner jIn;
	private AlunoControle aControle;
	
	public AlunoVisao() {
		this.jIn = new Scanner(System.in);
        this.aControle = new AlunoControle();
	}
	
	public Aluno salvar() {
		System.out.println("Digite O Nome do aluno:");
        String nome = this.jIn.nextLine();
        System.out.println("Digite o Nome da Mae: ");
        String mae = this.jIn.nextLine();
        System.out.println("Digite O Sexo: ");
        String sexo = this.jIn.nextLine();
        System.out.println("Digite A Data de Nascimento: ");
        String nascimento = this.jIn.nextLine();
        System.out.println("Digite O Email: ");
        String email = this.jIn.nextLine();
        System.out.println("Digite A Rua: ");
        String rua = this.jIn.nextLine();
        System.out.println("Digite O Bairro: ");
        String bairro = this.jIn.nextLine();
        System.out.println("Digite O Numero da Casa: ");
        Integer numerodacasa = Integer.parseInt(this.jIn.nextLine());
        System.out.println("Digite O cep: ");
        String cep = this.jIn.nextLine();
        System.out.println("Digite o Telefone do Aluno:");
        String telefone = this.jIn.nextLine();
        System.out.println("Digite o codigo da cidade do aluno:");
        Integer cidade_id= Integer.parseInt(this.jIn.nextLine());
        System.out.println("Digite o Estado Civil do Aluno:");
        String estadocivil = this.jIn.nextLine();
        System.out.println("Digite a Escolaridade do Aluno:");
        String escolaridade = this.jIn.nextLine();
        //System.out.println("Digite a Escolaridade do Aluno:");
        //String escolaridade = this.jIn.nextLine();
		return this.aControle.salvar(nome,mae,sexo,nascimento,email,rua,bairro,numerodacasa,cep,telefone,cidade_id,estadocivil,escolaridade);
	}
	public void atualizar() {
		Aluno a = new Aluno();
		System.out.println("Digite o codigo do aluno:");
        a.setId(Integer.parseInt(jIn.nextLine()));
        System.out.println("Digite o novo nome do aluno:");
        a.setNome(jIn.nextLine());
        aControle.atualizar(a);
	}
	public void listar(){
		List<Aluno> alunos = aControle.listar();
        System.out.println("-------- LISTA DE ALUNOS -------- ");
        for (Aluno aluno : alunos) {
            System.out.println("\nID: " + aluno.getId() + "\nNome: " + aluno.getNome() + 
                    "\nEscolaridade:  " + aluno.getEscolaridade()+ "\nTelefone: " +aluno.getTelefone()
                    + "\nEstado Civil:  " +aluno.getEstadocivil()+ "\nCidade: " + aluno.getCidade().getNome()+ 
                    "\nUF:  " + aluno.getCidade().getUf().getNome());
        }
	}

	public void excluir(){
        System.out.println("Digite o codigo do aluno:");
        aControle.excluir(Integer.parseInt(jIn.nextLine()));
    }
}
