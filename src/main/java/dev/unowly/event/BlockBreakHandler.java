package dev.unowly.event;

import dev.unowly.config.ModConfig;
import dev.unowly.util.TreeFellingUtil;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class BlockBreakHandler {

    private final Map<UUID, Boolean> timberEnabled;
    private final Set<Identifier> woodBlockIds;
    private final TreeFellingUtil treeFellingUtil;

    public BlockBreakHandler(Map<UUID, Boolean> timberEnabled, Set<Identifier> woodBlockIds) {
        this.timberEnabled = timberEnabled;
        this.woodBlockIds = woodBlockIds;
        this.treeFellingUtil = new TreeFellingUtil(woodBlockIds);
    }

    public boolean onBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, net.minecraft.block.entity.BlockEntity blockEntity) {
        if (!world.isClient() && timberEnabled.getOrDefault(player.getUuid(), false)) {
            Identifier blockId = Registries.BLOCK.getId(state.getBlock());
            if (woodBlockIds.contains(blockId)) {
                ItemStack tool = player.getMainHandStack();

                if (ModConfig.CONFIG.allowNonAxes || treeFellingUtil.isAxe(tool)) {
                    treeFellingUtil.findAndBreakConnectedWood((ServerWorld) world, pos, player, tool);
                    return false;
                }

                return true;
            }
        }
        return true;
    }
}
