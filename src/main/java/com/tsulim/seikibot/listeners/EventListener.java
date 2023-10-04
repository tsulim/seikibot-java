package com.tsulim.seikibot.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {

    /**
     * Event fires when a message is sent in discord.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        if (message.contains("ping")) {
            event.getChannel().sendMessage("pong").queue();
        }
    }
}
