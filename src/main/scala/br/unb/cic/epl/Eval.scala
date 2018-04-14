package br.unb.cic.epl

trait Eval extends Expression {
	def eval(): Int
}

trait LiteralEval extends Literal with Eval {
	override def eval() = value
}

