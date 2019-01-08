import processing.core.PApplet

class MCPi extends PApplet {

  private val CENTER = 3 // TODO: How do I get this from the Processing library?
  private val RADIUS = 200
  private var points: List[Tuple2[Float, Float]] = List()

  override def settings() {
    size(RADIUS * 2, RADIUS * 2)
  }

  override def setup() {
    frameRate(480)
  }

  override def draw() {
    background(255)
    fill(255)
    stroke(0)
    ellipse(width/2, height/2, width, height)

    // Add a new point at random
    val x = random((width + 0.00000001).toFloat)
    val y = random((height + 0.00000001).toFloat)
    points = (x, y) :: points

    var inside = 0
    for ((x, y) <- points) {
      val xAdj = (x - RADIUS)/RADIUS
      val yAdj = (y - RADIUS)/RADIUS
      if (xAdj*xAdj + yAdj*yAdj < 1) {
        stroke(0, 0, 255)
        fill(0, 0, 255)
        inside += 1
      } else {
        stroke(255, 0, 0)
        fill(255, 0, 0)
      }
      ellipse(x, y, 1, 1)
    }

    /********************************************************
     * Approximate the area of the circle and display it
     *******************************************************/

    var areaOfCircle = (inside*1.0)/points.length * 4

    // Draw the bounding box
    rectMode(CENTER)
    stroke(0)
    fill(255)
    rect(width/2, height/2, 50, 20)

    fill(0)
    textAlign(CENTER, CENTER)
    text(f"${areaOfCircle}%.4f", width/2, height/2, 50, 20)
  }
}

object MCPi extends App {
  PApplet.main("MCPi")
}