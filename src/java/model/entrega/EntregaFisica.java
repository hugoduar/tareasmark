/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entrega;

/**
 *
 * @author Hugo
 */
public class EntregaFisica implements Entrega{
    int id;
    int idPublicacion;
    int idAlumno;
    int idProfesor;
    int idGrupo;
    int idAsignatura;
    @Override
    public int getIdAlumno(int id) {
        return this.idAlumno;
    }

    @Override
    public int getIdProfesor(int id) {
        return this.idProfesor;
    }

    @Override
    public int getIdGrupo(int id) {
        return this.idGrupo;
    }

    @Override
    public int getIdAsignatura(int id) {
        return this.idAsignatura;
    }

    @Override
    public void setIdAlumno(int id) {
        this.idAlumno = id;
    }

    @Override
    public void setIdProfesor(int id) {
        this.idProfesor = id;
    }

    @Override
    public void setIdGrupo(int id) {
        this.idGrupo = id;
    }

    @Override
    public void setIdAsignatura(int id) {
        this.idAsignatura = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    
}
