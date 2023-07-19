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

    /**
     * Loads environment variables and builds the bot shard manager.
     *
     * @throws InvalidTokenException occurs when bot token is invalid.
     */
    public seikibot() throws InvalidTokenException {
        // Load environment variables
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        // Build shard manager
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("your every move"));
        shardManager = builder.build();
    }

    /**
     * Retrieves the bot environment variables.
     * @return the DotEnv instance for the bot.
     */
    public Dotenv getConfig() {
        return config;
    }

    /**
     * Retrieves the bot shard manager.
     * @return the ShardManager instance for the bot.
     */
    public ShardManager getShardManager() {
        return shardManager;
    }

    /**
     * Main method where the bot starts.
     * @param args
     */
    public static void main(String[] args) {
        try {
            seikibot bot = new seikibot();
        } catch (InvalidTokenException e) {
            System.out.println("ERROR: Provided bot token is invalid!");
        }
    }
}