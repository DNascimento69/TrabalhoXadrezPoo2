package p2o2.ifes.serra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DAOGeneric{
	
	private Connection con;
        
	
        public void openConnection() throws SQLException, ClassNotFoundException
	{
		 
		Class.forName("org.hsqldb.jdbcDriver");
		
		String url = "jdbc:hsqldb:file:Xadrez";
		Properties properties = new Properties();
                
		con = DriverManager.getConnection(url,properties);
                //System.out.println("ABRIU!");
	}
	
	protected void execute(String query) throws SQLException
	{
		Statement statement = con.createStatement();
		// Comando para criar
		statement.execute(query);
		
		statement.close();
		
	}
	
	protected ResultSet executeQuery(String query) throws SQLException
	{
		Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery(query);
		
		return rs;
	}
	
	
	protected int executeUpdate(String query) throws SQLException
	{
		Statement statement = con.createStatement();
		
		int numero = 0;
		// Comando para update, insert e delete		
		statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = statement.getGeneratedKeys();
		
		if (rs.next())
		{
			numero = rs.getInt(1);
		}
		
		statement.close();
		
		return numero;
	}
	
	
	protected void closeConnection() throws SQLException
	{
		con.close();
	}		
	

}
