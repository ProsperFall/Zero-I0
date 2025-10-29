package com.prochan.modules;

import com.prochan.ZeroI2;
import meteordevelopment.meteorclient.events.game.OpenScreenEvent;
import meteordevelopment.meteorclient.events.packets.ContainerSlotUpdateEvent;
import meteordevelopment.meteorclient.events.packets.InventoryEvent;
import meteordevelopment.meteorclient.events.render.Render3DEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.render.color.Color;
import meteordevelopment.meteorclient.utils.render.color.SettingColor;
import meteordevelopment.orbit.EventHandler;

import java.util.List;

public class ClickSimulator extends Module {
    private int SyncId = 0;
    private int Revision = 0;
    private final SettingGroup sgGeneral = this.settings.getDefaultGroup();

    private  final Setting<InventoryOwner> inventoryOwner = sgGeneral.add(new EnumSetting.Builder<InventoryOwner>()
        .name("target")
        .description("Select Inventory keeper.")
        .defaultValue(InventoryOwner.ClientPlayer)
        .build()
    );

    public ClickSimulator() {
        super(ZeroI2.CATEGORY, "click-simulator", "Click inventory slot automatically.");
    }

    @Override
    public void onActivate() {

    }

    @Override
    public void onDeactivate() {

    }

    @EventHandler
    private void onScreenHandlerSlotUpdate(ContainerSlotUpdateEvent event) {
        this.SyncId = event.packet.getSyncId();
        this.Revision = event.packet.getRevision();
        ZeroI2.LOG.info(String.format("SlotUpdate,SyncId: %d, Revision: %d", this.SyncId, this.Revision));
    }

    @EventHandler
    private void onInventory(InventoryEvent event) {
        this.SyncId = event.packet.syncId();
        this.Revision = event.packet.revision();
        ZeroI2.LOG.info(String.format("Inventory,SyncId: %d, Revision: %d",this.SyncId,this.Revision));
    }

    public enum InventoryOwner {
        ClientPlayer,
        EntityOrBlock
    }

}
