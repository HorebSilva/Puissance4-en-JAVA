import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class niveauDifficileTest {

    @Test
    void choisirColonneVerticale() {
        assertEquals(-5,niveauDifficile.choisirColonneVerticale(-5));
        assertEquals(0,niveauDifficile.choisirColonneVerticale(0));
        assertEquals(3,niveauDifficile.choisirColonneVerticale(3));
        assertEquals(6,niveauDifficile.choisirColonneVerticale(6));
    }

    @Test
    void choisirColonneHorizontaleAdroite() {
        assertEquals(0,niveauDifficile.choisirColonneHorizontaleAdroite(-1));
        assertEquals(1,niveauDifficile.choisirColonneHorizontaleAdroite(0));
        assertEquals(4,niveauDifficile.choisirColonneHorizontaleAdroite(3));
        assertEquals(0,niveauDifficile.choisirColonneHorizontaleAdroite(6));
    }

    @Test
    void choisirColonneHorizontaleAgauche() {
        assertEquals(-2,niveauDifficile.choisirColonneHorizontaleAgauche(-1));
        assertEquals(6,niveauDifficile.choisirColonneHorizontaleAgauche(0));
        assertEquals(2,niveauDifficile.choisirColonneHorizontaleAgauche(3));
        assertEquals(5,niveauDifficile.choisirColonneHorizontaleAgauche(6));
    }
}
