import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Modelo.Aluno;
import Modelo.Turma;
import Visao.AlunoVisao;
import Visao.Main;
import Visao.TurmaVisao;

public class App {

	public static void main(String[] args) {
		
		 AlunoVisao alunoVisao = new AlunoVisao();
		 List<Aluno> alunos = new ArrayList<>();
		 
		 TurmaVisao turmaVisao = new TurmaVisao();
		 List<Turma> turmas = new ArrayList<>();
		 
		 Scanner jIn = new Scanner(System.in);
	     Integer opcao = null;
	     
	     do {
	    	 Main.menu();
	    	 System.out.print("Digite a Opcao: ");
	         opcao = Integer.parseInt(jIn.nextLine());
	         switch (opcao) {
	         	case 1:
	            alunoVisao.salvar();
                break;
	         	case 2:
	         	alunoVisao.atualizar();
	         	break;
	         	case 3:
	         	alunoVisao.listar();
	         	break;
	         	case 4:
	         	alunoVisao.excluir();
	         	break;
	         	case 5:
	         	turmaVisao.salvar();
	         	break;
	         	case 6:
	         	turmaVisao.atualizar();
	         	break;
	         	case 7:
	         	turmaVisao.listar();
	         	break;
	         	case 8:
	         	turmaVisao.excluir();
	         	break;
	         	
	         }
	     }while (opcao != 0);
	     
	}

}
