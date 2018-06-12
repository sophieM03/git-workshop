package playground.view

import scala.xml.Node

object App {
  def apply(): Node =
    <div>
      { Styles.renderAll() }

      { Header() }

      { TodoList() }
    </div>
}
