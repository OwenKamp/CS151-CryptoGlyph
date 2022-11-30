import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CaesarTesting {

    @Test
    public void testEncrypt() {
        assertEquals("WHVWLQJ", Caesar.encrypt("Testing", "3"));
    }

    @Test
    public void testDecrypt() {
        assertEquals("TESTING", Caesar.decrypt("WHVWLQJ", "3"));
    }
}
