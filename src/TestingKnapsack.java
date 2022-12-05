import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestingKnapsack {
    private static Knapsack k;

    @BeforeAll
    public static void init(){
        k = new Knapsack();
    }
    @Test
    public void testEncrypt(){
        assertEquals(k.encrypt("david","82,123,287,83,248,373,10,471"),"783,881,876,1129,783");
    }

    @Test
    public void testDecrypt(){
        assertEquals(k.decrypt("783,881,876,1129,783","2,3,7,14,30,57,120,251,41,491"),"david");
    }
}
