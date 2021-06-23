
package CURSO;


public class ESTUDIANTE implements Comparable<ESTUDIANTE>{
    private String nombre;
    private char genero;
    private double nota;
    

    public ESTUDIANTE(String nombre, char genero, double nota) {
        this.nombre = nombre;
        this.genero = genero;
        this.nota = nota;
        
    }
    

    public String getNombre() {
        return nombre;
    }

    public char getGenero() {
        return genero;
    }

    public double getNota() {
        return nota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

   
    @Override
    public String toString()
    {
        return this.nombre+" "+this.genero+" "+this.nota;
    }
    
    @Override
    public int compareTo(ESTUDIANTE otroESTUDIANTE){
       if (this.getNota()<otroESTUDIANTE.getNota()){
           return 1;
       }
       else if (this.getNota()>otroESTUDIANTE.getNota()){
           return -1;
       }
       return 0;
    }
    
}

