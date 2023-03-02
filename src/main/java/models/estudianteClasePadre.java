package models;

public class estudianteClasePadre {

    public String nombre;
    public String curso;

    public estudianteClasePadre() {
    }

    public estudianteClasePadre(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public  String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }


}
