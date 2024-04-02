package controllers

import dao.CatDAO
import models.Cat
import play.api.libs.json.{JsNull, Json, Writes}
import play.api.mvc._

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class CatController @Inject()(
                               catDao: CatDAO,
                               cc: ControllerComponents
                             )(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  def index = Action.async { implicit request =>
    val cat: Cat = new Cat("aa", "bb")
    catDao.insert(cat)

    val cat2: Cat = new Cat("aa2", "bb2")
    catDao.insert(cat2)

    val b = catDao.all().map(rows => rows.map(row => row.color))
    b.map(c => Ok(Json.toJson(c)))
  }

  def index2 = Action.async { implicit request =>
    val cat: Cat = new Cat("aa", "bb")
    catDao.insert(cat)

    val cat2: Cat = new Cat("aa2", "bb2")
    catDao.insert(cat2)

    val h = catDao.all().map(rows => rows.head)
    implicit val barFormat = Json.writes[Cat]
    h.map { hh => Ok(Json.toJson(hh)) }
  }

}
