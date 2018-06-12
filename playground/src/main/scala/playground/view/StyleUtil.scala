package playground.view

object StyleUtil {
  def classes(xs: (String, Boolean)*): String =
    xs.filter(_._2).map(_._1).mkString(" ")
}
