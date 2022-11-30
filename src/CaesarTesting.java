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
        assertEquals("WHVWLQJ", cs.encrypt("Testing", "3"));
    }

    @Test
    public void testDecrypt() {
        assertEquals("TESTING", cs.decrypt("WHVWLQJ", "3"));
    }
}
