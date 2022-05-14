package com.qwerfah.engine.character

sealed trait Ability[T] {
  protected[character] def _value: T
}

final case class IntAbility(v: Int) extends Ability[Int] {
  require(v >= 0)

  protected[character] var _value: Int = v
  def value: Int = _value
}
