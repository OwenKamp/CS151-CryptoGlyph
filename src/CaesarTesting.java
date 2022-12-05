import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTesting {
    private static Caesar cs;

    @BeforeAll
    public static void initialize() {
        cs = new Caesar();
    }

    @Test
    public void testEncrypt() {
        assertEquals("Whvwlqj", cs.encrypt("Testing", "3"));
    }

    @Test
    public void testDecrypt() {
        assertEquals("Testing", cs.decrypt("Whvwlqj", "3"));
    }
}
