package com.stejskal.fantasydrafter.squeryl


class ProTeam(val name: String, val state: String, val location: String, val divisionId: Long) extends BaseEntity
{
    def this() = this("", "", "", 0)
}