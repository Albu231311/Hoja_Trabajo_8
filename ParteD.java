import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ParteD {
//heap usando PriorityQueue
    public static void main(String[] args) {
        PriorityQueue<Proceso> colaProcesos = new PriorityQueue<>(Comparator.comparingInt(Proceso::getNice));

        // Leer procesos del archivo y agregar a la cola de prioridad
        try (BufferedReader br = new BufferedReader(new FileReader("procesos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datosProceso = line.split(",");
                if (datosProceso.length == 3) {
                    String nombreProceso = datosProceso[0];
                    String nombreUsuario = datosProceso[1];
                    int nice = Integer.parseInt(datosProceso[2]);
                    Proceso proceso = new Proceso(nombreProceso, nombreUsuario, nice);
                    colaProcesos.add(proceso);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Retirar y mostrar los procesos uno a uno en el orden de prioridad
        while (!colaProcesos.isEmpty()) {
            Proceso procesoAtendido = colaProcesos.poll();
            System.out.println("Proceso: " + procesoAtendido.getNombreProceso() +
                    ", Usuario: " + procesoAtendido.getNombreUsuario() +
                    ", Prioridad (PR): " + procesoAtendido.toString());
        }
    }
}
