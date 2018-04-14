package br.unb.cic.epl

class Add(val lhs:Expression, val rhs:Expression) extends Expression {
	override def print(): String = "(" + lhs.print() + " + " + rhs.print() + ")"
}
