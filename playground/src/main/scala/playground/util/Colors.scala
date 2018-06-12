package playground.util

import scalacss.internal.{ ValueT, Color => ScalaCssColor }

object Colors {
  val color1: ValueT[ValueT.Color] = ScalaCssColor("#193C61")
  val color2: ValueT[ValueT.Color] = ScalaCssColor("#891919")
}
