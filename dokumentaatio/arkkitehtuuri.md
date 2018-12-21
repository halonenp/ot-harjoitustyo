# Arkkitehtuurikuvaus

## Rakenne
Ohjelma on toteutettu neljässä pakkauksessa. 
Pakkauskaavio:


![pakkauskaavio](https://user-images.githubusercontent.com/39950699/50365190-12bd7300-057c-11e9-810e-50e51359cef0.PNG)


JavaFX:llä toteutettu käyttöliittymä on pakkauksessa muistipeli.ui, jossa on myös ohjelman käynnistävä Main-luokka. Pelin logiikka on pakkauksessa muistipeli.logics ja Players-olioiden logiikka pakkauksessa muistipeli.players. Muistipeli.daossa kaikki tallentamiseen liittyvä toiminta.


## Käyttöliittymä

Käyttöliittymä sisältää kolme eri näkymää


* Ensimmäisen pelaajan nimen asetus
* Toisen pelaajan nimen asetus sekä vaikeusasteen valinta
* Pelinäkymä

Näkymät ovat Scene-olioita. Sovelluksen Stagessa on näistä aina yksi kerrallaan näkyvissä. Käyttäjälle näkyvä käyttöliittymä on luokassa muistipeli.ui.UserInterface.

Käyttöliittymää on yritetty pitää erossa sovelluslogiikasta.

Itse peli käynnistyy kun ui:sta kutsutaan metodia *board*, joka päivittää peliä reaaliaikaisesti aina käyttäjän klikkauksien mukaan.


## Sovelluslogiikka

Pelin yleisimmistä tapahtumista vastaa Game-luokan metodit:

* checkIfPairs
* turnBack
* checkGameOver
* addPlayer

Tietojen tallennuksesta vastaavat luokat StatisticsDao ja FileStatisticsDao, joita käytetään rajapintojen kautta.

Luokka/pakkauskaavio:
![luokpakkaav](https://user-images.githubusercontent.com/39950699/50365182-0a653800-057c-11e9-809b-c325d1437f18.PNG)

## Tietojen pysyväistallennus
StatisticsDao ja FileStatisticsDao -luokat ovat vastuussa tietojen tallennuksesta. Tallennus tapahtuu paikalliseen tekstitiedostoon statistics.txt. Tämä tapahtuu Data Access Object -mallilla. Tiedostoon tallentuu aina yhdelle riville *pelaajan nimi,pelattujen pelien määrä,voitettujen pelien määrä*. Esimerkiksi Matti,5,3


## Päätoiminnallisuudet

* Pelaajan luominen
* Pelilaudan luominen
* Kortin kääntö ja on löytynyt pari
* Pelaajien nimien tallentaminen tekstitiedostoon


Sekä sekvenssikaavio tapahtumasta missä ollaan edetty aloitusnäkymistä itse peliin, jossa pelaaja valitsee kaksi "korttia". Kyseiset kortit eivät olleet pari. Näin ollen peli kääntää ne takaisin piiloon.
![vko5 sekvenssikaavio](https://user-images.githubusercontent.com/39950699/49472401-03b69100-f818-11e8-9094-e5e5b83e4c13.jpg)


