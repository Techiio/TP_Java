import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class testGame {
    @Test
    public void testPlay() throws IOException {
        Game game = new Game();
        Assert.assertEquals(1, game.playGame());
    }

    @Test
        public void testLambda() throws IOException {
            Assert.assertThrows(IndexOutOfBoundsException.class, () -> {
                List<Integer> ints = new LinkedList<>();
                ints.get(1);
            });
    }
}
