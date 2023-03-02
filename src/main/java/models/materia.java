package models;

public class materia extends estudianteClasePadre {
    public String materia;
    public String profesor;
    public int numNotas;

    public materia() {
        super();
    }

    public materia(String materia, String profesor, int numNotas) {
        this.materia = materia;
        this.profesor = profesor;
        this.numNotas = numNotas;
    }

    public materia(String nombre, String curso, String materia, String profesor, int numNotas) {
        super(nombre, curso);
        this.materia = materia;
        this.profesor = profesor;
        this.numNotas = numNotas;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getNumNotas() {
        return numNotas;
    }

    public void setNumNotas(int numNotas) {
        this.numNotas = numNotas;
    }

    @Override
    public String toString() {
        return super.toString() + "materia [materia=" + materia + ", profesor=" + profesor + ", numNotas=" + numNotas + "]";
    }
    
}
