# Testausdokumentti

Ohjelmaa on testattu JUnitilla sekä manuaalisesti järjestelmässä.

## JUnit-testit

### Sovelluslogiikka

Testien suurin osuus koostuu sovelluksen logiikan testauksesta. Pakkauksen muistipeli.logics
luokkaa testaa luokka LogicsTest.
LogicsTest määrittelee testitapauksia, jotka muistuttavat pelin Game-olion oikeita toimintoja, mitkä tapahtuvat käyttöliittymässä.

Kaikkia Game-luokan metodeita ei ole onnistuttu testaamaan. Metodit jotka ottavat parametrikseen Buttonin tai Labelin jäivät testaamatta, koska 
niiden initialisoinnista aiheutuvaa virhettä ei onnistuttu ratkaisemaan.

Sovelluksessa Players-olioiden logiikkaa testaa PlayersTest. PlayersTestin määrittelemät testitapaukset kuvaavat käyttöliittymän Players-olion toimintaa kuin se toimisi käyttöliittymässä.

### DAO-luokka

JUnitin TemporaryFolder-ruleja eli tilapäistä tiedostoa, on käytetty  DAO-luokan on testaamisessa.
### Testauskattavuus

Käyttöliittymä poislukien sovelluksen testauksen rivikattavuus on 73% ja haarautumakattavuus 76%


<img width="752" alt="testikattavuuskuva" src="https://user-images.githubusercontent.com/39950699/50350176-f521e680-0546-11e9-983e-ebbb71794297.PNG">

## Järjestelmätestaus

Järjestelmätestaus on tehty manuaalisesti.

### Asennus ja konfigurointi

Sovellus on ladattu ja sitä on testattu Windows-ympäristössä siten,
että sovelluksen hakemistossa on ja ei ole ollut tilastointiin käytettävää statistics.txt-tiedostoa.


### Toiminnallisuus

Kaikki mitä [määrittelydokumentissa](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md) ja [käyttöohjeessa](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Kayttoohje.md) listataan, on huomioitu. 
. 
Syötekenttiä on testattu tyhjillä sekä virheellisillä arvoilla. Pelin virheellisä kortin kääntöjä on testattu.
