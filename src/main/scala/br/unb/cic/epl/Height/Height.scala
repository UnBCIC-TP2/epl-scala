package br.unb.cic.epl.Height

trait Height extends br.unb.cic.epl.Expression {
	def height(): Int
}

trait Literal extends br.unb.cic.epl.Literal with Height {
	override def height() = 1
}