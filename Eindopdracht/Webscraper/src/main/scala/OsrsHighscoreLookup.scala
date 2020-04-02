import java.io.{File, PrintWriter}

import scala.io.Source

object OsrsHighscoreLookup extends App {
  val usernames = Array("Road_23", "Tunnels", "Dawnshifter")

  HighscoreScraper.LookupHighscores(usernames(0))

  usernames.foreach(user => HighscoreScraper.LookupHighscores(user))
}


object HighscoreScraper {
  def LookupHighscores(username: String) = {
    val path = "./src/main/resources/"+username+".html"

    val allLevels = getAllLevels(parseHtml(path))

    writeLevelsToFile(username, convertMapToText(allLevels))
}

    private def parseHtml(html: String): Array[Any] = {
      val trimmedHtlm = trimHtml(loadHtml(html))
      trimmedHtlm.indices.map(i => if (trimmedHtlm.slice(i, i+4) == "<tr>") getTableRow(trimmedHtlm, i+4))
        .filter(_ != (())) // Remove boxed objects
        .map(e => e.asInstanceOf[String].filter(char => char != ' ' && char != '\n' && char != '\r'))
        .filter(e => checkIfContainsSkill(e))
        .toArray
    }

  private def trimHtml(html: String): String = {
    val divName = "<div id=\"contentHiscores\">"
    val begin = html.indexOfSlice(divName)
    val cutHtml = html.drop(begin)
    val end = cutHtml.indexOfSlice("</div>")
    cutHtml.slice(begin+divName.length, end)
  }

  private def loadHtml(path: String): String = {
    Source.fromFile(path).mkString
  }

  private def loadTxt(path: String): List[String] = {
    Source.fromFile("./src/main/resources/ListOfSkills.txt").getLines().toList
  }

  private def getTableRow(html: String, i: Int, inhoud: String = ""): String = {
    val nextCharIndex = i+1
    val nextChar = html(nextCharIndex)

    if (html.slice(nextCharIndex, nextCharIndex+5) == "</tr>") {
      inhoud
    } else {
      getTableRow(html, nextCharIndex, inhoud + nextChar)
    }
  }

  private def checkIfContainsSkill(html: String): Boolean = {
    val skills = loadTxt("./src/main/resources/ListOfSkills.txt")
    skills.foreach(skill => {
      if (html.contains("Bounty")) return false
      else if (html.contains(skill)) return true
    })
    false
  }

  private def checkWhichSkill(html: String): String = {
    val skills = loadTxt("./src/main/resources/ListOfSkills.txt")
    skills.foreach(skill => {
      if (html.contains(skill)) return skill
    })
    "Skill not found"
  }

  private def getAllLevels(parsedHtml: Array[Any]): Map[String, Int] = {
    parsedHtml.map(Any => {
      val html = Any.asInstanceOf[String]
      checkWhichSkill(html) -> findLevelInHtml(html)
    }).toMap
  }

  private def findLevelInHtml(html: String): Int = {
    val regex = ">[0-9][0-9]<".r
    regex.findFirstIn(html).mkString.replaceAll("[><]", "").toInt
  }

  private def writeLevelsToFile(user: String, text: String) = {
    val pw = new PrintWriter(new File("./src/main/resources/Results/"+user+".txt" ))
    pw.write(text)
    pw.close()
  }

  private def convertMapToText(levels: Map[String, Int]): String = {
    levels.map{case (k, v) => "Skill: " + k + " - Level: " + v}.mkString("\n")
  }
}
