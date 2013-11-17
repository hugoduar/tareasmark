
package operations.publicacion;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.DBConf;
import model.publicacion.Publicacion;
import model.publicacion.PublicacionFisica;

public class StorePublicacion {
    public ResultSet savePublicacion(Publicacion pub) throws Exception{
        DBConf dbConf = new DBConf();
        Connection con = dbConf.getMysqlCon();
        PreparedStatement ps =con.prepareStatement("INSERT INTO Publicacion (id_pro, id_gpo) VALUES(?,?)");
        ps.setInt(1, pub.getIdProfesor());
        ps.setInt(2, pub.getIdGrupo());
        ResultSet rs = ps.getGeneratedKeys();
        ps.close();
        con.close();
        return rs;
        
    }
    public boolean savePublicacionFisica(PublicacionFisica pub) throws Exception{
        ResultSet rs = savePublicacion(pub);
        if(rs==null) {
            return false;
        }
        int idPub = 0;
        while(rs.next()) {
            idPub = rs.getInt("id_pub");
        }
        DBConf dbConf = new DBConf();
        Mongo mc = dbConf.getMongoClient();
        DB db = dbConf.getMongoDB(mc);
        DBCollection coll = db.getCollection("tareas_publicadas");
        System.out.println(coll.getCount());
        BasicDBObject obj = new BasicDBObject("id_pub", idPub).append("id_pro", pub.getIdProfesor())
                .append("id_gpo", pub.getIdGrupo());
        mc.close();
        return true;
    }
}
