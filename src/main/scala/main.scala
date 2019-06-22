import cardDrawGen.CardDrawGenerator
import pawn.Pawn

object main {

  def initializeGame(): List[List[Pawn]] = List(List.fill(4){new Pawn(1)}) :+ List.fill(4){new Pawn(2)} :+ List.fill(4){new Pawn(3)} :+ List.fill(4){new Pawn(4)}


  def main(args: Array[String]): Unit = {
    val gamePawns: List[List[Pawn]] = initializeGame()

    while(!hasAnyTeamWon(gamePawns)) {
      for(team <- gamePawns) {
        for (selectPawn <- team) {
          takeTurn(selectPawn)
        }
      }
      printPawns(gamePawns)
    }

    val winningTeam: List[Pawn] = getWinningTeam(gamePawns)
    printTeam(winningTeam)
  }

  def takeTurn(pawn: Pawn): Pawn = pawn.movePawn(CardDrawGenerator.drawCard())

  def printPawns(gamePawns: List[List[Pawn]]): Unit = {
    for(team <- gamePawns) {
      print("Team: " + team(0).team)
      for (selectPawn <- team) {
        print(" position: " + selectPawn.position)
      }
      println("\n-------------------------------------- eor")
    }
  }

  def printTeam(team: List[Pawn]): Unit = {
    team.map(pawn => println(pawn.position))
  }

  def hasAnyTeamWon(gamePawns: List[List[Pawn]]): Boolean = gamePawns.exists(isTeamInHome)

  /*
   * There are 38 tiles to get a pawn into home, if all pawns on a team are in home their summed position will be 152
   */
  def isTeamInHome(team: List[Pawn]): Boolean = team.map(_.position).sum >= 152

  def getWinningTeam(gamePawns: List[List[Pawn]]): List[Pawn] = {
    for(team <- gamePawns) {
      if (isTeamInHome(team)) return team
    }
    gamePawns(0)
  }

}
