public class Buque{
    private String nombre;
    private String cuadritos;
    private int orientacion;
    public int largo;
    private boolean disponibilidad;
    private int filaBarco;
    private int columnaBarco;
 
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
     public String getNombre() {
         return nombre;
     }
     public void setCuadritos(String cuadritos) {
         this.cuadritos = cuadritos;
     }
     public String getCuadritos() {
         return cuadritos;
     }
     public void setOrientacion(int orientacion) {
         this.orientacion = orientacion;
     }
     public int getOrientacion() {
         return orientacion;
     }
     public void setDisponibilidad(boolean disponibilidad) {
         this.disponibilidad = disponibilidad;
     }
     public boolean getDisponibilidad(){
         return disponibilidad;
     }
     public void setFilaBarco(int filaBarco) {
         this.filaBarco = filaBarco;
     }
     public int getFilaBarco() {
         return filaBarco;
     }
     public void setColumnaBarco(int columnaBarco) {
         this.columnaBarco = columnaBarco;
     }
     public int getColumnaBarco() {
         return columnaBarco;
     }
     public void setLargo(int largo) {
         this.largo = largo;
     }
     public int getLargo() {
         return largo;
     }
     
 
     public Buque(String nombre, String cuadritos,  int orientacion, boolean disponibilidad){
         super();
         this.nombre = nombre;
         this.cuadritos = cuadritos;
         this.orientacion = orientacion;
         this.disponibilidad = disponibilidad;
     }
 }































// public class Buque{
//     int largo;
//     String nombre;
//     int filas;
//     int columnas;
//     int bombas;
//     int vida = 16;
//     int orientacion;
    
//     public void setBombas(int bombas) {
//         this.bombas = bombas;
//     }
//     public int getBombas() {
//         return bombas;
//     }
//     public void setColumnas(int columnas) {
//         this.columnas = columnas;
//     }
//     public int getColumnas() {
//         return columnas;
//     }
//     public void setFilas(int filas) {
//         this.filas = filas;
//     }
//     public int getFilas() {
//         return filas;
//     }
//     public void setLargo(int largo) {
//         this.largo = largo;
//     }
//     public int getLargo() {
//         return largo;
//     }
//     public void setNombre(String nombre) {
//         this.nombre = nombre;
//     }
//     public String getNombre() {
//         return nombre;
//     }
//     public void setOrientacion(int orientacion) {
//         this.orientacion = orientacion;
//     }
//     public int getOrientacion() {
//         return orientacion;
//     }
//     public void setVida(int vida) {
//         this.vida = vida;
//     }
//     public int getVida() {
//         return vida;
//     }
// }