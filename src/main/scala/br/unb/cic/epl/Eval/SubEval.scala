package br.unb.cic.epl.Eval

trait Sub extends br.unb.cic.epl.Sub with Eval {
	override def eval(): Int = {
		lhs.asInstanceOf[Eval].eval() - rhs.asInstanceOf[Eval].eval()
	}
}
