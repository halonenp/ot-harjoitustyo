# Ohjelmistotekniikka, harjoitustyö, Muistipeli

Sovellus on muistipeli, jossa kaksi pelaajaa pelaavat vastaikkain.

## Dokumentaatio

[Työaikakirjanpito](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Ty%C3%B6aikakirjanpito.md)

[Vaatimusmäärittely](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Vaatimusm%C3%A4%C3%A4rittely.md)

[Arkkitehtuuri](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/Kayttoohje.md)

[Testausdokumentti](https://github.com/halonenp/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

## Releaset

[Release 1](https://github.com/halonenp/ot-harjoitustyo/releases/tag/Viikko5)

[Release 2](https://github.com/halonenp/ot-harjoitustyo/releases/tag/Viikko6)

[Loppupalautus](https://github.com/halonenp/ot-harjoitustyo/releases/tag/vko7)

## Komentorivitoiminnot

### Testaus

Testit voi suorittaa komennolla *mvn test*

Testikattavuusraportti luodaan komennolla *mvn jacoco:report*

Kattavuusraporttia voi tutkia selaimella, jos avaa tiedoston target/site/jacoco/index.html

### Suoritettavan jarin generointi

Tapahtuu komennolla *mvn package*

Suoritettavan jar-tiedoston saa luotua hakemistoon target, komennolla Muistipeli-1.0-SNAPSHOT.jar

### Checkstyle

Tiedostoon checkstyle.xml määrittelemät tarkistukset suoritetaan komennolla *mvn jxr:jxr checkstyle:checkstyle*

Checkstylen virheilmoitukset voi nähdä selaimella avaamalla tiedoston target/site/checkstyle.html

### JavaDoc

JavaDoc generoidaan komennolla *mvn javadoc:javadoc*

JavaDocin voi nähdä avaamalla selaimella tiedoston target/site/apidocs/index.html




