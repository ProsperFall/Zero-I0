package com.prochan.modules;

import com.prochan.ZeroI2;
import meteordevelopment.meteorclient.settings.BoolSetting;
import meteordevelopment.meteorclient.settings.Setting;
import meteordevelopment.meteorclient.settings.SettingGroup;
import meteordevelopment.meteorclient.systems.modules.Module;

public class NoInventoryGUI extends Module {
    private final SettingGroup sgGeneral = this.settings.getDefaultGroup();

    private final Setting<Boolean> noGui = sgGeneral.add(new BoolSetting.Builder()
        .name("switch")
        .defaultValue(false)
        .build()
    );
    public NoInventoryGUI() {
        super(ZeroI2.CATEGORY, "no-inventory-gui", "No inventory gui.");
    }
    @Override
    public boolean isActive() {
        return noGui.get();
    }

    @Override
    public void onActivate()
    {
        noGui.set(true);
    }
    @Override
    public void onDeactivate()
    {
        noGui.set(false);
    }

}
