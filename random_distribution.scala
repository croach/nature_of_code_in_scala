import processing.core.PApplet

class RandomDistribution extends PApplet {

  var randomCounts = new Array[Int](20)

  override def settings() {
    size(640, 240)
  }

  override def setup() {
    frameRate(240)
  }

  override def draw() {
    background(255)
    // Pick a slot at random and increment its count
    var index = random(randomCounts.length).toInt
    randomCounts(index) += 1

    stroke(0)
    fill(175)
    val w: Int = width/randomCounts.length
    randomCounts.zipWithIndex.foreach {
      case(count, i) => rect(i * w, height - count, w - 1, count)
    }
  }
}

object RandomDistribution extends App {
  PApplet.main("RandomDistribution")
}