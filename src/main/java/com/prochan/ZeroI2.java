package com.prochan;

import com.mojang.logging.LogUtils;
import com.prochan.commands.*;
import com.prochan.modules.*;
import meteordevelopment.meteorclient.addons.GithubRepo;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class ZeroI2 extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("ZeroI2");
    public static final HudGroup HUD_GROUP = new HudGroup("ZeroI2");

    @Override
    public void onInitialize() {
        LOG.info("Initializing ZeroI2");

        // Modules
        Modules.get().add(new ClickSimulator());
        Modules.get().add(new GoalBot());
        Modules.get().add(new NoInventoryGUI());

        // Commands
        Commands.add(new InteractCommand());
        Commands.add(new UiToolsCommand());
        Commands.add(new screenClickCommand());

        // HUD
        //Hud.get().register(HudExample.INFO);
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "com.prochan";
    }

    @Override
    public GithubRepo getRepo() {
        return new GithubRepo("chan", "Null");
    }
}
