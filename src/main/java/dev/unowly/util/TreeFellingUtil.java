package dev.unowly.util;

import dev.unowly.config.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    public void findAndBreakConnectedWood(ServerWorld world, BlockPos startPos, PlayerEntity player, ItemStack tool) {
        if (!ModConfig.CONFIG.allowNonAxes && !isAxe(tool)) {
            return;
        }

        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> queue = new LinkedList<>();
        BlockPos lowestLogPos = startPos;
        int lowestY = startPos.getY();

        BlockState originalLogState = world.getBlockState(startPos);

        boolean isLargeTree = isLargeTreeStump(world, startPos, originalLogState);

        int brokenCount = 0;
        int maxToBreak = ModConfig.CONFIG.maxLogsBrocken;

        queue.add(startPos.toImmutable());
        visited.add(startPos.toImmutable());

        while (!queue.isEmpty()) {
            if (brokenCount >= maxToBreak) break;

            BlockPos currentPos = queue.poll();
            BlockState currentState = world.getBlockState(currentPos);
            Identifier currentBlockId = Registries.BLOCK.getId(currentState.getBlock());

            if (woodBlockIds.contains(currentBlockId)) {
                if (currentPos.getY() < lowestY) {
                    lowestY = currentPos.getY();
                    lowestLogPos = currentPos;
                }

                world.breakBlock(currentPos, true, player, 1000);
                brokenCount++;

                if (ModConfig.CONFIG.damagePerBlock && !tool.isEmpty() && tool.isDamageable()) {
                    tool.damage(1, player);
                }

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

        if (brokenCount > 0 && ModConfig.CONFIG.replantSaplings) {
            plantSapling(world, lowestLogPos, originalLogState, isLargeTree);
        }
    }

    private boolean isLargeTreeStump(ServerWorld world, BlockPos startPos, BlockState logState) {
        String blockId = Registries.BLOCK.getId(logState.getBlock()).toString();

        if (!blockId.equals("minecraft:dark_oak_log") &&
                !blockId.equals("minecraft:jungle_log") &&
                !blockId.equals("minecraft:pale_oak_log")) {
            return false;
        }

        BlockPos[] positions = {
                startPos,
                startPos.add(1, 0, 0),
                startPos.add(0, 0, 1),
                startPos.add(1, 0, 1)
        };

        for (BlockPos pos : positions) {
            BlockState state = world.getBlockState(pos);
            if (!Registries.BLOCK.getId(state.getBlock()).equals(blockId)) {
                return false;
            }
        }

        return true;
    }

    private void plantSapling(ServerWorld world, BlockPos saplingPos, BlockState originalLogState, boolean isLargeTree) {
        if (world.getBlockState(saplingPos).isAir() &&
                world.getBlockState(saplingPos.down()).isSolidBlock(world, saplingPos.down())) {

            Block saplingBlock = getSaplingForLog(originalLogState);
            if (saplingBlock != null && saplingBlock != Blocks.AIR) {
                if (isLargeTree || saplingBlock == Blocks.DARK_OAK_SAPLING || saplingBlock == Blocks.JUNGLE_SAPLING || saplingBlock == Blocks.PALE_OAK_SAPLING) {
                    plant2x2Saplings(world, saplingPos, saplingBlock);
                } else {
                    world.setBlockState(saplingPos, saplingBlock.getDefaultState());
                }
            }
        }
    }

    private void plant2x2Saplings(ServerWorld world, BlockPos centerPos, Block saplingBlock) {
        BlockPos[] positions = {
                centerPos,
                centerPos.add(1, 0, 0),
                centerPos.add(0, 0, 1),
                centerPos.add(1, 0, 1)
        };

        boolean canPlantAll = true;
        for (BlockPos pos : positions) {
            if (!world.getBlockState(pos).isAir() ||
                    !world.getBlockState(pos.down()).isSolidBlock(world, pos.down())) {
                canPlantAll = false;
                break;
            }
        }

        if (canPlantAll) {
            for (BlockPos pos : positions) {
                world.setBlockState(pos, saplingBlock.getDefaultState());
            }
        } else {
            world.setBlockState(centerPos, saplingBlock.getDefaultState());
        }
    }

    private Block getSaplingForLog(BlockState logState) {
        if (logState.isAir()) return Blocks.OAK_SAPLING; // Fallback

        String blockId = Registries.BLOCK.getId(logState.getBlock()).toString();

        if (blockId.equals("minecraft:oak_log") || blockId.equals("minecraft:oak_wood")) {
            return Blocks.OAK_SAPLING;
        }
        if (blockId.equals("minecraft:birch_log") || blockId.equals("minecraft:birch_wood")) {
            return Blocks.BIRCH_SAPLING;
        }
        if (blockId.equals("minecraft:spruce_log") || blockId.equals("minecraft:spruce_wood")) {
            return Blocks.SPRUCE_SAPLING;
        }
        if (blockId.equals("minecraft:jungle_log") || blockId.equals("minecraft:jungle_wood")) {
            return Blocks.JUNGLE_SAPLING;
        }
        if (blockId.equals("minecraft:acacia_log") || blockId.equals("minecraft:acacia_wood")) {
            return Blocks.ACACIA_SAPLING;
        }
        if (blockId.equals("minecraft:dark_oak_log") || blockId.equals("minecraft:dark_oak_wood")) {
            return Blocks.DARK_OAK_SAPLING;
        }
        if (blockId.equals("minecraft:mangrove_log") || blockId.equals("minecraft:mangrove_wood")) {
            return Blocks.MANGROVE_PROPAGULE;
        }
        if (blockId.equals("minecraft:pale_oak_log") || blockId.equals("minecraft:pale_oak_wood")) {
            return Blocks.PALE_OAK_SAPLING;
        }
        if (blockId.equals("minecraft:cherry_log") || blockId.equals("minecraft:cherry_wood")) {
            return Blocks.CHERRY_SAPLING;
        }
        if (blockId.equals("minecraft:crimson_stem") || blockId.equals("minecraft:crimson_hyphae")) {
            return Blocks.CRIMSON_FUNGUS;
        }
        if (blockId.equals("minecraft:warped_stem") || blockId.equals("minecraft:warped_hyphae")) {
            return Blocks.WARPED_FUNGUS;
        }

        String saplingId = blockId
                .replace("_log", "_sapling")
                .replace("_wood", "_sapling")
                .replace("_stem", "_sapling")
                .replace("_hyphae", "_sapling");

        try {
            Identifier saplingIdentifier = Identifier.of(saplingId);
            if (Registries.BLOCK.containsId(saplingIdentifier)) {
                Block foundSapling = Registries.BLOCK.get(saplingIdentifier);
                System.out.println("Found sapling: " + Registries.BLOCK.getId(foundSapling));
                return foundSapling;
            }
        } catch (Exception e) {
            System.out.println("Error finding sapling: " + e.getMessage());
        }

        System.out.println("Using fallback: OAK_SAPLING");
        return Blocks.OAK_SAPLING;
    }

    private Set<BlockPos> getAdjacentPositions(BlockPos center) {
        Set<BlockPos> positions = new HashSet<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (x != 0 || y != 0 || z != 0) {
                        positions.add(center.add(x, y, z));
                    }
                }
            }
        }
        return positions;
    }

    public boolean isAxe(ItemStack stack) {
        Item item = stack.getItem();
        String id = Registries.ITEM.getId(item).getPath();
        return id.endsWith("_axe");
    }
}