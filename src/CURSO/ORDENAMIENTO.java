
package CURSO;


public class ORDENAMIENTO {
    public static void ordenar(Comparable cur[]){
        boolean ordenado=false;
        while(!ordenado){
            ordenado=true;
            for(int i=0;i<cur.length-1;i++){
                if(cur[i+1].compareTo(cur[i])<0){
                    Comparable auxi=cur[i];
                    cur[i]=cur[i+1];
                    cur[i+1]=auxi;
                    ordenado=false;
                }
            }
        }
    }
}
