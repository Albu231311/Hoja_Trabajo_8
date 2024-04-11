import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class ParteDTest {

    @Test
    public void testParteD() {
        // Datos de prueba simulando una entrada de texto
        String input = "vi,juan02,0\n" +
                       "ls,maria30,-20\n" +
                       "firefox,rosa20,5\n" +
                       "cat,juan02,5\n";

        // Establecer este input como el System.in
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capturar la salida estándar para verificarla
        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(System.out) {
            public void println(String msg) {
                output.append(msg).append("\n");
            }
        });

        // Ejecutar el método main
        ParteD.main(new String[0]);

        // Verificar la salida esperada
        String expectedOutput = "Proceso: ls, Usuario: maria30, Prioridad (PR): ls,maria30,PR=80\n" +
                                "Proceso: vi, Usuario: juan02, Prioridad (PR): vi,juan02,PR=100\n" +
                                "Proceso: cat, Usuario: juan02, Prioridad (PR): cat,juan02,PR=105\n" +
                                "Proceso: firefox, Usuario: rosa20, Prioridad (PR): firefox,rosa20,PR=125\n";
        assertEquals(expectedOutput, output.toString());
    }
}
