package br.unb.cic.epl

trait SubHeight extends Sub with Height {
	override def height(): Int = {
		val hl = 1 + lhs.asInstanceOf[Height].height()
		val hr = 1 + rhs.asInstanceOf[Height].height()

		if (hl > hr)
			return hl
		else
			return hr
	}
}
