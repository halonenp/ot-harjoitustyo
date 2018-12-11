# Käyttöohje


## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla *java -jar Muistipeli-1.0-SNAPSHOT.jar*



## Pelaajien luominen
Sovellus käynnistyy näkymään, jossa ensimmäinen pelajaa syöttää nimensä. Painamalla Seuraava-painiketta pääsee seuraavanlaiseen näkymään.


<img width="238" alt="kayttoohje22" src="https://user-images.githubusercontent.com/39950699/49817151-2d236f80-fd78-11e8-9300-82a2c2b641cb.PNG">

Tässä näkymässä syötetään toisen pelaajan nimi sekä valitaan pelin vaikeusaste. Tyhjä nimikenttä asettaa pelaajille oletusnimet.
Vaikeusaste on oletusarvoisesti kohdassa "Helppo".

## Pelaaminen

Painamalla Pelaamaan!-painiketta siirrytään pelinäkymään.

<img width="310" alt="kayttoohje3" src="https://user-images.githubusercontent.com/39950699/49817113-11b86480-fd78-11e8-9aed-3e59f35172d6.PNG">

Painikkeet kuvaavat käännettäviä kortteja. Jos painikkeessa on kolme tähteä, niin sillon kortti on naamapuoli alaspäin eli piilossa.


Pelaajan tehtävänä on löytää painikkeista pareja. Painamalla painiketta, jossa on tähtiä, paljastuu teksti. Painamalla toista tähdellistä painiketta paljastuu toisen painikkeen teksti. Jos painikkeissa on sama teksti, niin pelaaja saa pisteen, muuten painikkeiden tekstit ovat näkyvillä sekuntin kunnes tekstit muuttuvat taas tähdiksi. Parin löydettäsessä pelaaja jatkaa vuoroaan, muuten vuoro vaihtuu. Peli loppuu kun kaikki parit ovat löydetty ja voittaja on eniten pisteitä omaava pelaaja. 


Näkymässä näkyy pelaajien pisteet, jotka alkavat nollasta. Nuoli osoittaa kumman pelaajan vuoro on sillä hetkellä. Peli alkaa ensimmäisen pelaajan vuorolla. Pelin loputtua näkymään tulee Uusi Peli! -painike, jota painamalla alkaa uusi peli.
