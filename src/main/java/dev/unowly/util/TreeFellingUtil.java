package dev.unowly.util;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TreeFellingUtil {

    private final Set<Identifier> woodBlockIds;

    public TreeFellingUtil(Set<Identifier> woodBlockIds) {
        this.woodBlockIds = woodBlockIds;
    }

    public void findAndBreakConnectedWood(ServerWorld world, BlockPos startPos, PlayerEntity player, net.minecraft.item.ItemStack tool) {
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();

        queue.add(startPos.toImmutable());
        visited.add(startPos.toImmutable());

        while (!queue.isEmpty()) {
            BlockPos currentPos = queue.poll();
            BlockState currentState = world.getBlockState(currentPos);
            Identifier currentBlockId = Registries.BLOCK.getId(currentState.getBlock());

            if (woodBlockIds.contains(currentBlockId)) {
                world.breakBlock(currentPos, true, player, 1000);
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        for (int z = -1; z <= 1; z++) {
                            BlockPos neighborPos = currentPos.add(x, y, z);
                            if (!visited.contains(neighborPos)) {
                                visited.add(neighborPos);
                                queue.add(neighborPos);
                            }
                        }
                    }
                }
            }
        }
    }
}
