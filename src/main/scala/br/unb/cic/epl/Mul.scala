package br.unb.cic.epl

package object Mul {
  trait GMul extends Core.Expression {
    type T <: Core.Expression           //abstract type in Scala
    var lhs: T = _ 
    var rhs: T = _ 
    override def print(): String = "(" + lhs.print() + " * " + rhs.print() + ")" 
  }

  class Mul(l: Core.Expression, r: Core.Expression) extends GMul {
    type T = Core.Expression

    lhs = l
    rhs = r
  }
}

