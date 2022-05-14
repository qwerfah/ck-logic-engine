package com.qwerfah.engine.character

import java.util.UUID

trait Property {
    def uuid: UUID
    
    def code: String

    def affect(ch: Character): Unit
}