package playground

import mhtml._
import org.scalajs.dom.document.body

import playground.view.App

object Main {
  def main(args: Array[String]): Unit = {
    mount(body, App())
    ()
  }
}
