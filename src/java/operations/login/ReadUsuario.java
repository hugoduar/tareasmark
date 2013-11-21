/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operations.login;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.DBConf;
import model.usuario.Usuario;
import util.date.OperationFecha;
import util.security.CipherStandar;
import util.security.Password;
import util.security.Token;

/**
 *
 * @author Hugo
 */
public class ReadUsuario {

    public ReadUsuario() {
    }
    public String getNombreUsuario(int id){
        DBConf dbconf = new DBConf();
        Mongo mc = dbconf.getMongoClient();
        DB db = dbconf.getMongoDB(mc);
        DBCollection coll = db.getCollection("usuario");
        DBObject query = new BasicDBObject("id_usu", id);
        DBCursor cursor = coll.find(query);
        String result = null;
        while(cursor.hasNext()){
            result = String.valueOf(cursor.next().get("nom_usu"));
        }
        mc.close();
        return result;
    }
    public int usuarioId(String token){
        DBConf dbconf = new DBConf();
        Mongo mc = dbconf.getMongoClient();
        DB db = dbconf.getMongoDB(mc);
        DBCollection coll = db.getCollection("token");
        DBObject query = new BasicDBObject("token", token);
        DBCursor cursor = coll.find(query);
        int idUsuario = 0;
        while(cursor.hasNext()){
            String aux;
            aux = String.valueOf(cursor.next().get("id_usu"));
            float f = Float.valueOf(aux);
            idUsuario = Math.round(f);
        }
        mc.close();
        return idUsuario;
    }
    public void removeToken(String tkn){
        DBConf dbconf = new DBConf();
        Mongo mc = dbconf.getMongoClient();
        DB db = dbconf.getMongoDB(mc);
        DBCollection coll = db.getCollection("token");
        DBObject docs = new BasicDBObject("token", tkn);
        coll.remove(docs);
        mc.close();
    }
    public int existeUsuario(String usuario, String password) throws Exception{
        DBConf dbconf = new DBConf();
//        MongoClient mc = dbconf.getMongoClient();
//        DB db = dbconf.getMongoDB(mc);
//        DBCollection coll = db.getCollection("usuario");
//        String cpass = CipherStandar.encrypt(Password.p,password);
//        DBObject query = new BasicDBObject("nic_usu", usuario).append("pas_usu", cpass);
//        DBCursor cursor = coll.find(query);
//        
//        while(cursor.hasNext()){
//            String aux;
//            aux = String.valueOf(cursor.next().get("id_usu"));
//            float f = Float.valueOf(aux);
//            idUsuario = Math.round(f);
//        }
//        mc.close();
        String cpass = CipherStandar.encrypt(Password.p,password);
        Connection con = dbconf.getMysqlCon();
        PreparedStatement ps = (PreparedStatement) con.clientPrepareStatement("SELECT * FROM MUsuario WHERE nic_usu=? & pas_usu=?");
        ps.setString(1, usuario);
        ps.setString(2, cpass);
        ResultSet rs = ps.executeQuery();
        int idUsuario = 0;
        while(rs.next()){
            idUsuario = rs.getInt("id_usu");
        }
        con.close();
        return idUsuario;
    }
    public void removeAllCookies(int id){
        DBConf dbconf = new DBConf();
        Mongo mc = dbconf.getMongoClient();
        DB db = dbconf.getMongoDB(mc);
        DBCollection coll = db.getCollection("token");
        DBObject docs = new BasicDBObject("id_usu", id);
        coll.remove(docs);
        mc.close();
    }
    public String makeToken(int id, String dateLastLogin, String expirate, String remoteAd){
        Token tkn = new Token(id, dateLastLogin, remoteAd);
        DBConf dbconf = new DBConf();
        Mongo mc = dbconf.getMongoClient();
        DB db = dbconf.getMongoDB(mc);
        DBCollection coll = db.getCollection("token");
        DBObject token = new BasicDBObject("token", tkn.generateSecureToken()).
                             append("date_log", dateLastLogin).
                             append("expirate", expirate).
                             append("id_usu", id).
                             append("ip", remoteAd);
        
        coll.insert(token);
        mc.close();
        return tkn.generateSecureToken();
    }
    public void saveSessions(DBObject obj){
        DBConf dbconf = new DBConf();
        Mongo mc = dbconf.getMongoClient();
        DB db = dbconf.getMongoDB(mc);
        DBCollection coll = db.getCollection("oldtoken");
        coll.insert(obj);
   }
    public boolean tokenExist(String token){
        OperationFecha op = new OperationFecha();
        DBConf dbconf = new DBConf();
        Mongo mc = dbconf.getMongoClient();
        DB db = dbconf.getMongoDB(mc);
        DBCollection coll = db.getCollection("token");
        DBObject query = new BasicDBObject("token", token);
        DBCursor cursor = coll.find(query);
        if(coll==null)return false;
        boolean res = false;
        while(cursor.hasNext()){
            DBObject n = cursor.next();
            String date = (String) n.get("expirate");
            if(!op.caduco(date)) {
                res = true;
            }else{
                saveSessions(n);
                coll.remove(query);
            }
        }
        cursor.close();
        mc.close();
        return res;
        
    }
}
