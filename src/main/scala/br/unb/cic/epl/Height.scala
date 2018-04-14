package br.unb.cic.epl

trait Height extends Expression {
	def height(): Int
}

trait LiteralHeight extends Literal with Height {
	override def height() = 1
}