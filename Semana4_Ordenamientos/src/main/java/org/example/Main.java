package org.example;

import javax.swing.*;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] numeros = new int[100];
        Random rand = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(100);
        }

        System.out.println("Lista desordenada: ");
        for (int num: numeros){
            System.out.print(num + " ");
        }

        long inicioBurbua = System.nanoTime();

        // Ordednamento burbuja
        // Valentina Entender el algoritmo
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }


        long finBurbua = System.nanoTime();
        long duracionBurbuja = finBurbua - inicioBurbua;
        System.out.println("\nTiempo de ejecucion ordenamiento burbuja: " + duracionBurbuja + " nanosegundos");

        //Ordenamiento por seleccion
        // Copiamos el arreglo original para no mezclar con el ordenamiento burbuja
        int[] numerosSeleccion = new int[numeros.length];
        System.arraycopy(numeros, 0, numerosSeleccion, 0, numeros.length);

        long inicioSeleccion = System.nanoTime();
        // Valentina Entender el algoritmo
        for (int i = 0; i < numerosSeleccion.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < numerosSeleccion.length; j++) {
                if (numerosSeleccion[j] < numerosSeleccion[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = numerosSeleccion[minIdx];
            numerosSeleccion[minIdx] = numerosSeleccion[i];
            numerosSeleccion[i] = temp;
        }
        long finSeleccion = System.nanoTime();
        long duracionSeleccion = finSeleccion - inicioSeleccion;
        System.out.println("\nTiempo de ejecucion ordenamiento seleccion: " + duracionSeleccion + " nanosegundos");

        //Ordenamiento por inserción
        int[] numerosInsercion = new int[numeros.length];
        System.arraycopy(numeros, 0, numerosInsercion, 0, numeros.length);
        long inicioInsercion = System.nanoTime();
        // Valentina Entender el algoritmo
        for (int i = 1; i < numerosInsercion.length; i++) {
            int key = numerosInsercion[i];
            int j = i - 1;
            while (j >= 0 && numerosInsercion[j] > key) {
                numerosInsercion[j + 1] = numerosInsercion[j];
                j--;
            }
            numerosInsercion[j + 1] = key;
        }
        long finInsercion = System.nanoTime();
        long duracionInsercion = finInsercion - inicioInsercion;
        System.out.println("\nTiempo de ejecucion ordenamiento insercion: " + duracionInsercion + " nanosegundos");
        System.out.println("Arreglo ordenado por insercion:");
        for (int num : numerosInsercion) {
            System.out.print(num + " ");
        }

    }
}
