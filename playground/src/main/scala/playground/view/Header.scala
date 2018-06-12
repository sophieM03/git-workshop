package playground.view

import scala.xml.Node
import scalacss.DevDefaults._

import playground.util.Colors

object Header {
  def apply(): Node =
    <div class={ Style.header.htmlClass }>
      <h1 class={ Style.title.htmlClass }>
        Git-workshop playground
      </h1>
    </div>

  object Style extends StyleSheet.Inline {
    import dsl._

    val header = style(
      backgroundColor(Colors.color1)
    )

    val title = style(
      color(white),
      padding(1.em),
      fontSize(1.5.em)
    )
  }
}
