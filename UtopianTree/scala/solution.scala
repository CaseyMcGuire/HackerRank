object Solution {
  def main(args: Array[String]) {
    val lines = io.Source.stdin.getLines.takeWhile(_.length > 0).drop(1)
    val cycles = lines.map(_.toInt)
    for(cycle <- cycles) {
      println(getHeightOfUtopianTree(cycle))
    }
  }

  /*
   Returns the height of the Utopian Tree at the end of its growth cycles.
   */
  def getHeightOfUtopianTree(cycles : Int):Int = {
    (0 until cycles)
      .foldLeft(1)((heightSoFar, curCycle) => 
      if(curCycle % 2 == 0) heightSoFar * 2
      else heightSoFar + 1)
  }
}
