package br.unb.cic.epl

//class Add[T<:Expression](val lhs:T, val rhs:T) extends Expression {
class Add(val lhs:Expression, val rhs:Expression) extends Expression {
	override def print(): String = "(" + lhs.print() + " + " + rhs.print() + ")"
}
