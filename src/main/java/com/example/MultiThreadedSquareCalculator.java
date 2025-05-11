package com.example;

import java.util.*;
import java.util.concurrent.*;


//EJEMPLO PRACTICO

public class MultiThreadedSquareCalculator {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Crear una lista de números para procesar
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Crear un ExecutorService con un ThreadPool de tamaño 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Lista de objetos Future para almacenar los resultados
        List<Future<Integer>> results = new ArrayList<>();

        // Dividir las tareas (calcular el cuadrado de cada número) y enviarlas al ExecutorService
        for (int number : numbers) {
            Callable<Integer> task = () -> {
                // Calcular el cuadrado del número
                int result = number * number;
                System.out.println("El cuadrado de " + number + " es: " + result);
                return result;
            };
            results.add(executor.submit(task)); // Enviar la tarea y almacenar el resultado
        }

        // Obtener los resultados de las tareas
        int totalSum = 0;
        for (Future<Integer> future : results) {
            totalSum += future.get();  // Obtiene el resultado del cálculo del cuadrado
        }

        System.out.println("La suma de todos los cuadrados es: " + totalSum);

        // Apagar el ExecutorService
        executor.shutdown();
    }
}
