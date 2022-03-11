import org.junit.Assert;
import org.junit.Test;

public class Mage extends Hero {
    public static class testGame {
        @Test
        public void testPlay(){
            Game game = new Game();
            Assert.assertEquals(1, game.playGame());
        }
    }
}
