
package model;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConf {
    /*
     * Configuracion para la conexion a la base de datos
     * "MONGODB"
     */
    public static final String dbMongo = "tareasmark";
    public static final String ipMongo = "localhost";
    public static final String userMongo = "gauss";
    public static final String pwdMongo = "gauss";
    public static final int portMongo = 27017;
     /*
     * Configuracion para la conexion a la base de datos
     * "MYSQL"
     */
    public static final String dbMysql = "tareasmark";
    public static final String ipMysql = "localhost";
    public static final String userMysql = "gauss";
    public static final String pwdMysql = "gauss";
    public static final int portMysql = 3306;
    public DBConf() {
    }
    public MongoClient getMongoClient(){
         MongoClient mc = null;
        try{
             mc = new MongoClient(ipMongo, portMongo);
            
	}catch(Exception e){
            e.printStackTrace();
        }
        return mc;	
    }
    public DB getMongoDB(MongoClient mc){
	//Default config

	String dbName = dbMongo;
	String remoteAd = ipMongo;

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
	String URL = "jdbc:mysql://localhost:"+String.valueOf(portMysql)+"/"+dbMysql;  
        String userName = "root";                               
        String password = "n0m3l0";      
         //DefaultConfig
        Class.forName("com.mysql.jdbc.Driver");                 
        con = (Connection) DriverManager.getConnection(URL,userMysql,pwdMysql);
        System.out.println("Conectado a la base de datos");
        return con;
    }
}
