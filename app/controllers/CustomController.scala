package controllers

/**
 * Created by himandhk on 04/08/2016.
 */

import play.api.mvc.{Action, Controller}

object CustomController extends Controller{

    def test = Action {
      Ok("TEST")
    }

}
