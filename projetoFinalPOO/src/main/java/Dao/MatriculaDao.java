package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Modelo.Aluno;
import Modelo.Curso;
import Modelo.Instrutor;
import Modelo.Matricula;
import Modelo.Turma;




public class MatriculaDao extends Dao {
	
	public List<Matricula> listar(){
		List<Matricula> matriculas = new ArrayList<>();
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT m.id, m.dataMatricula, m.estatus, m.aluno_id, pa.nome as nomeAluno, m.turma_id, pi.nome as nomeInstrutor, c.nomeCurso "
					+ "FROM matricula AS m "
					+ "INNER JOIN turma AS t ON (t.id=m.turma_id) "
					+ "INNER JOIN curso AS c ON(t.curso_id=c.id) "
					+ "INNER JOIN aluno AS a ON (a.id=m.aluno_id) "
					+ "INNER JOIN pessoa AS pa ON(a.pessoa_id=pa.id) "
					+ "INNER JOIN instrutor AS i ON(t.instrutor_id=i.id) "
					+ "INNER JOIN pessoa AS pi ON(i.pessoa_id=pi.id) "
					+ "ORDER BY m.id");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Matricula matricula = new Matricula();
				
				Turma turma = new Turma();
				Aluno aluno = new Aluno();
				Instrutor instrutor = new Instrutor();
				Curso curso = new Curso();
				
				matricula.setId(rs.getInt("id"));
				matricula.setDataMatricula(rs.getString("dataMatricula"));
				matricula.setEstatus(rs.getString("estatus"));
				aluno.setId(rs.getInt("aluno_id"));
				aluno.setNome(rs.getString("nomeAluno"));
				turma.setId(rs.getInt("turma_id"));
				instrutor.setNome(rs.getString("nomeInstrutor"));
				curso.setNomeCurso(rs.getString("nomeCurso"));
				
				
				matricula.setAluno(aluno);
				matricula.setTurma(turma);
				matricula.setInstrutor(instrutor);
				matricula.setCurso(curso);
				matriculas.add(matricula);
				
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return matriculas;
	}
	
	public Integer salvar(Matricula matricula) {
		Integer last_inserted_id = null;
		
		try {
			
			
			PreparedStatement stmt = this.conexao.prepareStatement("INSERT INTO matricula (dataMatricula,estatus,aluno_id,turma_id) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, matricula.getDataMatricula());
			stmt.setString(2, matricula.getEstatus());
			stmt.setInt(3, matricula.getAluno().getId());
			stmt.setInt(4, matricula.getTurma().getId());
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
		          last_inserted_id = rs.getInt(1);
		    }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return last_inserted_id;
		
	}
	
	public void excluir(int id) {
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement("delete from matricula where id=?");
			stmt.setInt(1, id);
			
            stmt.executeUpdate();
            
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void atualizar(Matricula m) {
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement("UPDATE matricula SET turma_id=?, dataMatricula=?, estatus=?  WHERE id=?");
			

			stmt.setInt(1, m.getTurma().getId());
			stmt.setString(2, m.getDataMatricula());
			stmt.setString(3, m.getEstatus());
			stmt.setInt(4, m.getId());
			
			stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
