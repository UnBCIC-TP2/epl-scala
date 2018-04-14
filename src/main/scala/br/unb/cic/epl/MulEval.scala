package br.unb.cic.epl

trait MulEval extends Mul with Eval {
	override def eval(): Int = {
		lhs.asInstanceOf[Eval].eval() * rhs.asInstanceOf[Eval].eval()
	}
}
