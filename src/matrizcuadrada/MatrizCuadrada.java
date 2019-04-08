
package matrizcuadrada;

public class MatrizCuadrada {

    /**
    * Método que recorre la matriz cuadrada validando despues de la primera suma de fila o columna si
    * cumple con un cuadrado magico, si no lo es retorna false.
    * @param m cuadrada de enteros.
    * @return true si es una matriz cuadrada, false si no lo es.
    */
    static boolean esCuadradoMagico(int m[][]){
        
    int n= m.length;
    int v[] = new int [n]; //vector que almacenara el valor de las sumas encontradas en filas y en columnas.
    
        //recorre las filas obteniendo la suma en cada una y validando si es igual a la suma anterior.
        for (int i = 0; i < n; i++) {
            v[i] = getSumF(m,i);
            if(i > 0 && (v[i] != v[i-1]))
                return false;            
        }
        
        //recorre las columnas obteniendo la suma en cada una y validando si es igual a la suma anterior.
        for (int i = 0; i < n; i++) {
            v[i] = getSumC(m,i);
            if(i > 0 && (v[i] != v[i-1]))
                return false;            
        }
        
        //se obtiene las sumas de la diagonal principal y validando si es igual a alguna de las sumas
        //calculadas anterior mente guardadas en el vector v, en este caso se comparó con el valor del indice [0]
        //suponiendo que hasta este momento el algoritmo ha encontrado todas las sumas iguales.
        if(getDiag1(m) != v[0])
            return false;
        
        //se obtiene las sumas de la diagonal seccundaria y validando si es igual a alguna de las sumas
        //calculadas anterior mente guardadas en el vector v, en este caso se comparó con el valor del indice [0]
        //suponiendo que hasta este momento el algoritmo ha encontrado todas las sumas iguales.
        if(getDiag2(m) != v[0])
            return false;
        
        return true;
    }       

    /**
    * Método que suma los valores de la fila en el indice recibido.
    * @param m cuadrada de enteros.
    * @param indice es el indice de la matriz donde realizara la suma.
    * @return entero con el valor de la suma calculada.
    */
    static int getSumF(int[][] m, int indice) {
        int n = m.length;
        int suma = 0;
        
        for (int i = 0; i < n; i++) {
            suma += m[indice][i];
        }
        return suma;
    }
    
    /**
    * Método que suma los valores de la columna en el indice recibido.
    * @param m cuadrada de enteros.
    * @param indice es el indice de la matriz donde realizara la suma.
    * @return entero con el valor de la suma calculada.
    */
    static int getSumC(int[][] m, int indice) {
        int n = m.length;
        int suma = 0;
        
        for (int i = 0; i < n; i++) {
            suma += m[i][indice];
        }
        return suma;
    }

    /**
    * Método que suma los valores de la diagonal principal de la matriz cuadrada.
    * @param matriz cuadrada de enteros.
    * @return entero con el valor de la suma calculada.
    */
    static int getDiag1(int[][] m) {
        int n = m.length;
        int suma = 0;
        
        for (int i = 0; i < n; i++) {
            suma += m[i][i];
        }
        return suma;
    }

    /**
    * Método que suma los valores de la diagonal secundaria de la matriz cuadrada.
    * @param matriz cuadrada de enteros.
    * @return entero con el valor de la suma calculada.
    */
    static int getDiag2(int[][] m) {
        int n = m.length;
        int j = n;
        int suma = 0;
        
        for (int i = 0; i < n; i++) {
            suma += m[i][j-1];
            j--;
        }
        return suma;
    }
    
    public static void main(String[] args) {      
        //Matriz con un cuadrado magico.
        int m[][] = {
                     {16,3,2,13},
                     {5,10,11,8},
                     {9,6,7,12},
                     {4,15,14,1}
                    };
        
        System.out.println("Es cuadrado mágico: " + esCuadradoMagico(m));
    }
    
}
