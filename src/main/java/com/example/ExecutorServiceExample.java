package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Crear un ExecutorService con un número fijo de hilos (por ejemplo, 3 hilos)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Crear tareas Runnable
        Runnable task1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Tarea 1: " + i);
                try {
                    Thread.sleep(1000); // Pausa de 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Tarea 2: " + i);
                try {
                    Thread.sleep(1000); // Pausa de 1 segundo
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Enviar las tareas al ExecutorService
        executor.submit(task1);
        executor.submit(task2);

        // Apagar el ExecutorService de manera ordenada (una vez que se completen todas las tareas)
        executor.shutdown();
    }
}

