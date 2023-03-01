import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class jouer1vs1Test {

    @Test
    void testStringEgal() {
        assertTrue(jouer1vs1.stringEgal("HOREB", "horeb"));
        assertTrue(jouer1vs1.stringEgal("Marouane", "marouane"));
        assertTrue(jouer1vs1.stringEgal("HOREB", "HOREB"));
        assertTrue(jouer1vs1.stringEgal("marouane", "marouane"));
        assertFalse(jouer1vs1.stringEgal("salut", "saltu"));
        assertFalse(jouer1vs1.stringEgal("arouane", "marouane"));
        assertFalse(jouer1vs1.stringEgal("Marouane", "Horeb"));
    }

    @Test
    void testestGagnant() {
        char[][] horizontale = {{'.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.'},
                                {'J', 'J', 'J', '.', '.', '.', '.'},
                                {'R', 'R','R', 'R', '.', '.', '.'}};

        assertTrue(jouer1vs1.estGagnant('R', horizontale));
        assertFalse(jouer1vs1.estGagnant('J', horizontale));

        char[][] verticale = {{'J', '.', '.', '.', '.', '.', '.'},
                              {'J', '.', '.', '.', '.', '.', '.'},
                              {'J', '.', '.', '.', '.', '.', '.'},
                              {'J', '.', 'R', '.', '.', '.', '.'},
                              {'R', '.', 'R', '.', '.', '.', '.'},
                              {'R', '.', 'R', '.', '.', '.', '.'}};

        assertTrue(jouer1vs1.estGagnant('J', verticale));
        assertFalse(jouer1vs1.estGagnant('R', verticale));


        char[][] diag_asc  = {{'.', '.', '.', '.', '.', '.', '.'},
                              {'.', '.', '.', '.', '.', '.', '.'},
                              {'.', '.', 'R', 'J', 'R', '.', '.'},
                              {'.', '.', 'J', 'J', 'R', '.', '.'},
                              {'.', 'J', 'R', 'R', 'J', 'R', '.'},
                              {'J', 'J', 'R', 'R', 'J', 'J', 'R'}};

        assertTrue(jouer1vs1.estGagnant('J',diag_asc ));
        assertFalse(jouer1vs1.estGagnant('R',diag_asc ));

        char[][] diag_desc  = {{'.', '.', '.', '.', '.', '.', '.'},
                               {'.', 'J', '.', '.', '.', '.', '.'},
                               {'.', 'J', 'J', 'J', '.', '.', '.'},
                               {'.', 'R', 'R', 'J', '.', '.', '.'},
                               {'.', 'R', 'J', 'R', 'J', '.', '.'},
                               {'R', 'R', 'R', 'J', 'R', '.', '.'}};

        assertTrue(jouer1vs1.estGagnant('J',diag_desc));
        assertFalse(jouer1vs1.estGagnant('R',diag_desc));

    }

    @Test
    void testintialisationPlateau(){
        char[][] test = jouer1vs1.initialisationPlateau();
        char[][] plateau = {{'.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.', '.', '.', '.', '.', '.'},
                            {'.', '.','.', '.', '.', '.', '.'}};
        assertArrayEquals(plateau,test);
    }


}
