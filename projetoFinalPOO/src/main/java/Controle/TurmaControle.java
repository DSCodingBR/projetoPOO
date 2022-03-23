package Controle;

import java.util.List;
import Dao.DaoFactory;
import Modelo.Turma;

public class TurmaControle {
	
	public Turma salvar(String horarioInicio, String horarioFim, String dataInicial, String dataFim, Integer curso_id, Integer instrutor_id, Integer filial_id) {
		Turma turma = new Turma();
		turma.setHorarioInicio(horarioInicio);
		turma.setHorarioFim(horarioFim);
		turma.setDataInicial(dataInicial);
		turma.setDataFinal(dataFim);
		turma.getCurso().setId(curso_id);
		turma.getInstrutor().setId(filial_id);
		turma.getFilial().setId(filial_id);
		
		turma.setId(DaoFactory.getTurmaDao().salvar(turma));
		
		return turma;
	}
	
	public void atualizar(Turma turma){
        DaoFactory.getTurmaDao().atualizar(turma);          
    }
	
	public List<Turma> listar(){
        return DaoFactory.getTurmaDao().listar();
	}
	
	public void excluir(Integer id){
        DaoFactory.getTurmaDao().excluir(id);
    }
}
