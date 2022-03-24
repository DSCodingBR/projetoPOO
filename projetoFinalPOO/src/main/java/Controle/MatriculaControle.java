package Controle;

import java.util.List;
import Dao.DaoFactory;
import Modelo.Matricula;


public class MatriculaControle {
	
	public Matricula salvar(String dataMatricula, String estatus, Integer aluno_id, Integer turma_id ) {
		Matricula matricula = new Matricula();
		
		matricula.setDataMatricula(dataMatricula);
		matricula.setEstatus(estatus);
		matricula.getAluno().setId(aluno_id);
		matricula.getTurma().setId(turma_id);
		
		matricula.setId(DaoFactory.getMatriculaDao().salvar(matricula));
		
		
		return matricula;
		
	}
	
	public void atualizar(Matricula matricula){
        DaoFactory.getMatriculaDao().atualizar(matricula);          
    }
	
	public List<Matricula> listar(){
        return DaoFactory.getMatriculaDao().listar();
	}
	
	public void excluir(Integer id){
        DaoFactory.getMatriculaDao().excluir(id);
    }
	
}
