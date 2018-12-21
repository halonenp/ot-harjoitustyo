# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla sekä manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Automatisoitujen testien ytimen moudostaa sovelluslogiikkaa, eli pakkauksen muistipeli.logics
luokkaa testaa integraatiotesti LogicsTest.
LogicsTestin määrittelevät testitapaukset simuloivat käyttöliittymän Game-olion avulla suorittamia toiminnallisuuksia.

Kaikkia Game-luokan metodeita ei ole onnistuttu testaamaan. Metodit jotka ottavat parametrikseen Buttonin tai Labelin jäivät testaamatta, koska 
niiden initialisoinnista aiheutuvaa virhettä ei onnistuttu ratkaisemaan.

Sovelluksessa Players-olioiden logiikkaa testaa PlayersTest. PlayersTestin määrittelemät testitapaukset simuloivat käyttöliittymän Players-olion avulla 
suorittamia toiminnallisuuksia.

### DAO-luokka

DAO-luokan toiminnallisuus on testattu luomalla testeissä tilapäinen tiedosto hyödyntäen JUnitin TemporaryFolder-ruleja.

### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 73% ja haarautumakattavuus 76%


<img width="752" alt="testikattavuuskuva" src="https://user-images.githubusercontent.com/39950699/50350176-f521e680-0546-11e9-983e-ebbb71794297.PNG">

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on haettu ja sitä on testattu käyttöohjeen kuvaamalla tavalla Windows-ympäristössä siten,
että sovelluksen käynnistyshakemistossa on ollut käyttöohjeen kuvauksen mukainen config.properties-tiedosto.

Sovellusta on testattu sekä tilanteissa, joissa käyttäjät ja
työt tallettavat tiedostot ovat olleet olemassa ja joissa niitä ei ole ollut jolloin ohjelma on luonut ne itse.

### Toiminnallisuus

Kaikki [määrittelydokumentin](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md) ja [käyttöohjeen](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Kayttoohje.md)
listaamat toiminnallisuudet on käyty läpi. 
Kaikkien toiminnallisuuksien yhteydessä on syötekentät yritetty täyttää myös virheellisillä arvoilla kuten tyhjillä.
