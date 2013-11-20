/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.publicacion;

public interface Publicacion {
    public void setId(int id);
    public int getId();
    public void setIdProfesor(int id);
    public int getIdProfesor();
    public int getIdGrupo();
    public void setIdGrupo(int id);
    public int getIdAsignatura();
    public void setIdAsignatura(int id);
    public String getTitulo();
    public void setTitulo(String id);
}
