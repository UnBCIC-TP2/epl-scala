package br.unb.cic.epl.Eval

trait Eval extends br.unb.cic.epl.Expression {
	def eval(): Int
}

trait Literal extends br.unb.cic.epl.Literal with Eval {
	override def eval() = value
}

