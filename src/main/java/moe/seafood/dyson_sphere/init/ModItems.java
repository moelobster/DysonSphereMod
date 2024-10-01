package moe.seafood.dyson_sphere.init;

import moe.seafood.dyson_sphere.Dyson_sphere;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ModItems {
    private static final Map<String, Item> ITEM_MAP = new HashMap<>();



//    public static final Item IRON_ORE = registerItem("iron_ore",Item::new,defaultProperties());
//    public static final Item IRON_ORE_BLOCK = registerBlock(ModBlocks.IRON_ORE_BLOCK, BlockItem::new,defaultProperties());

    private static Item registerBlock(Block block, @NotNull BiFunction<Block, Item.Properties, Item> itemCreator, Item.Properties properties) {
        Item item = itemCreator.apply(block, properties);
        ITEM_MAP.put(BuiltInRegistries.BLOCK.getKey(block).getPath(), item);
        return item;
    }
    private static @NotNull Item.Properties defaultProperties() {
        return new Item.Properties();
    }
    private static Item registerItem(String id, @NotNull Function<Item.Properties, Item> itemCreator, Item.Properties properties) {
        Item item = itemCreator.apply(properties);
        ITEM_MAP.put(id, item);
        return item;
    }

    public static void register() {
        for (Map.Entry<String, Item> entry : ModItems.ITEM_MAP.entrySet()) {
            Registry.register(BuiltInRegistries.ITEM, Dyson_sphere.of(entry.getKey()), entry.getValue());
        }
    }
}
