/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.profesor;

/**
 *
 * @author Hugo
 */
public interface Profesor {
    public int getId();
    public void setId(int id);
    public String getNombre();
    public void setNombre(String nombre);
    public String getApellidPaterno();
    public void seApellidPaterno(String apellidoPaterno);
    public String getApellidMaterno();
    public void seApellidMaterno(String apellidoMaterno);
    public String getMatricula();
    public void setMatricula(String Matricula);
}
