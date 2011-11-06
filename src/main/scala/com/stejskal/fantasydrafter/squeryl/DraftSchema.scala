package com.stejskal.fantasydrafter.squeryl

import org.squeryl.PrimitiveTypeMode._

import org.squeryl.Schema

class DraftSchema extends Schema
{
  val proTeams = table[ProTeam]

  on(proTeams)(proTeam => declare(proTeam.id is (autoIncremented)))
}