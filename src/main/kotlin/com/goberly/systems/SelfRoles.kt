package com.goberly.systems

import com.goberly.cfg.*
import com.vdurmont.emoji.EmojiParser
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.buttons.Button
import java.awt.Color


class SelfRoles : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "set-self-role-channel") {
            val channel = event.channel.asTextChannel()



            val roleEmbed: EmbedBuilder = EmbedBuilder()
                .setTitle(name())
                .setAuthor(name(), website(), logo().avatar())
                .setThumbnail(logo().big())
                .setColor(Color.BLACK)
                .addField("Rollenvergage", "Reagiere mit folgende Emojis, um die Ränge freizuschalten!\n " +
                        "${EmojiParser.parseToUnicode(":newspaper:")} News \n " +
                        "${EmojiParser.parseToUnicode(":chart_with_upwards_trend:")} Statusmeldungen", true)
            event.channel.sendMessageEmbeds(roleEmbed.build()).addActionRow(news())
                .addActionRow(statusmeldungen()).queue()
        }
    }

    private fun news(): Button {
        return Button.primary("newsButton", "${EmojiParser.parseToUnicode(":newspaper:")} News")
    }
    private fun statusmeldungen() : Button {
        return Button.primary("statusmeldungenButton", "${EmojiParser.parseToUnicode(":chart_with_upwards_trend:")} Statusmeldungen")
    }

    override fun onButtonInteraction(event: ButtonInteractionEvent) {
        when(event.componentId) {
            "newsButton" -> {
                val role = roleManagement.Helper.Application().defineRole(event, GuildRoles().news())
                if (roleManagement.user().hasRole(event.member!!, role!!)) {
                    roleManagement().assignRole(event.guild!!, event.member!!, role)
                } else if (!roleManagement.user().hasRole(event.member!!, role)) {
                    roleManagement.user().hasRole(event.member!!, role)
                }
            }
            "statusmeldungenButton" -> {
                val role = roleManagement.Helper.Application().defineRole(event, GuildRoles().statusmeldungen())
                if (roleManagement.user().hasRole(event.member!!, role!!)) {
                    roleManagement().assignRole(event.guild!!, event.member!!, role)
                } else if (!roleManagement.user().hasRole(event.member!!, role)) {
                    roleManagement.user().hasRole(event.member!!, role)
                }
            }
        }
    }
}