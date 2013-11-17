
package model;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConf {
    /*
     * Configuracion para la conexion a la base de datos
     * "MONGODB"
     */
    public String dbMongo;
    public String hostMongo;
    public String userMongo;
    public String pwdMongo;
    public int portMongo;
     /*
     * Configuracion para la conexion a la base de datos
     * "MYSQL"
     */
    public static final String dbMysql = "tareasmark";
    public static final String ipMysql = "mysql-quoda1.jelastic.servint.net";
    public static final String userMysql = "gauss";
    public static final String pwdMysql = "gauss";
    public static final int portMysql = 3306;
    public DBConf() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.home") + "/mongo.cfg"));
            this.dbMongo = prop.getProperty("db").toString();
            this.hostMongo = prop.getProperty("host").toString();
            this.pwdMongo = prop.getProperty("password").toString();
            this.userMongo = prop.getProperty("user").toString();
            this.portMongo = Integer.valueOf(prop.getProperty("port").toString());
        } catch (Exception ex) {
            Logger.getLogger(DBConf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public Mongo getMongoClient(){
        MongoClient mc = null;
        Mongo m = null;
        try{
            mc = new MongoClient(this.hostMongo, this.portMongo);
             m = new Mongo(this.hostMongo);
	}catch(Exception e){
            e.printStackTrace();
            
        }
        return m;
        	
    }
    public DB getMongoDB(Mongo mc){
	DB db = null;
        try{
            db = mc.getDB(this.dbMongo);
            db.authenticate(this.userMongo, this.pwdMongo.toCharArray());
	}catch(Exception e){
            e.printStackTrace();
        }
        return db;
    }
    public Connection getMysqlCon() throws ClassNotFoundException, SQLException{
        Connection con = null;
        //DefaultConfig
	String URL = "jdbc:mysql://"+ipMysql+"/"+dbMysql;      
         //DefaultConfig
        Class.forName("com.mysql.jdbc.Driver");                 
        con = (Connection) DriverManager.getConnection(URL,userMysql,pwdMysql);
        System.out.println("Conectado a la base de datos");
        return con;
    }
}
