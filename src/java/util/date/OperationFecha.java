/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Hugo
 */
public class OperationFecha {

    public OperationFecha() {
    }
    public Date sumarDias(Date d1, int days){
        SimpleDateFormat sdf = new SimpleDateFormat(ConfigDate.format);
        Calendar c = Calendar.getInstance();
        c.setTime(d1); 
        c.add(Calendar.DATE, days); 
        Date dr = c.getTime();
        return dr;
    }
    
    public boolean caduco(String date){
        SimpleDateFormat sdf = new SimpleDateFormat(ConfigDate.format);
        Date d1 = strToDate(date);
        Date da = new Date();
        int res = d1.compareTo(da);
        if (res<0) {
            return true;
        }else{
            return false;
        }
        
    }
    public Date strToDate(String strFecha){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(ConfigDate.format);
        Date fecha = null;
        try {

        fecha = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {

        ex.printStackTrace();

        }

        return fecha;
    }
    
}
