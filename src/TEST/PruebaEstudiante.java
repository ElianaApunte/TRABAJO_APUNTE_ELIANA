
package TEST;

import CURSO.ESTUDIANTE;
import CURSO.ORDENAMIENTO;
import java.util.Scanner;


public class PruebaEstudiante {
    static Scanner datos = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n;
        int nroHombres,ne;
        
        System.out.println("Ingrese el # de estudiantes: ");
        n=datos.nextInt();
        
        ESTUDIANTE [] cursoA = new ESTUDIANTE [n];
        
        llenaDatos(cursoA);
        
        System.out.println("Listado de estudiantes ");
        for(ESTUDIANTE cur:cursoA){
            System.out.println(cur);
        }
        
        System.out.println("Listado de estudiantes de mayor a menor nota ");
        ORDENAMIENTO.ordenar(cursoA);
        for(ESTUDIANTE cur:cursoA){
            System.out.println(cur);
        }
        
        nroHombres=porgenero(cursoA); 
        System.out.println("El % de hombres X encima del promedio :"
                +porPromedio(cursoA, nroHombres, 'm'));
        System.out.println("El % de mujeres X encima del promedio :"
                +porPromedio(cursoA, nroHombres, 'f'));
        ne = notaAlta(cursoA);
        System.out.println("El estudiante con la mas alta nota es :"+
                cursoA[ne].getNombre());
    }
    
    public static void llenaDatos (ESTUDIANTE cur[]){
        String nombre;
        char genero;
        double nota;
        
        
        for (int i=0;i<cur.length;i++)
        {
            datos.nextLine();
            System.out.println("Estudiante numero "+(i+1));
            System.out.println("Nombre del Estudiante ");
            nombre=datos.nextLine();
            System.out.println("Genero del Estudiante "+
                    "(m=masculino;f=femenino) ");
            genero=datos.next().charAt(0);
            System.out.println("Nota del Estudiante ");
            nota=datos.nextDouble();
            
            cur[i] = new ESTUDIANTE(nombre,genero,nota);
        }
    }
    
    
    public static int porgenero(ESTUDIANTE cur[]){
        int contm = 0, contf = 0;
        double PorNro;
        
        for(int i=0;i<cur.length;i++){
            if (cur[i].getGenero()=='m'){
                contm++;
            }
        }
        contf = cur.length - contm;
        System.out.println("Porcentaje de hombres es "+ (contm*100/cur.length)+
                "%");
        System.out.println("Porcentaje de mujeres es "+ (contf*100/cur.length)+
                "%");
        PorNro=contm*100/cur.length;
        
        return contm;
    }
    
    public static double porPromedio(ESTUDIANTE cur[], int hom, char sex){
        int muj=cur.length-hom;
        int cont=0;
        double promedio = 0;
        double porhombre,pormujer;
        for(int i =0;i<cur.length;i++){
            promedio+=cur[i].getNota();
        }
        promedio=promedio/cur.length;
        
        for(int i =0;i<cur.length;i++){
            if(cur[i].getNota()>promedio && cur[i].getGenero()==sex){
                cont++;
            }
        }
        porhombre=hom*100/cur.length;
        pormujer=muj*100/cur.length;
        
        if (sex=='m' && hom>0){
            porhombre=cont*porhombre/hom;
            return porhombre;
        }
        else if (muj>0){
            pormujer=cont*pormujer/muj;
            return pormujer;
        }
        else {
            return 0;
        }
    }
    
    public static int notaAlta (ESTUDIANTE cur[]){
        double mayor;
        int indice=0;
        mayor=cur[0].getNota();
        
        for(int i=1;i<cur.length;i++){
            if (cur[i].getNota()>mayor){
                mayor=cur[i].getNota();
                indice=i;
            }
        }
              
        return indice;
    }
}
