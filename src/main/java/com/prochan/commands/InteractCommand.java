package com.prochan.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.prochan.modules.interaction.Interaction;
import meteordevelopment.meteorclient.commands.Command;
import meteordevelopment.meteorclient.commands.arguments.BlockPosArgumentType;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.command.CommandSource;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class InteractCommand extends Command {
    public InteractCommand() {
        super("interaction", "creat a interaction instance without gui.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("entity").then(argument("entity", StringArgumentType.word()).executes(context -> {
            info("hi, ");
            return SINGLE_SUCCESS;
        })));
        builder.then(literal("block")
            .then(argument("pos", BlockPosArgumentType.blockPos()).executes(context -> {
                BlockPos pos = BlockPosArgumentType.getBlockPos(context, "pos");
                Interaction interaction = new Interaction(mc);
                boolean bl = interaction.interactWithBlock(new BlockHitResult(pos.toCenterPos(),Direction.UP,pos,false));
                assert mc.world != null;
                ChatUtils.info("Hit Block: " + mc.world.getBlockState(pos).getBlock().getName().getString() + ",At: [" + pos.getX() + "," + pos.getY() + "," + pos.getZ() + "]");
                if(!bl){
                    ChatUtils.info("This block not has block entity.");
                    return 0;
                }
                return SINGLE_SUCCESS;
            })));
    }

}
