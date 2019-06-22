package cardDrawGen

import scala.util.Random

object CardDrawGenerator {
  val r: Random.type = scala.util.Random
  val cards = List(1, 2, 3, -4, 5, 7, 8, 10, 11, 12)
  def drawCard(): Int = cards(r.nextInt(cards.size))
}
