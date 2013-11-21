/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package operations.publicacion;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DBConf;
import model.publicacion.Publicacion;
import model.publicacion.PublicacionFisica;

/**
 *
 * @author Hugo
 */
public class ReadPublicacion {

    public ReadPublicacion() {
    }
    
    public ResultSet getPublicacionByIdGrupo(int idGrupo) throws Exception{
        DBConf dbConf = new DBConf();
        Connection con = dbConf.getMysqlCon();
        PreparedStatement ps =con.prepareStatement("SELECT * FROM MPublicacion WHERE id_gpo=?");
        ps.setInt(1, idGrupo);
        
        ResultSet rs = ps.executeQuery();
        
        con.close();
        return rs;
    }
    public List<PublicacionFisica> getPublicacionesFisicasByIdGrupo(int idGrupo) throws Exception{
        DBConf dbConf = new DBConf();
        Mongo mc = dbConf.getMongoClient();
        DB db = dbConf.getMongoDB(mc);
        DBCollection coll = db.getCollection("publicacion");
        DBCursor cursor = coll.find(new BasicDBObject("id_gpo", idGrupo));
        Connection con = dbConf.getMysqlCon();
        PreparedStatement ps =con.prepareStatement("SELECT * FROM MPublicacion WHERE id_gpo=?");
        ps.setInt(1, idGrupo);
        ResultSet allPubs = ps.executeQuery();
        List<PublicacionFisica> pubs = new ArrayList<PublicacionFisica>();
        while(allPubs.next()){
            int idPub = allPubs.getInt("id_pub");
            DBObject obj = cursor.next();
            pubs.add(new PublicacionFisica(
                    Integer.parseInt(String.valueOf(obj.get("id_pub"))),
                    String.valueOf(obj.get("titulo")),
                    String.valueOf(obj.get("desc")),
                    String.valueOf(obj.get("fec_pub")),
                    String.valueOf(obj.get("fec_ent")),
                    Integer.parseInt( String.valueOf(obj.get("id_pro"))),
                    Integer.parseInt( String.valueOf(obj.get("id_gpo")))));
            
        }
        con.close();
        mc.close();
        return pubs;
    
    }
    
}
