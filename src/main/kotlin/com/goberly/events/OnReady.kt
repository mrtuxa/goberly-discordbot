package com.goberly.events

import com.goberly.systems.SelfRoles
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class OnReady : ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        val jda = event.jda
        jda.addEventListener(SelfRoles())
    }
}