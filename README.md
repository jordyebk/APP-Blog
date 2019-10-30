# APP Blog - Scala

## Motivatie en introductie

Dit is de tweede keer dat ik een Blog moet schrijven om mij te verdiepen in een programmeertaal. 
Omdat ik mijn eerste poging niet met een voldoende heb afgerond heb ik er deze keer voor gekozen
om te beginnen met een frisse start. De vorige keer ben ik bezig geweest met Clojure. Deze keer heb ik
er voor gekozen om bezig te gaan met Scala. 

Het kennis maken met Scala doe ik door gebruik te maken van het boek 7 Languages in 7 Days.
![alt text](https://images-na.ssl-images-amazon.com/images/I/51LZT%2BtSrTL._SX415_BO1,204,203,200_.jpg "7 languages in 7 days")

In dit boek maak je kennis met een aantal verschillende talen. Ik zal alleen het hoofdstuk over
Scala volgen. In dit hoofdstuk maak je in drie dagen kennis met Scala door middel van voorbeelden
en opdrachten. Mijn resultaten van de drie dagen zullen in deze Blog te vinden zijn.

Na het kennis maken met Scala zal ik werken aan een eindopdracht.
Deze eindopdracht moet laten zien dat ik mij heb kunnen verdiepen in de programmeertaal. 
De opdracht waar ik aan wil werken is een WebScraper.
In mijn vrije tijd stop ik veel uren in een MMORPG genaamd Oldschool Runescape (OSRS).
OSRS is een spel wat gericht is op progressie. Er is een groot aantal 'Skills' die je kan
trainen. Deze skills zitten gekoppeld aan je accountnaam en kunnen ingezien worden op
hun highscores website: [Link](https://secure.runescape.com/m=hiscore_oldschool/overall.ws).
Het idee is dat je een aantal accountnamen op kan geven. Aan de hand van deze accountnamen
worden de highscores opgehaald. Om te kijken welke 'Skills' gemiddeld het laagste zijn
worden alle levels per accountnaam opgehaald. Per skill wordt een gemiddelde gegeven.

Aan deze eindopdracht heb ik een aantal eisen gesteld:
* De opdracht moet volledig functioneel geprogrammeerd worden (In dien er 
uitzonderingen zijn worden deze benoemd).
* etc.etc.


## Kennis maken met Scala

### Installatie

Om te kunnen beginnen met een programmeertaal moet je meestal het een en ander installeren.
In het boek 7L7D wordt niet veel gezegd over deze installatie. Zelf ben ik via google bij de
volgende download gekomen: [Scala download](https://www.scala-lang.org/download/).
Op deze pagina word weergegeven dat je Scala ook kan downloaden via IntelliJ. Omdat ik
veel gebruik maak van IntelliJ, ik gebruik het nu zelfs om deze markdown te typen, heb
ik hier voor gekozen. Ik heb de pagina [Getting started with Scala in IntelliJ](https://docs.scala-lang.org/getting-started/intellij-track/getting-started-with-scala-in-intellij.html)
gevolgd. Het enige benodigde was het installeren van een Plugin. Na het installeren van
de Scala plugin kon ik een nieuw project aanmaken. Bij het aanmaken van mijn eerste Scala project
werd de Scala SDK geïnstalleerd.


### Dag 1

#### Types, Expressions en Conditions

De eerste dag van het kennis maken met Scala begint met een korte uitleg over Scala types.
Dit lijkt allemaal op hoe ik het gewend ben in Java. Echter zijn alle types in Scala een Object.
Het volgende stuk van de intro gaat over Expressions en Conditions. Hier word kort uitgelegd
hoe je een paar simpele true/false expressies maakt. Denk hier aan:
`5>6` en `5!=2`.
Ook worden er 2 variabelen assigned en worden deze in een if statement gebruikt.
Deze if statement ziet er hetzelfde uit als in Java.

```scala
val a = 1
val b = 2

if ( b < a ) {
 println("true")
} else {
 println("false")
}
```
Wat hier opvalt is dat je bij de variabele niet meegeeft wat deze moet zijn. Waar je bij
Java `int a = 1` had getypt typ je hier `val a = 1`. Scala bepaald dus zelf, op runtime,
wat deze variabele moet zijn. Ook word er weergegeven dat er 2 manieren zijn voor een declaratie.
De eerste is `val` en de tweede is `var`. `val` is immutable, `var` niet. Hier komen ze later op terug.

Waar je in andere talen 0/1 als true of false kan gebruiken als een boolean, of `Nil` als false,
is dit in Scala niet mogelijk. In een if-statement moet dus echt een vergelijking staan.

#### Loops

Waar ik bij de vorige twee onderdelen alleen in de console heb gewerkt ga ik dit nu runnen als 
script. Dit word aangeraden omdat de volgende programmas iets complexer zijn. Omdat we bij
dag 2 bezig gaan met code blocks focussen we nu meer op de imperatieve style van Loops.

De eerste loop die we tegen komen is een simpele While loop. Deze ziet er als volgt uit.
```scala
def While {
  var i = 1
  while(i <= 3) {
    println(i)
    i += 1
  }
}
While
```
Omdat dit de eerste keer is dat we iets niet in de commandline uitvoeren maar een .scala bestand 
aanmaken voeg ik dit toe. De bovenstaande code heb ik neergezet in /Scala/src/While.scala.
Om dit uit te voeren typ ik het volgende in de commandline: `scala Scala/src/While.scala`.
Dit geeft het gewenste resultaat.

De volgende twee loops zijn for loops. Dit op twee manieren:
De Java-style iteration en de Ruby-style iteration. Deze for
loops laten niet veel nieuws zien voor mij. Daarom geef ik ze
hier niet weer.

#### Ranges and Tuples

In het boek gaan ze er van uit dat je kennis hebt gemaakt met
Ruby voordat je bezig gaat met Scala. Dit is in mijn geval niet zo.
Er word gezegd dat Scala net als Ruby gebruik kan maken van
first-class ranges. Een range kan je definiëren als:
`val range = 0 until 10`.
De eerste en laatste in de range kan je ophalen door middel van:
`range.start` en `range.end`.
Ook kan je de incrementen veranderen. Zo je een range maken met
verschillende grootte stappen:
`(0 to 10) by 5`. Dit geeft als resultaat: `Range = Range (0,5,10)`.

Bij het maken van ranges ben je echter niet gelimiteerd tot 
integers. Het is dus ook mogelijk om een range te maken van characters:
`val range = 'a' to 'e'`.

Net als in prolog, waar ik dus geen ervaring mee heb maar het boek
wel van uit gaat, kan je in Scala ook tuples gebruiken.
Een tuple is een fixed-length set van objecten. Voor het aanmaken
van meerdere value assignments gebruikt Scala tuples:
`val (x, y) = (1, 2)`.

#### Classes in Scala

Simpele classes (zonder methoden/constructor) zijn aan te maken
met 1 regel. Dit kan dus ook in de commandline:
`class Person(firstName: String, lastName: String)`.

Wanneer het gaat om een Object-oriented class worden data en behaviour
gemengt. Omdat dit niet in 1 regel in de commandline te doen is
maak ik weer een .scala bestand. Dit bestand is net als alle
andere gemaakte bestanden [hier](https://github.com/jordyebk/APP-Blog/tree/master/Scala/src)
te vinden. De betreffende class die word aangemaakt heet Compass.
Dit is een simpel compas met een aantal functies en waardes.

Het aanmaken van deze class lijkt in eerste opzich gigantisch veel op Java.
Echter verschilt er nog redelijk wat. Er word geen constructor gedefinieërd.
Alles wat na `class Compass {` komt is namenlijk de constructor.

Na een 'basic' constructor komen we nu bij auxiliary constructors. Om hier
kennis mee te maken word de Person class weergegeven. Deze class heeft 2 constructors.

```scala
class Person(first_name: String) {
  println("Outer constructor")
  def this(first_name: String, last_name: String) {
    this(first_name)
    println("Inner constructor")
   }
  def talk() = println("Hi")
}
```

#### Extending Classes

Tot nu toe hebben we alleen nog naar redelijk simpele classes gekeken. In deze sectie
worden wat ingewikkeldere voorbeelden gegeven. Hoe veel ingewikkelder dit daadwerkelijk is
zullen we zien.

##### Inheritance

Om overerving duidelijk te maken wordt 



## Eindopdracht
