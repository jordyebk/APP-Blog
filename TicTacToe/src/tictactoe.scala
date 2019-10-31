class Line (val cells: List[String]) {
  def isNotFilled: Boolean = {
    cells.foreach( cell => {
      if(cell == "") {
        return true
      }
    })
    false
  }

  def checkForWinner: String = {
    if (cells.head == "X" && cells(1) == "X" && cells(2) == "X"){
      return "X"
    } else if (cells.head == "O" && cells(1) == "O" && cells(2) == "O") {
      return "O"
    }
    ""
  }
}

class Board (val rows: List[Line]) {
  val cols = rows.indices.map( i => {
    val col = rows.map(row => row.cells(i))
    new Line(col)
  })

  val diagonals = List(
    new Line(List(rows.head.cells.head, rows(1).cells(1), rows(2).cells(2))),
    new Line(List(rows.head.cells(2), rows(1).cells(1), rows(2).cells.head))
  )

  def getStatus(): Unit = {
    rows.foreach(row => {
      if(row.isNotFilled){
        return println("Game is not finished!")
      }
    })

    val winner = checkForWinner

    if(winner == ""){
      println("It's a tie!")
    } else {
      println(winner + " has won!")
    }
  }

  def checkForWinner: String = {
    val allLines = rows ++ cols ++ diagonals

    allLines.foreach(line => {
      if(line.checkForWinner != ""){
        return line.checkForWinner
      }
    })
    ""
  }
}

val line1 = new Line(List("O", "O", "X"))
val line2 = new Line(List("X", "X", "O"))
val line3 = new Line(List("O", "O", "X"))
val board = new Board(List(line1, line2, line3))
board.getStatus()
