import org.junit.Test;
import org.junit.Assert;

public class TestGame {
    @Test
    public void testPlay(){
        Game game = new Game();
        Assert.assertEquals(1, game.playGame());
    }
}
