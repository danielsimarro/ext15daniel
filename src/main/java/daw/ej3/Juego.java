/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ej3;

import daw.ej1.Utilidades;
import daw.ej2.Jugador;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author NitroPc
 */
public class Juego {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        final int k = 5;

        Jugador jugador = new Jugador(leerNom(), leerApe(), LocalDate.of(year(), mes(), dia()), eleccion());

        System.out.println(jugador);

        int rondas[] = new int[k];

        int contadorJugador = 0;
        int resultadoJugador;
        int contadorMaquina = 0;
        int resultadoMaquina;

        char informar[] = new char[k];

        for (int i = 0; i < rondas.length; i++) {
            resultadoJugador = jugador.sacarDedos();
            System.out.println("El resultado de la ronda " + (i + 1) + " del judagor es de: " + resultadoJugador);
            resultadoMaquina = sacarDedosMaquina();
            System.out.println("El resultado de la ronda " + (i + 1) + " de la maquina es de: " + resultadoMaquina);

            if (resultadoJugador > resultadoMaquina) {
                informar[i] = 'j';
                contadorJugador++;
                System.out.println("El ganador en esta ronda es el jugador");
            } else {
                informar[i] = 'M';
                contadorMaquina++;
                System.out.println("El ganador en esta ronda es la maquina");
            }

        }

        System.out.println("Las rondas ganadas por el jugador son: " + contadorJugador);

        for (int i = 0; i < informar.length; i++) {
            System.out.println("El ganador de la ronda " + (i + 1) + " es: " + informar[i]);
        }

        if (contadorJugador > contadorMaquina) {
            System.out.println("El ganador es el jugador");
        } else if (contadorJugador == contadorMaquina) {
            System.out.println("Hay un empate");
        } else if (contadorJugador < contadorMaquina) {
            System.out.println("El jugador ha perdido");
        }

        System.out.println(jugador);

    }

    public static String leerNom() {

        System.out.println("Introduce el nombre:");
        String nombre = teclado.nextLine();
        return nombre;
    }

    public static String leerApe() {

        System.out.println("Introduce el apellido:");
        String nombre = teclado.nextLine();
        return nombre;
    }

    public static int dia() {

        System.out.println("Introduce el dia");
        return Utilidades.leerEnteroRango(1, 31);
    }

    public static int mes() {

        System.out.println("Introduce el mes");
        return Utilidades.leerEnteroRango(1, 12);

    }

    public static int year() {

        System.out.println("Introduce el año");
        return Utilidades.leerEnteroRango(1900, LocalDate.now().getYear());

    }

    public static boolean eleccion() {

        String elec;
        System.out.println("Introduce pare o none");
        do {
            elec = teclado.nextLine();
        } while (!elec.equals("pare") || !elec.equals("none"));

        if (elec.equals("pare")) {  
            return true;
        } else {
            return false;
        }

    }

    public static int sacarDedosMaquina() {
        return Utilidades.intAleatorio(0, 10);
    }
    
    
}
