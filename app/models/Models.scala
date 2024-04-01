package models

case class Cat(name: String, color: String)
object Cat {
  def unapply(cat: Cat): Option[(String, String)] = Some((cat.name, cat.color))
  def tupled = (this.apply _).tupled
}
