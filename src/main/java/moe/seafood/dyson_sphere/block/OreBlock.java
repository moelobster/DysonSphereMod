package moe.seafood.dyson_sphere.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class OreBlock extends Block {
    private final int digCount;
    private final Item item;
    public static final IntegerProperty COUNT = IntegerProperty.create("count",0,100);
    public OreBlock(Properties properties, int count, Item item) {
        super(properties);
        this.digCount = count;
        this.item=item;
        this.registerDefaultState(this.defaultBlockState().setValue(COUNT, digCount));
    }
    public int getDigCount() {
        return digCount;
    }
    @Override
    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level,player,blockPos,blockState,blockEntity,itemStack);
        if(!level.isClientSide()){
            int remainCount = blockState.getValue(COUNT);

            if (remainCount > 0){
                level.setBlockAndUpdate(blockPos,blockState.setValue(COUNT,remainCount-1));
            }
        }
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COUNT);
    }
    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(COUNT,digCount);
    }

    public Item getItem() {
        return item;
    }
}
