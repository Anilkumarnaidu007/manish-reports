package Charts.E_Boarding_Reports;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db_Connection

{
	public static Connection getDBConnection()     
    {
    Connection conn=null;
            try{
            	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            	
            	String connectionUrl="jdbc:sqlserver://10.86.52.170:1433; database=GMRDB;user=sa;password=ebs$$adm";
                conn = DriverManager.getConnection(connectionUrl);
                System.out.println(conn);
    }catch(Exception mex)
    {
        mex.printStackTrace();
    }
        return conn;
    }
	public static void closeConnections(Connection con,CallableStatement calstat,ResultSet rs)
	    {
	        try{
	            if(null !=rs)
	            rs.close();
	        
	            if(calstat != null)
	            calstat.close();
	        
	        if(con != null)
	            con.close();
	        
	        }catch(SQLException exp){
	        exp.printStackTrace();
	        }finally{
	        
	        }
	    }

}


