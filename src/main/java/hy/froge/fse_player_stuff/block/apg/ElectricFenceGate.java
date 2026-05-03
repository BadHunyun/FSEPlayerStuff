package hy.froge.fse_player_stuff.block.apg;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElectricFenceGate extends Block {
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;
    public static final EnumProperty<Side> SIDE = EnumProperty.create("side", Side.class);
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    protected static final VoxelShape EAST_UNOPENED_AABB = Block.box(0.00,2.00,1.00,16.00,14.00,4.00);

    public ElectricFenceGate(Properties properties) {
        super(properties);
    }


    @Override
    public boolean canConnectRedstone(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @Nullable Direction direction) {
        return true;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection())
                .setValue(SIDE, Side.LEFT)
                .setValue(OPEN, false);
    }

    @Override
    protected @NotNull InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult blockHitResult) {
        blockState = blockState.cycle(OPEN);
        level.setBlock(blockPos, blockState, 10);
        level.gameEvent(player, blockState.getValue(OPEN) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, blockPos);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> blockStateBuilder) {
        blockStateBuilder.add(FACING, SIDE, OPEN);
    }

    public enum Side implements StringRepresentable {
        LEFT("left"), RIGHT("right");

        private final String side;

        Side(String side) {
            this.side = side;
        }

        @Override
        public @NotNull String getSerializedName() {
            return this.side;
        }
    }
}
