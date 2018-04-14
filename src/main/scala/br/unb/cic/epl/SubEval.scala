package br.unb.cic.epl

trait SubEval extends Sub with Eval {
	override def eval(): Int = {
		lhs.asInstanceOf[Eval].eval() - rhs.asInstanceOf[Eval].eval()
	}
}
