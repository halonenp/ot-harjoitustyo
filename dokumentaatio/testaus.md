# Testausdokumentti

Ohjelmaa on testattu JUnitilla sekä manuaalisesti järjestelmässä.

## JUnit-testit

### Sovelluslogiikka

Testien suurin osuus koostuu sovelluksen logiikan testauksesta. Pakkauksen muistipeli.logics
luokkaa testaa luokka LogicsTest.
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

Sovellus on ladattu ja sitä on testattu Windows-ympäristössä siten,
että sovelluksen hakemistossa on ja ei ole ollut tilastointiin käytettävää statistics.txt-tiedostoa.


### Toiminnallisuus

Kaikki [määrittelydokumentin](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md) ja [käyttöohjeen](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Kayttoohje.md)
listaamat toiminnallisuudet on käyty läpi. 
Syötekenttiä on testattu tyhjillä sekä virheellisillä arvoilla. Peliä pelatessa on testattu virheellisä kortin kääntöjä.
