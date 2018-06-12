package playground.view

import scala.xml.Node

import scalacss.DevDefaults._
import scalacss.internal.Env

object Styles {
  def renderAll(): Node =
    <style>
      { render(Header.Style) }
    </style>

  private def render(style: StyleSheet.Inline): String =
    style.render(cssStringRenderer, implicitly[Env])
}
