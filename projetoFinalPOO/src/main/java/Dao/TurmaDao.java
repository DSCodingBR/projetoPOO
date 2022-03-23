package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Modelo.Curso;
import Modelo.Filial;
import Modelo.Instrutor;
import Modelo.Pessoa;
import Modelo.Turma;


public class TurmaDao extends Dao {
	public List<Turma> listar(){
		List<Turma> turmas = new ArrayList<>();
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT t.id, t.horarioInicio, t.horarioFim, t.dataInicial, t.dataFim,"
					+ "t.curso_id, c.nomeCurso, t.instrutor_id, p.nome as nomeInstrutor, f.nomeFilial "
					+ "FROM turma AS t "
					+ "INNER JOIN curso AS c ON(t.curso_id=c.id) "
					+ "INNER JOIN instrutor AS i ON(t.instrutor_id=i.id) "
					+ "INNER JOIN pessoa AS p ON(p.id=i.id) "
					+ "INNER JOIN filial AS f on(t.filial_id=f.id) ORDER BY t.id ");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			
			Turma turma= new Turma();
			
			Curso curso = new Curso();
            Instrutor instrutor = new Instrutor();
            Filial filial = new Filial();
            
            
            turma.setId(rs.getInt("id"));
            turma.setHorarioInicio(rs.getString("horarioInicio"));
            turma.setHorarioFim(rs.getString("horarioFim"));
            turma.setDataInicial(rs.getString("dataInicial"));
            turma.setDataFinal(rs.getString("dataFim"));
            curso.setId(rs.getInt("curso_id"));
            curso.setNomeCurso(rs.getString("nomeCurso"));
            instrutor.setId(rs.getInt("instrutor_id"));
            instrutor.setNome(rs.getString("nomeInstrutor"));
            filial.setNomeFilial(rs.getString("nomeFilial"));

            turma.setCurso(curso);
            turma.setInstrutor(instrutor);
            turma.setFilial(filial);
            
            
            turmas.add(turma);
		}
		}catch (Exception e) {
			e.printStackTrace();//Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
		return turmas;
	}
	
	public Integer salvar(Turma turma) {
		Integer last_inserted_id = null;
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement("INSERT INTO turma (horarioInicio,horarioFim,dataInicial,dataFim,curso_id,instrutor_id,filial_id) VALUES (?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			//stmt.setInt(1, turma.getId());
			stmt.setString(1, turma.getHorarioInicio());
			stmt.setString(2, turma.getHorarioFim());
			stmt.setString(3, turma.getDataInicial());
			stmt.setString(4, turma.getHorarioFim());
			stmt.setInt(5, turma.getCurso().getId());
			stmt.setInt(6, turma.getInstrutor().getId());
			stmt.setInt(7, turma.getFilial().getId());
			
			
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
			
			PreparedStatement stmt = this.conexao.prepareStatement("delete from turma where id=?");
			stmt.setInt(1, id);
			
            stmt.executeUpdate();
            
			
		}catch (Exception e) {
			e.printStackTrace();//Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public  void atualizar(Turma t) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("UPDATE turma SET horarioInicio=?,horarioFim=?,dataInicial=?,dataFim=? WHERE id=?");//,curso_id=?,instrutor_id=?,filial_id=?
			stmt.setString(1, t.getHorarioInicio());
			stmt.setString(2, t.getHorarioFim());
			stmt.setString(3, t.getDataInicial());
			stmt.setString(4, t.getHorarioFim());
			stmt.setInt(5, t.getId());
            
            stmt.executeUpdate();

            
		}catch (Exception e) {
			e.printStackTrace();//Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
