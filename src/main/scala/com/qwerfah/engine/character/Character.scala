package com.qwerfah.engine.character

import scala.collection.immutable.{Map => IMap}
import scala.collection.mutable.{Map => MMap}
import scala.util.{Success, Failure, Try}

import java.util.UUID

import com.qwerfah.engine.util.errors.AcceptableError.RepeatedApplication
import com.qwerfah.engine.util.errors.UnexpectedError.NonExistentEntityAccess

trait Character {
  protected val _diplomacy: IntAbility
  protected val _militaryAffairs: IntAbility
  protected val _management: IntAbility
  protected val _intrigues: IntAbility
  protected val _scholarship: IntAbility

  def diplomacy: IntAbility = _diplomacy
  def militaryAffairs: IntAbility = _militaryAffairs
  def management: IntAbility = _management
  def intrigues: IntAbility = _intrigues
  def scholarship: IntAbility = _scholarship

  private val _properties: MMap[UUID, Property] = MMap.empty

  def properties: IMap[UUID, Property] = _properties.toMap

  def addProperty(property: Property): Try[Unit] = {
    properties.get(property.uuid) match {
      case None => Success(_properties.update(property.uuid, property))
      case _    => Failure(RepeatedApplication(s"property ${property.code}(${property.uuid}) already applied"))
    }
  }

  def removeProperty(uuid: UUID): Try[Unit] = {
    _properties.remove(uuid) match {
      case Some(_) => Success(())
      case _       => Failure(NonExistentEntityAccess(s"try to delete non-existent property ${uuid}"))
    }
  }

}
