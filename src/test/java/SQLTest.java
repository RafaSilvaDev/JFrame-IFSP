import br.edu.ifsp.mavendb.DAOUser;
import org.junit.Assert;
import org.junit.Test;

/*
* Nesta classe, será realizado o teste de conxão com o banco de dados.
*/

public class SQLTest {
    DAOUser daoUser = new DAOUser();

    @Test
    public void sqlConnect() throws Exception {
        boolean connectionStatus;
        connectionStatus = daoUser.connect();
        Assert.assertTrue(connectionStatus); //Asserção da conexão com o banco de dados
    }
}
