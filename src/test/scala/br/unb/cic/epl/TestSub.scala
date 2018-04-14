package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import br.unb.cic.epl._
class TestSub extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "An Sub Expression"

  //var literal100: br.unb.cic.epl.Literal = _ 
  //before {
  //  literal100 = new Literal(100)
  //}

  it should "return String \"(10 - 20)\" call Sub(Literal(10), Literal(20)).print()" in {
    val sub = new Sub(new Literal(10), new Literal(20))
    sub.print() should be ("(10 - 20)")
  }

  it should "return Integer -10 when we call Sub(Literal(10), Literal(20)).eval()" in {
    val litX = new Literal(10) with Eval.Literal
    val litY = new Literal(20) with Eval.Literal
    val sub = new Sub(litX, litY) with Eval.Sub
    sub.eval() should be (-10)
  }

  it should "return Integer 2 when we call Sub(Literal, Literal).height()" in {
    val litX = new Literal(10) with Height.Literal
    val litY = new Literal(20) with Height.Literal
    val sub = new Sub(litX, litY) with Height.Sub
    sub.height() should be (2)
  }

  it should "return Integer 3 when we call Sub(Sub(Literal, Literal), Literal).height()" in {
    val litX  = new Literal(10) with Height.Literal
    val litY  = new Literal(20) with Height.Literal
    val subXY = new Sub(litX, litY) with Height.Sub
    val sub   = new Sub(subXY, litY) with Height.Sub
    sub.height() should be (3)
  }

  it should "return 3 when we call sub.height() and 20 when we call sub.eval(), where sub is Sub(Literal(10), Sub(Literal(10),Literal(20)))" in {
    val litX = new Literal(10) with Height.Literal with Eval.Literal
    val litY = new Literal(20) with Height.Literal with Eval.Literal
    val subXY = new Sub(litX, litY) with Height.Sub with Eval.Sub
    val sub = new Sub(litX, subXY) with Height.Sub with Eval.Sub
    sub.height() should be (3)
    sub.eval() should be (20)
  }

}
