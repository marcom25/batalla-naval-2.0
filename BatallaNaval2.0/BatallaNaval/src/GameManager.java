import java.util.Random;

public class GameManager{
    Buque [][] buque = new Buque[11][11];
    Random random = new Random();
    // private int dificultad;
    private int bombas;
    private int vida = 16;
    public int largo;
    public int filas;
    public int columnas;
    private int incrementoExterno;
    private int incrementoInterno;
    private int columnasNueva;
    private int filasNueva;
    private int coordenadaFila;
    private int coordenadaColumna;



    public void setCoordenadaFila(int coordenadaFila) {
        this.coordenadaFila = coordenadaFila;
    }
    public int getCoordenadaFila() {
        return coordenadaFila;
    }
    public void setCoordenadaColumna(int coordenadaColumna) {
        this.coordenadaColumna = coordenadaColumna;
    }
    public int getCoordenadaColumna() {
        return coordenadaColumna;
    }
    public void setBombas(int bombas){
        this.bombas = bombas;
    }
    public int getBombas() {
        return bombas;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getVida() {
        return vida;
    }
    

    public void crearBuque(){
        for (int fila = 0; fila < buque.length; fila++) {
            for (int columna = 0; columna < buque.length; columna++) {
                buque[fila][columna] = new Buque(null, null, 0, false);
            }
        }
    } 
    
    public void crearTablero(){
        crearBuque();
        for (int fila = 0; fila < buque.length; fila++) {
            for (int columna = 0; columna < buque.length; columna++) {
                if(fila == 0 && columna == 0){// En la posicion [0][0] del array visible va a generar un valor de tipo string vacio
                    buque[fila][columna].setCuadritos("  ");

                }else if(fila == 0){// Si estamos parados en la posicion 0 de las filas, se generara el numero de columnas correspondiente a la posicion. Ecolumna: [0][1] = 1, [0][2] = 2, [0][3] = 3.
                    String numero = Integer.toString(columna);
                    buque[fila][columna].setCuadritos(numero);

                }else if (fila != 10 && columna == 0){
                    String numero = Integer.toString(fila);
                    buque[fila][columna].setCuadritos(" " + numero);

                }else if(columna == 0){// Si estamos parados en la posicion 0 de las columnas, se va a generar el numero de filas correspondiente. Ecolumna: [1][0] = 1, [2][0] = 2, [3][0] = 3.
                    String numero = Integer.toString(fila);
                    buque[fila][columna].setCuadritos(numero);

                }else //Aqui simplemente se van a generar los cuadros en las posiciones que se va a columnaugar 
                    buque[fila][columna].setCuadritos("▢");
                
            }    
        }
    }

    public void mostrarTablero(){
        
        for (int fila = 0; fila < buque.length; fila++) {
            for (int columna = 0; columna < buque.length; columna++) {
                System.out.print(buque[fila][columna].getCuadritos() + " ");
            }
            System.out.println();
        }
    }


    

public void elegirDificultad(int opcion){
        switch(opcion) {
            case 1:
                setBombas(50);
                break;
            
            case 2:
                setBombas(35);
                break;

            case 3:
                setBombas(20);
                break;
        }
    }

    public void checkDisponibilidad(){
        int acumulador = 0;
        
        if (buque[filas][columnas].getOrientacion() == 1) {
                checkIsInTablero();
                // System.out.println("Valor de columnas en checkDisponibilidad: " + "[" + columnas + "]");
                while (incrementoInterno < largo) {
                    if (buque[filas + 1][(columnas + 1) + incrementoInterno].getDisponibilidad() == false) {// aca van los mas ++
                        // System.out.println("Largo incremento chekDisponibilidad1: " + largo);
                        acumulador++;
                    }
                    incrementoInterno++;
                }
                if (acumulador != largo) {
                    incrementoExterno--;
                }
            
        }else if(buque[filas][columnas].getOrientacion() == 2){
                checkIsInTablero();
                while (incrementoInterno < largo) {
                    if (buque[(filas + 1) + incrementoInterno][columnas + 1].getDisponibilidad() == false) {// aca van los mas ++
                        // System.out.println("Largo incremento checkDisponibilidad2: " + largo);
                        acumulador++;
                    }
                    // System.out.println("Incremento Interno: " + incrementoInterno);
                    incrementoInterno++;

                }
            
                if (acumulador != largo) {
                    incrementoExterno--;
                }         
        }
    }

    public void checkIsInTablero(){// CHEQUEA SI ESTA EN EL TABLERO: 
        if (buque[filas][columnas].getOrientacion() == 1) {
            while (((columnas + 1) + largo) > buque.length) {// + 1
                // System.out.println("Largo incremento checkIsInTablero: " + largo);
                columnasNueva = random.nextInt(11);
                buque[filas][columnas].setColumnaBarco(columnasNueva);
                columnas = columnasNueva;
                // System.out.println("Nuevo valor de columna: " + "[" + columnas + "]");
            }
        }else if(buque[filas][columnas].getOrientacion() == 2){
            while (((filas + 1) + largo ) > buque.length) {// + 1
                // System.out.println("Largo incremento checkIsInTablero: " + largo);
                filasNueva = random.nextInt(11);
                buque[filas][columnas].setFilaBarco(filasNueva);
                filas = filasNueva;
                // System.out.println("Nuevo valor de fila: " + "[" + filasNueva + "]");
            }
        }
    }

    public void introducirBarcosHorizontal(){
        // System.out.println("Largo incremento introducirBarcoHorizontal1: " + largo);
        while (incrementoExterno < 1) {
            checkDisponibilidad();
            incrementoInterno = 0;
            incrementoExterno++;
        }
        incrementoExterno--;
        // System.out.println("Largo incremento introducirBarcoHorizontal2: " + largo);
        while (incrementoExterno < largo) {
            buque[filas + 1][(columnas + incrementoExterno) + 1].setDisponibilidad(true);// aca van los mas ++
            
            // System.out.println("Coordenada: " + "[" + (filas + 1 ) + "]" + "[" + (columnas + incrementoExterno) + "]" );
            incrementoExterno++;                               
        }
        incrementoExterno = 0;
    }

    public void introducirBarcosVertical(){
        // System.out.println("Largo incremento indtroducirBarcosVertical1: " + largo);
        while (incrementoExterno < 1) {
            checkDisponibilidad();
            incrementoInterno = 0;
            incrementoExterno++;
        }
        incrementoExterno--;
        // System.out.println("Largo incremento indtroducirBarcosVertical2: " + largo);
        while (incrementoExterno < largo) {
            buque[(filas + incrementoExterno) + 1][columnas + 1].setDisponibilidad(true);// aca van los mas ++
            
            
            // System.out.println("Coordenada: " + "[" + (filas + incrementoExterno) + "]" + "[" + (columnas + 1) + "]" );
            incrementoExterno++;
        }
        incrementoExterno = 0;
    }

    public void introducirBuque(int orientacion){
        if(orientacion == 1){
            introducirBarcosHorizontal();
        }else if(orientacion == 2){
            introducirBarcosVertical();
        }
    }
    public void cargarDatos(int contador){
        filas = random.nextInt(11);
        columnas = random.nextInt(11);
        // System.out.println("Fila: " + "[" + filas + "]" );
        // System.out.println("Columna: " + "[" + columnas + "]");
        switch (contador) {
            case 0:
            buque[filas][columnas].setNombre("Monitor 1");
            buque[filas][columnas].setColumnaBarco(columnas);
            buque[filas][columnas].setFilaBarco(filas);
            largo = 2;
            
                break;
            case 1:
            buque[filas][columnas].setNombre("Monitor 2");
            buque[filas][columnas].setColumnaBarco(columnas);
            buque[filas][columnas].setFilaBarco(filas);
            largo = 2;
          
                break;
            case 2:
            buque[filas][columnas].setNombre("Fragata");
            buque[filas][columnas].setColumnaBarco(columnas);
            buque[filas][columnas].setFilaBarco(filas);
            largo = 3;
             
                break;
            case 3:
            buque[filas][columnas].setNombre("Acorazado");
            buque[filas][columnas].setColumnaBarco(columnas);
            buque[filas][columnas].setFilaBarco(filas);
            largo = 4;
        
                break;
            case 4:
            buque[filas][columnas].setNombre("Destructor");
            buque[filas][columnas].setColumnaBarco(columnas);
            buque[filas][columnas].setFilaBarco(filas);
            largo = 5;
       
                break;
        }
    }

    public void insertarHit(int filasPar, int columnasPar){
        System.out.println(buque[filasPar][columnasPar].getDisponibilidad());
        
        if(buque[filasPar][columnasPar].getDisponibilidad() == true){
            // System.out.println("Fila: " + filas);
            // System.out.println("Columna: " + columnas);
            buque[filasPar][columnasPar].setCuadritos("B");
            vida--;
            bombas--;
        }else {
            // System.out.println("Fila: " + filasPar + " Valor: " + buque[filasPar][columnasPar].getCuadritos() + "  Disponibilidad: " + buque[filasPar][columnasPar].getDisponibilidad());
            // System.out.println("Columna: " + columnasPar + " Valor: " + buque[filasPar][columnasPar].getCuadritos() + "  Disponibilidad: " + buque[filasPar][columnasPar].getDisponibilidad());
            buque[filasPar][columnasPar].setCuadritos("*");
            bombas--;
        }
    }
}









































// import java.util.Random;
// public class GameManager{
//     String [][] tableroVisual = new String[11][11]; 
//     Boolean [][] tableroTecnico = new Boolean[11][11];
//     Buque buque = new Buque();
//     Random random = new Random();
//     int incrementoi = 0;
//     int incrementoj = 0;
//     int coordenadaFila = 0;
//     int coordenadaColumna = 0;
//     boolean lugaresVacios = false;


//     // public Buque(String nombre, int largo){
//     //     this.nombre = nombre;
//     //     this.largo = largo;
//     // }


    
//     public void setCoordenadaFila(int coordenadaFila) {
//         this.coordenadaFila = coordenadaFila;
//     }
//     public int getCoordenadaFila() {
//         return coordenadaFila;
//     }
//     public void setCoordenadaColumna(int coordenadaColumna) {
//         this.coordenadaColumna = coordenadaColumna;
//     }
//     public int getCoordenadaColumna() {
//         return coordenadaColumna;
//     }


//     public void crearTablero(){
//         for (int i = 0; i < tableroVisual.length; i++) {
//             for (int j = 0; j < tableroVisual.length; j++) {
//                 if (i == 0 && j == 0){// En la posicion [0][0] del array visible va a generar un valor de tipo string vacio
//                     tableroVisual[i][j] = "  ";
//                     tableroTecnico[i][j] = null;
//                 }else if(i == 0){// Si estamos parados en la posicion 0 de las filas, se generara el numero de columnas correspondiente a la posicion. Ej: [0][1] = 1, [0][2] = 2... 
//                     int u = j;
//                     String numero = Integer.toString(u);
//                     tableroVisual[i][j] = numero;
//                     tableroTecnico[i][j] =null;
//                 }else if (i != 10 && j == 0){
//                     int u = i;
//                     String numero = Integer.toString(u);
//                     tableroVisual[i][j] =(" " + numero);
//                 }else if(j == 0){// Si estamos parados en la posicion 0 de las columnas, se va a generar el numero de filas correspondientes. Ej: [1][0] = 1, [2][0] = 2...
//                     int u = i;
//                     String numero = Integer.toString(u);
//                     tableroVisual[i][j] = numero;
//                     tableroVisual[i][j] = null;
//                 }else{// Aca simplemente se van a generar los cuadros en las posiciones que se va a jugar
//                     tableroTecnico[i][j] = false; //false = vacio 
//                     tableroVisual[i][j] = "▢";   
//                 }
//             }
            
//         }
//     }

//     public void mostrarTablero(){
//         for (int i = 0; i < tableroVisual.length; i++) {
//             for (int j = 0; j < tableroVisual.length; j++) {
//                 System.out.print(tableroVisual[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public void elegirDificultad(int opcion){
//         switch(opcion) {
//             case 1:
//                 buque.setBombas(50);
//                 break;
            
//             case 2:
//                 buque.setBombas(35);
//                 break;

//             case 3:
//                 buque.setBombas(20);
//                 break;
//         }
//     }

//     public void checkDisponibilidad(){
//         int acumulador = 0;
//         buque.filas = random.nextInt(10);
//         buque.columnas = random.nextInt(10);
        
//         if (buque.getOrientacion() == 1) {
//                 checkIsInTablero();
//                 while (incrementoj < buque.largo) {
//                     if (tableroTecnico[buque.filas + 1][(buque.columnas + 1) + incrementoj] == false) {
//                         acumulador++;
//                     }
//                     incrementoj++;
//                 }
//                 if (acumulador != buque.largo) {
//                     incrementoi--;
//                 }
            
//         }else if(buque.getOrientacion() == 2){
//                 checkIsInTablero();
//                 while (incrementoj < buque.largo) {
//                     if (tableroTecnico[(buque.filas + 1) + incrementoj][buque.columnas + 1] == false) {
//                         acumulador++;
//                     }
//                     incrementoj++;
//                 }
//                 if (acumulador != buque.largo) {
//                     incrementoi--;
//                 }         
//         }
//     }

//     public void checkIsInTablero(){// CHEQUEA SI ESTA EN EL TABLERO
//         if (buque.getOrientacion() == 1) {
//             while (((buque.columnas + 1) + buque.largo ) > tableroTecnico.length) {
//                 buque.columnas = random.nextInt(10);
//             }
//         }else if(buque.getOrientacion() == 2){
//             while (((buque.filas + 1) + buque.largo ) > tableroTecnico.length) {
//                 buque.filas = random.nextInt(10);
//             }
//         }
//     }

//     public void introducirBarcosHorizontal(){
//         while (incrementoi < 1) {
//             checkDisponibilidad();
//             incrementoj = 0;
//             incrementoi++;
//         }
//         incrementoi--;
//         while (incrementoi < buque.largo) {
//             tableroTecnico[buque.filas + 1][(buque.columnas + incrementoi) + 1] = true;
//             incrementoi++;
//         }
//         incrementoi = 0;
//     }

//     public void introducirBarcosVertical(){
//         while (incrementoi < 1) {
//             checkDisponibilidad();
//             incrementoj = 0;
//             incrementoi++;
//         }
//         incrementoi--;
//         while (incrementoi < buque.largo ) {
//             tableroTecnico[(buque.filas + incrementoi) + 1][buque.columnas + 1] = true;
//             incrementoi++;
//         }
//         incrementoi = 0;
//     }


//     public void cargarDatos(int contador){
//         switch (contador) {
//             case 0:
//             buque.setLargo(2);   
//             buque.setNombre("Monitor 1");
//                 break;
//             case 1:
//             buque.setLargo(2); 
//             buque.setNombre("Monitor 2");
//                 break;
//             case 2:
//             buque.setLargo(3); 
//             buque.setNombre("Fragata");
//                 break;
//             case 3:
//             buque.setLargo(4); 
//             buque.setNombre("Acorazado");
//                 break;
//             case 4:
//             buque.setLargo(5); 
//             buque.setNombre("Destructor");
//                 break;
//         }
//     }

//     public void insertarHit(int coordenadaFila, int coordenadaColumna){
//         if(tableroTecnico[coordenadaFila][coordenadaColumna] == true){
//             tableroVisual[coordenadaFila][coordenadaColumna] = "B";
//             buque.setVida(buque.vida - 1);
//         }else
//             tableroVisual[coordenadaFila][coordenadaColumna] = "*";
//             buque.setBombas(buque.bombas - 1);
//     }

// }



