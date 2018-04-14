package br.unb.cic.epl

trait Expression {
	def print(): String
}

class Literal(val value:Integer) extends Expression {
	def print(): String = value.toString
}
