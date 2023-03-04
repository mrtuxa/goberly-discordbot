package com.goberly.cfg

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction
import net.dv8tion.jda.api.interactions.components.buttons.ButtonInteraction

class Settings {
    fun prefix() : String {
        return ">"
    }
}

class logo {
    fun big() : String {
        return "https://raw.githubusercontent.com/goberly/designs/main/goberly.svg"
    }
    fun avatar() : String {
        return "https://raw.githubusercontent.com/goberly/designs/main/goberly_avatar.png"
    }
}

fun name() : String {
    return "GoBerly"
}

fun website() : String {
    return "https://goberly.com"
}

class GuildRoles {
    fun verified() = 1081669895000952923
    fun statusmeldungen() = 1081676679333822535
    fun news() = 1081676662292357220
}

class roleManagement() {
        fun assignRole(guild: Guild?, member: Member?, role: Role?) {
            return guild!!.addRoleToMember(member!!, role!!).queue()
        }

        fun removeRole(guild: Guild?, member: Member?, role: Role?) {
            return guild!!.removeRoleFromMember(member!!, role!!).queue()
        }
    class user {
        fun hasRole(member: Member, role: Role): Boolean {
            val memberRoles = member.roles
            return memberRoles.contains(role)
        }
    }

    class Helper() {
        class Application() {
            fun defineRole(event: ButtonInteraction, role: Long): Role? {
                return event.jda.getRoleById(role)
            }
        }
    }
}



