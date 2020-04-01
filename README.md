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

### Beschrijving Eindopdracht
Na het kennis maken met Scala zal ik werken aan een eindopdracht.
Deze eindopdracht moet laten zien dat ik mij heb kunnen verdiepen in de programmeertaal. 
De opdracht waar ik aan wil werken is een WebScraper.
In mijn vrije tijd stop ik veel uren in een MMORPG genaamd Oldschool Runescape (OSRS).
OSRS is een spel wat gericht is op progressie. Er is een groot aantal 'Skills' die je kan
trainen. Deze skills zitten gekoppeld aan je accountnaam en kunnen ingezien worden op
hun highscores website: [Link](https://secure.runescape.com/m=hiscore_oldschool/overall.ws).
Het idee is dat je een accountnaam op kan geven. Aan de hand van deze naam
worden de highscores opgehaald. Om te kijken hoe het account er voor staat
met zijn/haar progressie wordt er gekeken naar de 3 hoogste en 3 laagste skills.

Aan deze eindopdracht heb ik een aantal eisen gesteld:
* De opdracht moet volledig functioneel geprogrammeerd worden (In dien er 
uitzonderingen zijn worden deze benoemd).
* Wanneer er meerdere usernames worden opgegeven moeten deze parallel worden verwerkt.

De eerste eis heb ik gesteld omdat ik kennis wil maken met het paradigma functioneel programmeren.
Met Object Oriënted programming heb ik al eerder kennis gemaakt.


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

Om overerving duidelijk te maken wordt er een class Employee weergegeven.
Deze class extend de Person class gebruikt bij [classes in scala](#classes-in-scala).
De Employee class ziet er als volgt uit:
```scala
class Employee(override val name: String,
                        val number: Int) extends Person(name) {
  override def talk(message: String) {
    println(name + " with number " + number + " says " + message)
  }
  override def id():String = number.toString
}

val employee = new Employee("Yoda", 4)
employee.talk("Extend or extend not. There is no try.")
```
Wat mij hier opvalt is dat je bij alles wat al bestaat ook echt `override` neer moet zetten.
Ook hoef je bij de constructor van de superklasse ook geen `super()` aan te roepen.

##### Traits

Een trait kan je zien als een gedeeltelijke class implementatie. Het voorbeeld dat gegeven
word is als volgt:
```scala
class Person(val name:String)

trait Nice {
def greet() = println("Howdily doodily.")
}

class Character(override val name:String) extends Person(name) with Nice

val flanders = new Character("Ned")
flanders.greet
```
Het is dus mogelijk om een class aan te maken die een trait met zich meeneemt.
Character erft alles over van persoon, het verschil tussen Character en Person
is dat character een trait heeft.

### Einde dag 1

Als afsluiter van dag 1 staat er een kleine opdracht die gebruikt maakt van
de dingen waar mee ik kennis heb gemaakt. Deze opdracht is het maken van een
tic-tac-toe bord. Het spel krijgt een bord mee met de gemaakte zetten. Het resultaat
laat zien of het spel nog bezig, dat het gelijk spel is of dat iemand heeft gewonnen.

Om duidelijker weer te geven heb ik de source map iets netter geordend. Zo staan
alle .scala bestanden van dag 1 onder dag 1.

Deze opdracht ging makkelijker dan verwacht. Het enige wat af en toe voor verwarring
zorgde was de syntax. Gelukkig geeft intelliJ hier veel tips. De code voor deze opdracht
is [hier](https://github.com/jordyebk/APP-Blog/blob/master/TicTacToe/src/tictactoe.scala)
te vinden.

### Dag 2

In dag 2 gaan we meer kijken naar de functionele kant van Scala.
Na een korte inleiding van dag 2, die niet veel nieuwe laat zien maar echt
een intro verhaaltje is, komt het eerste onderdeel.

#### Collections

Om dag 2 af te trappen beginnen we met collections.

##### Lists

Met lists heb ik al kort kennis gemaakt tijdens het maken van de Tic tac toe opdracht.
Het enige nieuwe voor mij waar ik al achter kwam tijdens de opdracht is dat
de aanroep van een List een functie is. Zo kan je `()` gebruiken ipv `[]`.

##### Sets

Sets zijn bijna hetzelfde als een List. Een set heeft echter geen expliciete volgorde.
Het aanmaken van een set is redelijk simpel:
```scala
val animals = Set("lions", "tigers", "bears")
```
Wanneer je een item wil toevoegen of verwijderen kan je `+` of `-` gebruiken.
Als je een nieuw item toevoegd aan een set word er een nieuwe set aangemaakt.
Dit omdat een set Immutable is. Het optellen van 2 sets gebeurd hetzelfde als het
samenvoegen van 2 lists. Hier was ik bij het maken van tic tac toe achter gekomen.
Wanneer je 2 sets samen wil voegen gebruik je `++`, ook kan `--` gebruikt worden
om zo alles wat in de tweede set voorkomt te verwijderen uit de eerste set. Ook
een intersection is mogelijk. Het resultaat hier van is dat je een nieuwe set krijgt
met alleen de objecten die voorkomen in beide voorkomen. In het boek word gezegd
dat je hier voor `**` kan gebruiken. Echter wanneer ik dit probeer krijg ik een error.
Het lijkt er op dat dit niet meer word ondersteund of veranderd is voor sets.

##### Maps

Een map is een collectie met een key-value koppel. Het aanmaken van een map is redelijk simpel:
```scala
val ordinals = Map(0 -> "zero", 1 -> "one", 2 -> "two")
```
Je kan een value ophalen aan de hand van de key: `ordinals(2)`. Deze map is 
immutable en zit simpel in elkaar.

Om verder te kijken naar maps moet ik een mutable HashMap importen. Dit word op
de volgende manier gedaan: `import scala.collection.mutable.HashMap`. Het aanmaken
van deze map die veel denken aan het aanmaken van een HashMap in Java.
```scala
val map = new HashMap[Int, String]
```
Je specificeert welke waardes de keys en values moeten hebben, in dit geval
een Int en een String. Het toevoegen van een waarde gaat als volgt: `map += 4 -> "four"`.
Je voegt dus gewoon een `key -> value` combinatie toe.

#### Collections and functions

Na de eerste uitleg over Collections zijn we nu bij het functionele programmeren.
Collections hebben toegang tot meerdere higher order functions die anonymous functies
accepteren als parameter. Een voorbeeld hier van is een for each functie: `list.foreach(elem => ...)`.
Omdat dit gigantisch veel lijkt op de functies waar ik mee bekend ben in Java ga ik hier niet echt op in.
Tijdens mijn ASD project was het mijn leerdoel om kennis op te doen over Higher order functions.

### Eind dag 2

Net als dag 1 staat er een eindopdracht voor dag 2. Het eerste gedeelte van de opdracht
is om foldLeft te gebruiken om de totale size van een List van strings te berekenen.
Dit heb ik op de volgende manier uitgewerkt:
```scala
def countWords(stringList: List[String]): Int = {
  stringList.foldLeft(0)((sum, value) => sum + 1)
}

println(countWords(List("a", "b", "s")))
```

Het volgende gedeelte van de eindopdracht was het maken van een Censor trait met
een methode die scheldwoorden vervangd. Shoot moet vervangen worden door Pucky en
Darn door Beans. De scheldwoorden en de alternatieven moeten in een map opgeslagen worden.
Een uitbreiding is het ophalen van de scheldwoorden en de alternatieven uit een bestand.

Om te beginnen heb ik een simpele sentence aangemaakt:
```scala
class Sentence(val stringList: List[String]) {
  def printSentence() : Unit = {
    stringList.foreach(string => print(string + " "))
  }
}
```
Deze krijgt een list van strings en print deze uit.
Hierna heb ik een censoredSentence gemaakt. Deze extend de gewone sentence.
```scala
class CensoredSentence(override val stringList: List[String]) extends Sentence(stringList) with censor {
  override def printSentence(): Unit = {
    val censoredSentence = censorSentence(stringList)
    println(censoredSentence)
  }
}
```
CensoredSentence extend zo dus de Sentence klasse. Ook heeft deze de trait Censor
zoals beschreven in de opdracht. Ik override de printSentence methode uit sentence.
De stringList die mee word gegeven aan de CensoredSentence wordt eerste 
gecensureerd door middel van de censorSentence methode uit de trait Censor.
De censor trait ziet er als volgt uit:
```scala
trait censor {
  var censoredWords = getCensoredWords

  def getCensoredWords : Map[String, String] = {
    var map = Map.empty[String, String]

    val fileLines = Source.fromFile("censoredwords.txt").getLines()
    fileLines.foreach(line => {
      val split = line.split("=")
      map += split(0) -> split(1)
    })
    map
  }

  def checkWord(string: String) : String = {
    if (censoredWords.contains(string)){
      return censoredWords.get(string).mkString("")
    }
    string
  }

  def censorSentence(stringList: List[String]) : String = {
    val returnValue = stringList.foldLeft("")((sum, value) => {sum + checkWord(value) + " "})
    returnValue
  }
}
```
De woorden die gecensureerd moeten worden staan in een text bestand. Deze worden
er door middel van getCensoredWords uitgehaald en de map censoredWords gestopt.
De methode censorSentence gebruikt foldLeft om de stringList door te lopen. 
Wanneer een woord voorkomt in de censoredWords map word deze hier vervangen.

Voor ik begon aan deze opdracht was de foldLeft functie mij niet geheel duidelijk.
Het werken aan deze opdracht heeft dit zeker verheldert.

### Dag 3

Na een redelijk leuke opdracht te mogen maken voor het eind van dag 2 begint nu dag 3.

Dag 3 begint met een stuk over XML. Ik heb alles hier doorgelopen en ben zo niks
nieuws tegen gekomen. Ik ben er bij dag 1 en 2 achter gekomen dat alles wat er
benoemd word in het boek letterlijk op te schrijven mij te veel tijd gaat kosten
voor deze opdracht. Daarom laat ik hier niks zien over het XML gedeelte.

Het eerst volgende stuk is Pattern Matching

#### Pattern Matching

De uitleg gevonden in het boek over pattern matching is: 'Pattern matching lets you conditionally execute code based on some
piece of data'.
Er word ook een voorbeeld gegeven:
```scala
def doChore(chore: String): String = chore match {
  case "clean dishes" => "scrub, dry"
  case "cook dinner" => "chop, sizzle"
  case _ => "whine, complain"
}

println(doChore("clean dishes"))
println(doChore("mow lawn"))
```
Dit doet mij sterk denken aan een switch case. Er word dus gekeken of het attribuut,
de chore hier, overeenkomt met 1 van de cases. Wanneer dit niet zo is gaat deze naar de
default toe. Hier in scala weergegeven als `_`.

De volgende twee onderdelen, guards en regex, leggen deze uit. Deze werken echter zoals
ik van te voren had verwacht en ik zie deze ook niet als ingewikkeld.

##### XML with Matching

Hoewel dit net als de vorige twee onderdelen werkte zoals ik het had verwacht,
wil ik hier toch even wat over zeggen. Het voorbeeld dat gegeven word:
```scala
val movies = <movies>
  <movie>The Incredibles</movie>
  <movie>WALL E</movie>
  <short>Jack Jack Attack</short>
  <short>Geri's Game</short>
</movies>
(movies \ "_").foreach { movie =>
  movie match {
    case <movie>{movieName}</movie> => println(movieName)
    case <short>{shortName}</short> => println(shortName + " (short)")
  }
}
```
Ik vind dat Scala hier een hele mooie en overzichtelijke manier bied van het doorlopen
van XML. Het is zeer duidelijk.

#### Concurrency

In het boek word mij verteld dat een van de belangrijkste aspecten van Scala
de manier waarop Scala met concurrency om gaat is. Het voorbeeld wat hier bij gegeven
word, [hier](https://github.com/jordyebk/APP-Blog/blob/master/Scala/src/dag3/kids.scala) te vinden, heb ik meer dan 1 keer naar moeten kijken voordat ik het
echt begreep. Na het goed doorlezen van de tekst was mij dit echter wel duidelijk.
In eerste opzich raakte ik verward door de `loop` en de `!`.

Na het zelf uitproberen van dit voorbeeld ben ik er achter gekomen dat
de package `scala.actors` deprecated is in die nieuwe versies van Scala. Tegenwoordig word er gebruik gemaakt van Akka.

Om kennis te maken met Concurrency zal ik vanaf nu geen gebruik meer maken van het boek 7L7W.
Akka bied een 'quickstart guide' om er zo kennis mee te maken. Deze guide is 
[hier](https://developer.lightbend.com/guides/akka-quickstart-scala/index.html) te vinden.

##### Concurrency met Akka
Om deze guide te beginnen wordt er gevraagd om een project te downloaden. Dit project 
heb ik gedownload en is [hier](https://github.com/jordyebk/APP-Blog/tree/master/Concurrency/akka-quickstart-scala) te vinden.

Dit project heb ik geimporteerd in IntelliJ om deze zo te kunnen inspecteren. Dit project geeft een simpel voorbeeld
van de werking van Actors. Zo zijn er 3 verschillende Actors aanwezig aanwezig.
Deze zijn: Greet, GreeterBot en GreeterMain.

Door het gebruikt van Actors kan je verschillende acties laten uitvoeren aan de hand van een message die je meegeeft.
Het gebruik van Actors doet mij heel erg denken aan [Redux](https://redux.js.org/introduction/getting-started). Ik heb kennis gemaakt met Redux
tijdens mijn DWA (Develop web applications) Minor.


## Eindopdracht

Zoals benoemd in het hoofdstuk [Motivatie en introductie](#Motivatie-en-introductie) ga ik voor mijn eindopdracht een webscraper maken. 
Bij het maken van deze eindopdracht zal ik gebruik moeten maken van alles wat ik heb geleerd
tijdens het schrijven van deze Blog.

Wat deze eindopdracht precies is staat uitgelegd in het hoofdstuk [Beschrijving Eindopdracht](#Beschrijving-Eindopdracht).
Ook zijn hier de eisen weergegeven.

Voor deze eindopdracht is een project aangemaakt aan de hand van het Akka voorbeeld. Dit Project is 
[hier]() te vinden.
