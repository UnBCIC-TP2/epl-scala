package br.unb.cic.epl

trait AddEval extends Add with Eval {
	override def eval(): Int = {
		lhs.asInstanceOf[Eval].eval() + rhs.asInstanceOf[Eval].eval()
	}
}
