package com.tsulim.seikibot;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.exceptions.InvalidTokenException;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class seikibot {

    private final Dotenv config;
    private final ShardManager shardManager;
    public seikibot() throws InvalidTokenException {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("your every move"));
        shardManager = builder.build();
    }

    public Dotenv getConfig() {
        return config;
    }
    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        try {
            seikibot bot = new seikibot();
        } catch (InvalidTokenException e) {
            System.out.println("ERROR: Provided bot token is invalid!");
        }
    }
}