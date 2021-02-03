/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ej2;

import java.time.LocalDate;
import daw.ej1.Utilidades;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author NitroPc
 */
public class Jugador {

    //Atributos
    private String nombre;
    private String apellido;
    private LocalDate nacimiento;
    private boolean eleccion;
    private static int contador = 0;//Al ponerle static cada objeto no tiene una copia del contador
    //Por lo que se mantiene su valor en todos los constructores

    //Constructor por defecto
    public Jugador() {

        contador++;
        this.nombre = "Marco";
        this.apellido = "Nieto";
        this.nacimiento = LocalDate.of(1999, 3, 8);
        this.eleccion = true; //true es pares
    }

    //Constructor parametrizado
    public Jugador(String nombre, String apellido, LocalDate nacimiento, boolean eleccion) {
        //para llamar al constructor por defecto e inicializar todo por defecto es:
        //this();
        //Seria asi, aunque de mi manera esta bien
        //Importante Es aconsejable siempre inicializar por defecto
        /*if (Utilidades.calcularYear(nacimiento) >= 18){
            contador++;
            this.nombre = nombre;
            this.apellido = apellido;
            this.nacimiento = nacimiento;
            this.eleccion = eleccion;
        }
         */
        if (Utilidades.calcularYear(nacimiento) < 18) {
            contador++;
            this.nombre = "Marco";
            this.apellido = "Nieto";
            this.nacimiento = LocalDate.of(1999, 3, 8);
            this.eleccion = true;

        } else {
            contador++;
            this.nombre = nombre;
            this.apellido = apellido;
            this.nacimiento = nacimiento;
            this.eleccion = eleccion;
        }
    }

    //Metodo para obtener el numero de objetos creado
    public static int getContador() {
        return contador;
    }
    //Constructor

    public Jugador(Jugador copia) {

        contador++;
        this.nombre = copia.nombre;
        this.apellido = copia.apellido;
        this.nacimiento = copia.nacimiento;
        this.eleccion = copia.eleccion;
    }

    @Override
    public String toString() {

        DateTimeFormatter fechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy");//Si pones 3 y te mostrar solo los ultimos tres numeros de las fechas
        return "Nombre: " + nombre + "\tApellido: " + apellido + "\nFecha: " + nacimiento.format(fechaHora) + "\tElección: [" + comprobar(eleccion) + "]";
    }

    private static String comprobar(boolean elecion) {
        if (elecion) {

            return "Pares";
        }

        return "Nones";
    }

    public String getNombre() {
        return nombre;
    }

    //No hace falta comprobar si es mayor de eda pra cambiar el nombre y el apellido
    public void setNombre(String nombre) {
        
            this.nombre = nombre;
        

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        
            this.apellido = apellido;
        
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        if (Utilidades.calcularYear(this.nacimiento) >= 18) {
            this.nacimiento = nacimiento;
        }else{
            this.nacimiento = LocalDate.of(1999, 3, 8);
        }
        
    }

    public boolean isEleccion() {
        return eleccion;
    }

    public void setEleccion(boolean eleccion) {
        
            this.eleccion = eleccion;
        
    }

    public int getEdad() {
        return Utilidades.calcularYear(this.nacimiento);
    }

    public int sacarDedos() {
        return Utilidades.intAleatorio(0, 10);
    }

}
