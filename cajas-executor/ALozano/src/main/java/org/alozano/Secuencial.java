package org.alozano;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Secuencial {

    public static void cajeraSecuencial(int numeroClientes){
        System.out.println("-----------------------INICIA PROGRAMA DE FORMA SECUENCIAL----------------------------");
        long init = System.currentTimeMillis();  // Instante inicial del procesamiento

        //Lista clientes
        ArrayList<Cliente> clientes = new ArrayList<>(numeroClientes);
        for (int i = 0; i < numeroClientes; i++) {
            clientes.add(new Cliente(i + 1));
        }

        for (Cliente cliente : clientes) {
            Runnable cajera = new Cajera(cliente, init);
            cajera.run();       //Se ejecuta el método run y se quita el executor Al ser secuencial solo se necestia un hilo
        }

        long fin = System.currentTimeMillis();    // Instante final del procesamiento
        //Tiempo total
        System.out.println("Tiempo total de procesamiento: " + (fin - init) / 1000 + " Segundos");
        System.out.println("-----------------------FINALIZA PROGRAMA DE FORMA SECUENCIAL----------------------------");
    }
}
