package Dao;

/**
 *
 * @author lined
 */
public class DaoFactory {
    
       public static AlunoDao getAlunoDao(){
        return new AlunoDao();
    }
       
}
