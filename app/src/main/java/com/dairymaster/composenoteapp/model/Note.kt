package com.dairymaster.composenoteapp.model

import java.time.LocalDateTime
import java.util.*

data class Note(val id: UUID = UUID.randomUUID(),
                val title: String,
                val info: String,
                val entryDate: LocalDateTime = LocalDateTime.now())
