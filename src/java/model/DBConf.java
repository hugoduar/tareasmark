
package model;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConf {

    public DBConf() {
    }
    public MongoClient getMongoClient(){
        //Default config

	String dbName = "tareasmark";
	String remoteAd = "localhost";
	int port = 27017;

	//Default config
         MongoClient mc = null;
        try{
             mc = new MongoClient(remoteAd, port);
            
	}catch(Exception e){
            e.printStackTrace();
        }
        return mc;	
    }
    public DB getMongoDB(MongoClient mc){
	//Default config

	String dbName = "tareasmark";
	String remoteAd = "localhost";
	int port = 27017;

	//Default config

	//Code
	DB db = null;
        try{
            
            db = mc.getDB(dbName);
	}catch(Exception e){
            e.printStackTrace();
        }
        return db;	
    }
    public Connection getMysqlCon() throws ClassNotFoundException, SQLException{
        Connection con = null;
        //DefaultConfig
	String URL = "jdbc:mysql://localhost:3306/tareasmark";  
        String userName = "root";                               
        String password = "n0m3l0";      
         //DefaultConfig
        Class.forName("com.mysql.jdbc.Driver");                 
        con = (Connection) DriverManager.getConnection(URL,userName,password);
        System.out.println("Conectado a la base de datos");
        return con;
    }
}
