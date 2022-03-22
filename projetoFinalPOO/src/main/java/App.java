import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Modelo.Aluno;
import Visao.AlunoVisao;
import Visao.Main;

public class App {

	public static void main(String[] args) {
		
		 AlunoVisao alunoVisao = new AlunoVisao();
		 List<Aluno> alunos = new ArrayList<>();
		 
		 Scanner jIn = new Scanner(System.in);
	     Integer opcao = null;
	     
	     do {
	    	 Main.menu();
	    	 System.out.println("Digite a Opcao");
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
	         	//alunoVisao.imprimeAluno(alunos);
	         	break;
	         	case 4:
	         	alunoVisao.excluir();
	         }
	     }while (opcao != 0);
	     
	}

}
