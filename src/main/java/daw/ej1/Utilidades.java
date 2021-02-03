/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ej1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author NitroPc
 */
public class Utilidades {

    //Atributos de clase privados
    private static Scanner teclado = new Scanner(System.in);
    private static Random aleatorio = new Random();

    public static int intAleatorio(int min, int max) {

        return aleatorio.nextInt(max - min + 1) + min;
    }

    //Metodos de clase
    public static int leerEnteroRango(int min, int max) {
        int numero = 0;

        do {
            System.out.println("Introduce un número");
            try {
                numero = teclado.nextInt();
            } catch (InputMismatchException e) {//control de excepciones
                numero = min - 1;
                teclado.nextLine();//Limpiar el buffer
            }
        } while (numero < min || numero > max);//control de salida, el while esta bien

        return numero;
    }

    public static int calcularYear(LocalDate fecha) {
        LocalDate fechaActual = LocalDate.now();

        if (fecha.isAfter(fechaActual)) {
            return -1;
        }
        return (int) ChronoUnit.YEARS.between(fecha, fechaActual);

    }
}
