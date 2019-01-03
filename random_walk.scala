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
  }

  override def setup() {
    frameRate(240)
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
  var x: Float = applet.width/2
  var y: Float = applet.height/2

  def display() {
    applet.stroke(0)
    applet.point(x, y)
  }

  def step() {
    x += applet.random(3).toInt - 1
    y += applet.random(3).toInt- 1
  }
}