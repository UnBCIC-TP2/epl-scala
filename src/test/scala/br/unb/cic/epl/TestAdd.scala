package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter


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
    val litX = new Literal(10) with LiteralEval
    val litY = new Literal(20) with LiteralEval
    val add = new Add(litX, litY) with AddEval
    add.eval() should be (30)
  }

  it should "return Integer 2 when we call Add(Literal, Literal).height()" in {
    val litX = new Literal(10) with LiteralHeight
    val litY = new Literal(20) with LiteralHeight
    val add = new Add(litX, litY) with AddHeight
    add.height() should be (2)
  }

  it should "return Integer 3 when we call Add(Add(Literal, Literal), Literal).height()" in {
    val litX  = new Literal(10) with LiteralHeight
    val litY  = new Literal(20) with LiteralHeight
    val addXY = new Add(litX, litY) with AddHeight
    val add   = new Add(addXY, litY) with AddHeight
    add.height() should be (3)
  }

  it should "return 3 when we call add.height() and 40 when we call add.eval(), where add is Add(Literal(10), Add(Literal(10),Literal(20)))" in {
    val litX = new Literal(10) with LiteralHeight with LiteralEval
    val litY = new Literal(20) with LiteralHeight with LiteralEval
    val addXY = new Add(litX, litY) with AddHeight with AddEval
    val add = new Add(litX, addXY) with AddHeight with AddEval
    add.height() should be (3)
    add.eval() should be (40)
  }

}
