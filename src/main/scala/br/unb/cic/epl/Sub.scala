package br.unb.cic.epl

package object Sub {
  trait GSub extends Core.Expression {
    type T <: Core.Expression           //abstract type in Scala
    var lhs: T = _ 
    var rhs: T = _ 
    override def print(): String = "(" + lhs.print() + " - " + rhs.print() + ")" 
  }

  class Sub(l: Core.Expression, r: Core.Expression) extends GSub {
    type T = Core.Expression

    lhs = l
    rhs = r
  }
}

