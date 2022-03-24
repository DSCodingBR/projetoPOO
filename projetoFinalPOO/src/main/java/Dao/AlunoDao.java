package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Aluno;
import Modelo.Cidade;
import Modelo.Uf;

public class AlunoDao extends Dao {
	public List<Aluno> listar(){
		List<Aluno> alunos = new ArrayList<>();
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("SELECT p.id, p.nome,a.escolaridade,p.telefone, p.estadocivil,"
					+ "p.cidade_id, c.nome as nomeCidade, c.uf_id, u.nome as nomeUf "
					+ "FROM aluno AS a INNER JOIN pessoa AS p ON(a.pessoa_id=p.id) "
					+ "INNER JOIN cidade AS c ON(p.cidade_id=c.id)"
					+ "INNER JOIN uf AS u on(u.id=c.uf_id) ORDER BY p.nome");
		ResultSet rs = stmt.executeQuery();	
		while (rs.next()) {
			Aluno aluno = new Aluno();
            Cidade cidade = new Cidade();
            Uf uf = new Uf();
            
            
            aluno.setId(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setEscolaridade(rs.getString("escolaridade"));
            aluno.setTelefone(rs.getString("telefone"));
            aluno.setEstadocivil(rs.getString("estadocivil"));
            cidade.setNome(rs.getString("nomeCidade"));
            cidade.setId(rs.getInt("cidade_id"));
            uf.setNome(rs.getString("nomeUf"));
            uf.setId(rs.getInt("uf_id"));
            
            
            cidade.setUf(uf);
            aluno.setCidade(cidade);
            
            alunos.add(aluno);
		}
		}catch (Exception e) {
			e.printStackTrace();//Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
		return alunos;
	}
	
	public Integer salvar(Aluno aluno) {
		Integer last_inserted_id = null;
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement("insert into pessoa(nome,mae,sexo,nascimento,email,rua,bairro,numerodacasa,cep,telefone,cidade_id,estadocivil) values(?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMae());
            stmt.setString(3, aluno.getSexo());
            stmt.setString(4, aluno.getNascimento());
            stmt.setString(5, aluno.getEmail());
            stmt.setString(6, aluno.getRua());
            stmt.setString(7, aluno.getBairro());
            stmt.setInt(8, aluno.getNumerodacasa());
            stmt.setString(9, aluno.getCep());
			stmt.setString(10, aluno.getTelefone());
			stmt.setInt(11, aluno.getCidade().getId());
			stmt.setString(12, aluno.getEstadocivil());
			
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			if (rs.next()) {
	          last_inserted_id = rs.getInt(1);
	        }
			
			stmt = this.conexao.prepareStatement("insert into aluno(escolaridade, pessoa_id) values(?,?)");//
			stmt.setString(1, aluno.getEscolaridade());
			stmt.setInt(2, last_inserted_id);
			
            stmt.executeUpdate();
            
		}catch (Exception e) {
			e.printStackTrace();
		}
		return last_inserted_id;
	}
	
	public void excluir(int id) {
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement("delete from aluno where pessoa_id=?");
			stmt.setInt(1, id);
			
            stmt.executeUpdate();
            
            stmt = this.conexao.prepareStatement("delete from pessoa where id=?");
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public  void atualizar(Aluno a) {
		try {
			PreparedStatement stmt = this.conexao.prepareStatement("update pessoa set nome=? where id=?");
			stmt.setString(1, a.getNome());
            stmt.setInt(2, a.getId());
            
            stmt.executeUpdate();
            
            stmt = this.conexao.prepareStatement("update aluno set escolaridade=? where pessoa_id=?");
            stmt.setString(1, a.getEscolaridade());
            stmt.setInt(2, a.getId());
            
            stmt.executeUpdate();
            
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
