# Ohjelmistotekniikka, harjoitustyö, Muistipeli

Sovellus on muistipeli, jossa kaksi pelaajaa pelaavat vastaikkain.

## Dokumentaatio

[Työaikakirjanpito](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Ty%C3%B6aikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md)

[Arkkitehtuuri](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Kayttoohje.md)

[Testausdokumentti](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Release 1](https://github.com/halonenp/ot-harjoitustyo/releases/tag/Viikko5)

[Release 2](https://github.com/halonenp/ot-harjoitustyo/releases/tag/Viikko6)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla *mvn test*

Testikattavuusraportti luodaan komennolla *mvn jacoco:report*

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html

### Suoritettavan jarin generointi

Tapahtuu komennolla *mvn package*

generoi hakemistoon target suoritettavan jar-tiedoston Muistipeli-1.0-SNAPSHOT.jar

### Checkstyle

Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla *mvn jxr:jxr checkstyle:checkstyle*

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html

### JavaDoc

JavaDoc generoidaan komennolla *mvn javadoc:javadoc*

JavaDocia voi tarkastella avaamalla selaimella tiedosto target/site/apidocs/index.html




