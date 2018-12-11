# Arkkitehtuurikuvaus


## Käyttöliittymä

Käyttöliittymä sisältää kolme eri näkymää


* Ensimmäisen pelaajan nimen asetus
* Toisen pelaajan nimen asetus sekä vaikeusasteen valinta
* Pelinäkymä

Jokainen näistä on toteutettu omana Scene-oliona. Näkymistä yksi kerrallaan on näkyvänä eli sijoitettuna sovelluksen stageen. Käyttöliittymä on rakennettu ohjelmallisesti luokassa muistipeli.ui.UserInterface.

Käyttöliittymä on pyritty eristämään täysin sovelluslogiikasta.

Itse peli käynnistyy kun ui:sta kutsutaan metodia *board*, joka päivittää peliä reaaliaikaisesti aina käyttäjän klikkauksien mukaan.


## Sovelluslogiikka

Pakkaus muistipeli.ui sisätlää JavaFX:llä toteutetun käyttöliittymän, muistipeli.logics pelin sovelluslogiikan ja muistipeli.players pelaajien sovelluslogiikan.

Pelin yleisimmistä tapahtumista vastaa Game-luokan metodit:

* checkIfPairs
* turnBack
* checkGameOver

Sovelluksen loogisen datamallin muodostavat luokat Game ja Players, jotka kuvaavat peliä ja pelaajia tehtäviä:
 
Luokka- ja pakkauskaavio
<img width="173" alt="jokony" src="https://user-images.githubusercontent.com/39950699/49819101-35ca7480-fd7d-11e8-888e-c8cda185eab5.PNG">

## Päätoiminnallisuudet

* Pelaajan luominen
* Pelilaudan luominen
* Kortin kääntö ja on löytynyt pari


Sekä sekvenssikaavio tapahtumasta missä ollaan edetty aloitusnäkymistä itse peliin, jossa pelaaja valitsee kaksi "korttia". Kyseiset kortit eivät olleet pari. Näin ollen peli kääntää ne takaisin piiloon.
![vko5 sekvenssikaavio](https://user-images.githubusercontent.com/39950699/49472401-03b69100-f818-11e8-9094-e5e5b83e4c13.jpg)
