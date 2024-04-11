import org.junit.Test;
import static org.junit.Assert.*;

public class ProcesoTest {

    @Test
    public void testGetNombreProceso() {
        Proceso proceso = new Proceso("ls", "maria30", -20);
        assertEquals("ls", proceso.getNombreProceso());
    }

    @Test
    public void testGetNombreUsuario() {
        Proceso proceso = new Proceso("ls", "maria30", -20);
        assertEquals("maria30", proceso.getNombreUsuario());
    }

    @Test
    public void testGetNice() {
        Proceso proceso = new Proceso("ls", "maria30", -20);
        assertEquals(-20, proceso.getNice());
    }

    @Test
    public void testToString() {
        Proceso proceso = new Proceso("ls", "maria30", -20);
        assertEquals("ls,maria30,PR=100", proceso.toString());
    }

    @Test
    public void testNiceRange() {
        Proceso proceso1 = new Proceso("ls", "maria30", -20);
        Proceso proceso2 = new Proceso("cat", "juan02", 10);
        Proceso proceso3 = new Proceso("firefox", "rosa20", 19);

        assertEquals(100, proceso1.getNice());
        assertEquals(119, proceso2.getNice());
        assertEquals(138, proceso3.getNice());
    }
}
