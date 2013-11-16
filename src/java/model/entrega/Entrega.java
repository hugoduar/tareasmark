/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entrega;

/**
 *
 * @author Hugo
 */
public interface Entrega {
    public int getId();
    public void setId(int id);
    public int getIdAlumno(int id);
    public int getIdProfesor(int id);
    public int getIdGrupo(int id);
    public int getIdAsignatura(int id);
    public void setIdAlumno(int id);
    public void setIdProfesor(int id);
    public void setIdGrupo(int id);
    public void setIdAsignatura(int id);
}
