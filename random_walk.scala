import processing.core.PApplet

class RandomWalk extends PApplet {

  // In order to avoid declaring this class as abstract, we must initialize its
  // instance variables (i.e., w). However, doing so will make sure that the x
  // and y instance variables of the Walker instance is set to 50 since width
  // and height will default to 100 each and the size of the window has not
  // been set since the settings method has not yet been called at this time.
  // To avoid this problem, we can delcare the w variable to be lazy, so it
  // does not get initialized until the first time it is used in the draw
  // method. This makes sure that the window dimensions have been set by the
  // time the Walker instance's constructor is called.
  lazy val w: Walker = new Walker(this)

  override def settings() {
    size(640, 360)
    pixelDensity(displayDensity())
  }

  override def draw() {
    w.step
    w.display
  }
}

object RandomWalk extends App {
  PApplet.main("RandomWalk")
}

class Walker(applet: PApplet) {
  var x: Int = applet.width/2
  var y: Int = applet.height/2

  def display() {
    applet.stroke(0)
    applet.point(x, y)
  }

  def step() {
    val choice = applet.random(4).toInt
    if (choice == 0)
      x += 1
    else if (choice == 1)
      x -= 1
    else if (choice == 2)
      y += 1
    else
      y -= 1
  }
}