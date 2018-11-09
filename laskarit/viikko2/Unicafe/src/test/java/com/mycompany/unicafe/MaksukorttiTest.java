package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void alussaSaldoOikein() {
        assertEquals(kortti.saldo(), 10);
    }

    @Test
    public void kasvattaaSaldoa() {
        kortti.lataaRahaa(10);
        assertEquals(kortti.saldo(), 20);
    }

    @Test
    public void kortiltaVoiOttaaRahaaJosSaldoRittaa() {
        assertEquals("Jos kortilla raha riittää, pitäisi otaRahaa-metodin palauttaa true. Tarkasta koodi: \n"
                + "k = new Maksukortti(10); k.otaRahaa(8);", true, kortti.otaRahaa(8));
        assertEquals("Kortin saldon pitäisi vähetä kun rahaa otetaan. Tarkasta koodi: "
                + "k = new Maksukortti(10); k.otaRahaa(8);", 2, kortti.saldo(), 0.01);
    }

    @Test
    public void kortinVoiTyhjentaa() {
        assertEquals("Kortilta pitäisi pystyä ottamaan kaikki rahat. Tarkasta koodi: "
                + "k = new Maksukortti(10); k.otaRahaa(10);", true, kortti.otaRahaa(10));
        assertEquals("Kortilta pitäisi pystyä ottamaan kaikki rahat. Tarkasta koodi: "
                + "k = new Maksukortti(10); k.otaRahaa(10);", 0, kortti.saldo(), 0.01);
    }

    @Test
    public void eiMeneMiinukselle() {
        kortti.otaRahaa(12);
        assertEquals(kortti.saldo(), 10);
    }

}
