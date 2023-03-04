package com.goberly

import com.goberly.events.OnReady
import io.github.cdimascio.dotenv.dotenv
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent

class Main {
    companion object {
        val dotenv = dotenv()
    }

    fun main() {
        JDABuilder.createDefault(dotenv["TOKEN"])
            .addEventListeners(OnReady())
            .setActivity(Activity.watching("GoBerly"))
            .build()
    }
}