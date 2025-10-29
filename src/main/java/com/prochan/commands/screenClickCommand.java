package com.prochan.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;

import net.minecraft.command.CommandSource;

/**
 * The Meteor Client command API uses the <a href="https://github.com/Mojang/brigadier">same command system as Minecraft does</a>.
 */
public class screenClickCommand extends Command {
    /**
     * The {@code name} parameter should be in kebab-case.
     */
    public screenClickCommand() {
        super("screen-click", "click screen.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        // /screen-click <slot> <button> <action>
        builder.then(argument("slot", IntegerArgumentType.integer())
                .then(argument("button", StringArgumentType.word())
                .then(argument("action", IntegerArgumentType.integer())) ));


    }
}
