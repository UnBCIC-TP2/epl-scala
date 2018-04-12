package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


class TestSub extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "An Sub expression"

  var literal100: Eval.Literal = _
  var literal200: Eval.Literal = _

  before {
    literal100 = new Core.Literal(100) with Eval.Literal
    literal200 = new Core.Literal(200) with Eval.Literal
  }

  it should "return String (100 - 200) when we call Sub(Literal(100), Literal(200).print())" in {
    val add = new SubEval.Sub(literal100, literal200)
  
    add.print() should be ("(100 - 200)")
  }

  it should "return -100 when we call call Sub(Literal(100), Literal(200)).eval()" in {
    val add = new SubEval.Sub(literal100, literal200)

    add.eval() should be (-100)
  }
}
