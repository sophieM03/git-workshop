package playground.view

import scala.xml.Node

import scalacss.DevDefaults._

import playground.util.Colors

object Header {
  def apply(): Node =
    <header class={ Style.header.htmlClass }>
      Git-workshop playground
    </header>

  object Style extends StyleSheet.Inline {
    import dsl._

    val header = style(
      backgroundColor(Colors.color1),
      color(white),
      padding(1.em),
      fontSize(1.5.em)
    )
  }
}
