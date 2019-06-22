package pawn

class Pawn(var team: Int) {
  var position: Int = 0
  var teamColor: Int = 0

  /*
   * Moves a given int, returns position of Pawn
   */
  def movePawn(moveCard: Int): Pawn = {
    if (isPawnInHome) {
      return this
    }
    if (isPawnInStart) {
      return movePawnLocatedInStart(moveCard)
    }
    modifyPosition(moveCard)
  }

  private def modifyPosition(moveAmount: Int): Pawn = {
    if (doesMoveOverflow(moveAmount)) return this
    if (position >= 33) {
      position += moveAmount
      return this
    }
    position += addCardToPosition(moveAmount)
    this
  }

  def movePawnLocatedInStart(movecard: Int): Pawn = {
    if (movecard == 2 || movecard == 1) {
      position = 1
    }
    this
  }

  def isPawnInStart: Boolean = position.equals(0)

  def isPawnInHome: Boolean = position.equals(38)

  def doesMoveOverflow(move: Int): Boolean = (position + move) > 38

  def addCardToPosition(move: Int): Int =  {
    var result = (move % 33)
    if (result < 0) result += 33
    if ((position + result) > 38) return 0

    result
  }
}
