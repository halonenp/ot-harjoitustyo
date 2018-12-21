# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on muistipeli, jossa on kaksi pelaajaa vastakkain. Peliä pelataan 4, 5 tai 6:llä parilla. 

## Perusversion tarjoama toiminnallisuus
Sovellus koostuu kolmesta eri näkymästä: Pelaajien 1 ja 2 nimienasetus-näkymistä sekä pelinäkymästä.
### Ennen peliä 

* Pelaajat kirjoittavat nimensä
* Vaikeusaste valitaan
* Kortit sekoittuvat sattumanvaraisesti "naamapuoli" alaspäin

### Pelaaminen

* Pelaaja 1 aloittaa pelin 
* Nuoli osoittaa kumman vuoro on sillä hetkellä kyseessä
* Pelaaja kääntää kaksi korttia, jos korteissa on eri teksti, niin kortit kääntyvät takaisin. Vuoro vaihtuu toiselle pelaajalle 
* Jos käännetyissä korteissa on sama teksti, niin pelaaja saa parin itselleen. Pelaaja saa jatkaa vuoroaan
* Pelaajien pisteet näkyvät pelin aikana ja päivittyvät parin löydettäessä
* Kun kaikki parit ovat löydetty, peli ilmoittaa voittajan. Eniten pareja kerännyt pelaaja voittaa
* Pelin päätyttyä on mahdollisuus aloittaa uusi peli

### Tilastointi

* Pelaajien nimet, sekä pelaajien pelattujen ja voitettujen pelien lukumäärä tallentuu paikalliseen tekstitiedostoon

## Jatkokehitysideoita

* Aloittaja arvottaisiin
* Pelin voi asettaa esimerkiksi paras kolmesta -moodiin

