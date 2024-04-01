package controllers

import dao.CatDAO
import models.Cat
import play.api.mvc._

import javax.inject.Inject
import scala.concurrent.ExecutionContext

class CatController @Inject()(
                               catDao: CatDAO,
                              cc: ControllerComponents
                            )(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  def index(): Action[AnyContent] = {
    val result: Result = Ok("Hello World")

    val cat: Cat = new Cat("aa", "bb")
    catDao.insert(cat)

    val cat2: Cat = new Cat("aa2", "bb2")
    catDao.insert(cat2)

    catDao.all().foreach(println)

    Action(result.as("text/plain"))
  }

}
