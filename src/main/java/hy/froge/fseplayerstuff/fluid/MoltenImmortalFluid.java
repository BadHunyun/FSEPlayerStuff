package hy.froge.fseplayerstuff.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

public class MoltenImmortalFluid extends FlowingFluid {
    @Override
    public @NotNull Fluid getFlowing() {
        return null;
    }

    @Override
    public @NotNull Fluid getSource() {
        return null;
    }

    @Override
    protected boolean canConvertToSource(@NotNull Level level) {
        return false;
    }

    @Override
    protected void beforeDestroyingBlock(@NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {

    }

    @Override
    protected int getSlopeFindDistance(@NotNull LevelReader levelReader) {
        return 0;
    }

    @Override
    protected int getDropOff(@NotNull LevelReader levelReader) {
        return 0;
    }

    @Override
    public @NotNull Item getBucket() {
        return null;
    }

    @Override
    protected boolean canBeReplacedWith(@NotNull FluidState fluidState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull Fluid fluid, @NotNull Direction direction) {
        return false;
    }

    @Override
    public int getTickDelay(@NotNull LevelReader levelReader) {
        return 0;
    }

    @Override
    protected float getExplosionResistance() {
        return 0;
    }

    @Override
    protected @NotNull BlockState createLegacyBlock(@NotNull FluidState fluidState) {
        return null;
    }

    @Override
    public boolean isSource(@NotNull FluidState fluidState) {
        return false;
    }

    @Override
    public int getAmount(@NotNull FluidState fluidState) {
        return 0;
    }
}
