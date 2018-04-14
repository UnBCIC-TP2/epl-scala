package br.unb.cic.epl

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.GivenWhenThen
import org.scalatest.BeforeAndAfter

import br.unb.cic.epl._
class TestMul extends FlatSpec with Matchers with GivenWhenThen with BeforeAndAfter {

  behavior of "An Mul Expression"

  //var literal100: br.unb.cic.epl.Literal = _ 
  //before {
  //  literal100 = new Literal(100)
  //}

  it should "return String \"(10 * 20)\" call Mul(Literal(10), Literal(20)).print()" in {
    val mul = new Mul(new Literal(10), new Literal(20))
    mul.print() should be ("(10 * 20)")
  }

  it should "return Integer 200 when we call Mul(Literal(10), Literal(20)).eval()" in {
    val litX = new Literal(10) with Eval.Literal
    val litY = new Literal(20) with Eval.Literal
    val mul = new Mul(litX, litY) with Eval.Mul
    mul.eval() should be (200)
  }

  it should "return Integer 2 when we call Mul(Literal, Literal).height()" in {
    val litX = new Literal(10) with Height.Literal
    val litY = new Literal(20) with Height.Literal
    val mul = new Mul(litX, litY) with Height.Mul
    mul.height() should be (2)
  }

  it should "return Integer 3 when we call Mul(Mul(Literal, Literal), Literal).height()" in {
    val litX  = new Literal(10) with Height.Literal
    val litY  = new Literal(20) with Height.Literal
    val mulXY = new Mul(litX, litY) with Height.Mul
    val mul   = new Mul(mulXY, litY) with Height.Mul
    mul.height() should be (3)
  }

  it should "return 3 when we call mul.height() and 2000 when we call mul.eval(), where mul is Mul(Literal(10), Mul(Literal(10),Literal(20)))" in {
    val litX = new Literal(10) with Height.Literal with Eval.Literal
    val litY = new Literal(20) with Height.Literal with Eval.Literal
    val mulXY = new Mul(litX, litY) with Height.Mul with Eval.Mul
    val mul = new Mul(litX, mulXY) with Height.Mul with Eval.Mul
    mul.height() should be (3)
    mul.eval() should be (2000)
  }
}
