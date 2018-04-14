package br.unb.cic.epl.Eval

trait Add extends br.unb.cic.epl.Add with Eval {
	override def eval(): Int = {
		lhs.asInstanceOf[Eval].eval() + rhs.asInstanceOf[Eval].eval()
	}
}
