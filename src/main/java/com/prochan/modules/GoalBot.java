package com.prochan.modules;

import com.prochan.ZeroI2;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;

public class GoalBot extends Module {
    private final SettingGroup sgGeneral = this.settings.getDefaultGroup();
    private final SettingGroup sgRender = this.settings.createGroup("Render");

    public GoalBot() {
        super(ZeroI2.CATEGORY, "zero-i2", "A smart bot.");
    }
    private final Setting<Boolean> Zero12Bot = sgGeneral.add(new BoolSetting.Builder()
        .name("zero-i2")
        .description("Enable AI agent play this game.")
        .defaultValue(false)
        .build()
    );

    private final Setting<SettingColor> color = sgRender.add(new ColorSetting.Builder()
        .name("color")
        .description("Add goal, kill mod, get it's looting, mine diamond.")
        .defaultValue(Color.MAGENTA)
        .build()
    );


}
