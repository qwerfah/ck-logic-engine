package com.qwerfah.engine.util.errors

/** Type of error that is not expected during execution (something like assertions). In most cases will lead to crash,
  * but also can be logged. If UnexpectedError is thrown or returned somewhere, this means that this situation is not
  * expected in current execution logic.
  */
sealed trait UnexpectedError extends Throwable

object UnexpectedError {
  final case class NonExistentEntityAccess(message: String) extends Throwable
}
