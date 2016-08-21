package controllers

/**
 * Created by himandhk on 04/08/2016.
 */

import play.api.libs.concurrent.Akka
import play.api.mvc.{Action, Controller}
import akka.actor._
import play.api.Play.current
object CustomController extends Controller{

    def test = Action {

    //  val remote = Akka.system.actorOf("akka.tcp://HelloSystem@127.0.0.1:5150/user/superactor")
      val myActor = Akka.system.actorOf(Props[LocalActor], name = "myactor")
      myActor ! "START"
      Ok("TEST")
      }


}


class LocalActor extends Actor {

  // create the remote actor (Akka 2.1 syntax)
  val remote = context.actorFor("akka.tcp://HelloSystem@127.0.0.1:5150/user/superactor")
  var counter = 0

  def receive = {
    case "START" =>
      remote ! "super"
    case msg: String =>
      println(s"LocalActor received message: '$msg'")
      if (counter < 5) {
        sender ! "Hello back to you"
        counter += 1
      }
  }
}