package Controle;

import java.util.List;
import Dao.DaoFactory;
import Modelo.Aluno;

public class AlunoControle {
	public Aluno salvar(String nome, String mae,String sexo,String nascimento, String email,String rua,String bairro,
			Integer numerodacasa,String cep,String telefone,Integer cidade_id, String estadocivil, String escolaridade) {
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMae(mae);
		aluno.setSexo(sexo);
		aluno.setNascimento(nascimento);
		aluno.setEmail(email);
		aluno.setRua(rua);
		aluno.setBairro(bairro);
		aluno.setNumerodacasa(numerodacasa);
		aluno.setCep(cep);
		aluno.setTelefone(telefone);
		aluno.setEstadocivil(estadocivil);
		aluno.getCidade().setId(cidade_id);
		aluno.setEscolaridade(escolaridade);
		
		aluno.setId(DaoFactory.getAlunoDao().salvar(aluno));
		
		
		return aluno;
	}
    public void atualizar(Aluno aluno){
        DaoFactory.getAlunoDao().atualizar(aluno);          
    }
    
    public List<Aluno> listar(){
         return DaoFactory.getAlunoDao().listar();
    }
    
    public void excluir(Integer id){
        DaoFactory.getAlunoDao().excluir(id);
    }
}
