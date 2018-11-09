/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author halon
 */
public class KassapaateTest {

    public KassapaateTest() {
    }
    Kassapaate kassa;
    Maksukortti kortti;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(600);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void oikeatMääräAluksi() {
        assertEquals(kassa.kassassaRahaa(), 100000);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 0);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
    }

    @Test
    public void syoEdullisestiVeloittaaOikeinJaKasvattaaMyyntia() {
        kassa.syoEdullisesti(300);
        assertEquals(kassa.kassassaRahaa(), 100240);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 1);
    }

    @Test
    public void syoMaukkaaastiVeloittaaOikeinJaKasvattaaMyyntia() {
        kassa.syoMaukkaasti(600);
        assertEquals(kassa.kassassaRahaa(), 100400);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
    }

    @Test
    public void syoEdullisestiMaksuEiRiita() {
        kassa.syoEdullisesti(100);
        assertEquals(kassa.kassassaRahaa(), 100000);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 0);
    }

    @Test
    public void syoMaukkaaastiMaksuEiRiita() {
        kassa.syoMaukkaasti(100);
        assertEquals(kassa.kassassaRahaa(), 100000);
        assertEquals(kassa.maukkaitaLounaitaMyyty(), 0);
    }

    @Test
    public void syoMaukkaastiKortiltaVeloittaaOikeinJaKasvattaaMyyntia() {
        kassa.syoMaukkaasti(kortti);

        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kortti.saldo(), 200);
    }

    @Test
    public void syoEdullisestiKortiltaVeloittaaOikeinJaKasvattaaMyyntia() {
        kassa.syoEdullisesti(kortti);

        assertEquals(kassa.edullisiaLounaitaMyyty(), 1);
        assertEquals(kortti.saldo(), 360);
    }

    @Test
    public void syoMaukkaastiKortillaEiRahaa() {
        kassa.syoMaukkaasti(kortti);
        kassa.syoMaukkaasti(kortti);

        assertEquals(kassa.maukkaitaLounaitaMyyty(), 1);
        assertEquals(kortti.saldo(), 200);
    }

    @Test
    public void syoEdullisestiKortillaEiRahaa() {
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        kassa.syoEdullisesti(kortti);
        assertEquals(kassa.edullisiaLounaitaMyyty(), 2);
        assertEquals(kortti.saldo(), 120);
    }

    @Test
    public void korttiEiMuutaKassaa() {
        kassa.syoEdullisesti(kortti);
        assertEquals(kassa.kassassaRahaa(), 100000);
    }

    @Test
    public void kortilleRahaaJaKassaKasvaa() {
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(kassa.kassassaRahaa(), 100500);
        assertEquals(kortti.saldo(), 1100);
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
