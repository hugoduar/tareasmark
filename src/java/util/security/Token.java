/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util.security;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hugo
 */
public class Token {
    public int idUsuario;
    public String dateLastLog;
    public String remoteA;

    public Token(int idUsuario, String dateLastLog, String remoteA) {
        this.idUsuario = idUsuario;
        this.dateLastLog = dateLastLog;
        this.remoteA = remoteA;
    }

    public String getRemoteA() {
        return remoteA;
    }

    public void setRemoteA(String remoteA) {
        this.remoteA = remoteA;
    }

    public Token() {
    }

    public Token(int idUsuario, String dateLastLog) {
        this.idUsuario = idUsuario;
        this.dateLastLog = dateLastLog;
    }
    
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDateLastLog() {
        return dateLastLog;
    }

    public void setDateLastLog(String dateLastLog) {
        this.dateLastLog = dateLastLog;
    }
    
    public String generateToken(){
        String tkn = null;
        try {
            tkn = CipherStandar.encrypt(Password.p, this.dateLastLog+String.valueOf(this.idUsuario));
        } catch (Exception ex) {
            Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tkn;
    }
    public String generateSecureToken(){
        String tkn = null;
        try {
            tkn = CipherStandar.encrypt(Password.p, this.dateLastLog+" "+String.valueOf(this.idUsuario)+" "+this.remoteA);
        } catch (Exception ex) {
            Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tkn;
    }
    
}
