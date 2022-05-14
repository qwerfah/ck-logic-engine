package com.qwerfah.engine.util.errors

/** Type of error, that can take place during execution and will not lead to crash. May be logged or simply ignored.
  */
sealed trait AcceptableError extends Throwable

object AcceptableError {
  final case class RepeatedApplication(message: String) extends AcceptableError
}
