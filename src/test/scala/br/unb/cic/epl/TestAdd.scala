package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import br.unb.cic.epl._
class TestAdd extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "An Add Expression"

  //var literal100: br.unb.cic.epl.Literal = _ 
  //before {
  //  literal100 = new Literal(100)
  //}

  it should "return String \"(10 + 20)\" call Add(Literal(10), Literal(20)).print()" in {
    val add = new Add(new Literal(10), new Literal(20))
    add.print() should be ("(10 + 20)")
  }

  it should "return Integer 30 when we call Add(Literal(10), Literal(20)).eval()" in {
    val litX = new Literal(10) with Eval.Literal
    val litY = new Literal(20) with Eval.Literal
    val add = new Add(litX, litY) with Eval.Add
    add.eval() should be (30)
  }
}
