package moe.seafood.dyson_sphere.init;

import moe.seafood.dyson_sphere.Dyson_sphere;
import moe.seafood.dyson_sphere.block.OreBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;

public class ModBlocks {
    private static final Map<String, Block> BLOCK_MAP = new HashMap<>();
//    public static final Block IRON_ORE_BLOCK = registerBlock("iron_ore_block",(properties)->new OreBlock(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK),40),BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK));

    public static void register() {
        for (Map.Entry<String, Block> entry : ModBlocks.BLOCK_MAP.entrySet()) {
            Registry.register(BuiltInRegistries.BLOCK, Dyson_sphere.of(entry.getKey()), entry.getValue());
        }
    }

    private static Block registerBlock(String id, @NotNull Function<BlockBehaviour.Properties, Block> blockCreator, BlockBehaviour.Properties properties) {
        Block block = blockCreator.apply(properties);
        BLOCK_MAP.put(id, block);
        return block;
    }
}
