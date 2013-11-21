
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
     /*p
     * Configuracion para la conexion a la base de datos
     * "MYSQL"
     */
    public String dbMysql;
    public String hostMysql;
    public String userMysql;
    public String pwdMysql;
    public int portMysql;
    public DBConf() {
        Properties propMongo = new Properties();
        Properties propMysql = new Properties();
        String fileMongo = System.getProperty("user.home") + "/mongo.cfg";
        String fileMysql = System.getProperty("user.home") + "/mongo.cfg";
        
//        String fileMongo = "/usr/local/apache-tomcat-7.0.37/conf/Catalina/localhost/mongo.cfg";
//        String fileMysql ="/usr/local/apache-tomcat-7.0.37/conf/Catalina/localhost/mysql.cfg";
        try {
            propMongo.load(new FileInputStream(fileMongo));
            this.dbMongo = propMongo.getProperty("db").toString();
            this.hostMongo = propMongo.getProperty("host").toString();
            this.pwdMongo = propMongo.getProperty("password").toString();
            this.userMongo = propMongo.getProperty("user").toString();
            this.portMongo = Integer.valueOf(propMongo.getProperty("port").toString());
            
            propMysql.load(new FileInputStream(fileMysql));
            this.dbMysql = propMysql.getProperty("db").toString();
            this.hostMysql = propMysql.getProperty("host").toString();
            this.userMysql = propMysql.getProperty("user").toString();
            this.pwdMysql = propMysql.getProperty("password").toString();
            this.portMysql = Integer.parseInt(propMysql.getProperty("port").toString());
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
	String URL = "jdbc:mysql://"+this.hostMysql+":"+String.valueOf(this.portMysql)+"/"+this.dbMysql;      
         //DefaultConfig
        Class.forName("com.mysql.jdbc.Driver");                 
        con = (Connection) DriverManager.getConnection(URL,this.userMysql,this.pwdMysql);
        System.out.println("Conectado a la base de datos");
        return con;
    }
}
