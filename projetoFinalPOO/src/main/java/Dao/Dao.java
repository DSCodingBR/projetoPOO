
package Dao;

import java.sql.Connection;

import Util.ConnectionFactory;

public class Dao {
	protected Connection conexao;
	
	public Dao(){        
        this.conexao = ConnectionFactory.getConnect();
    }
    
}
