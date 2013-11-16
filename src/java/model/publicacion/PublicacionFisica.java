/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.publicacion;

/**
 *
 * @author Hugo
 */
public class PublicacionFisica implements Publicacion{
    int id_publicacion;
    String titulo;
    String descripcion;
    String fecha_publicacion;
    String fecha_entrega;
    int id_profesor;
    int id_grupo;
    int id_asignatura;

    @Override
    public void setId(int id) {
        this.id_publicacion = id;
    }

    @Override
    public int getId() {
        return this.id_publicacion;
    }

    @Override
    public void setIdProfesor(int id) {
        this.id_profesor = id;
    }

    @Override
    public int getIdProfesor() {
        return this.id_profesor;
    }

    @Override
    public int getIdGrupo() {
        return this.id_grupo;
    }

    @Override
    public void setIdGrupo(int id) {
        this.id_grupo = id;
    }

    public PublicacionFisica(String titulo, String descripcion, String fecha_publicacion, String fecha_entrega, int id_profesor, int id_grupo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_publicacion = fecha_publicacion;
        this.fecha_entrega = fecha_entrega;
        this.id_profesor = id_profesor;
        this.id_grupo = id_grupo;
    }

    public PublicacionFisica(int id_publicacion, String titulo, String descripcion, String fecha_publicacion, String fecha_entrega, int id_profesor, int id_grupo) {
        this.id_publicacion = id_publicacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_publicacion = fecha_publicacion;
        this.fecha_entrega = fecha_entrega;
        this.id_profesor = id_profesor;
        this.id_grupo = id_grupo;
    }

    public PublicacionFisica() {
    }

    @Override
    public int getIdAsignatura() {
        return this.id_asignatura;
    }

    @Override
    public void setIdAsignatura(int id) {
        this.id_asignatura = id;
    }
    
    
}
