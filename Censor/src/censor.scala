import scala.io.Source

def countWords(stringList: List[String]): Int = {
  stringList.foldLeft(0)((sum, value) => sum + 1)
}

println(countWords(List ("word1", "word2", "word3")))

class Sentence(val stringList: List[String]) {
  def printSentence() : Unit = {
    stringList.foreach(string => print(string + " "))
  }
}

class CensoredSentence(override val stringList: List[String]) extends Sentence(stringList) with censor {
  override def printSentence(): Unit = {
    val censoredSentence = censorSentence(stringList)
    println(censoredSentence)
  }
}

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

val censoredSentence = new CensoredSentence(List ("Shoot", "Whoop", "Darn"))
censoredSentence.printSentence()
