package br.unb.cic.epl.Eval

trait Mul extends br.unb.cic.epl.Mul with Eval {
	override def eval(): Int = {
		lhs.asInstanceOf[Eval].eval() * rhs.asInstanceOf[Eval].eval()
	}
}
