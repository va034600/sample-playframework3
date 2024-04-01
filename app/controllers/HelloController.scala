package controllers

import play.api.libs.json.Json

import javax.inject.Inject
import play.api.mvc._

class HelloController @Inject() (cc: ControllerComponents)
  extends AbstractController(cc) {

  def hello(): Action[AnyContent] = {
    val map = Map(1 -> "a", 2 -> "b", 3 -> "c")
    val result: Result = Ok(Json.toJson(map))
    Action(result.as("text/plain"))
  }
}
