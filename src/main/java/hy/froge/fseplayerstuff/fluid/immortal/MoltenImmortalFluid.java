package hy.froge.fseplayerstuff.fluid.immortal;

import hy.froge.fseplayerstuff.registry.ModBlocks;
import hy.froge.fseplayerstuff.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public abstract class MoltenImmortalFluid extends FlowingFluid {
    @Override
    public @NotNull Fluid getFlowing() {
        return new Flowing();
    }

    @Override
    public @NotNull Fluid getSource() {
        return new Source();
    }

    @Override
    public @NotNull Item getBucket() {
        return ModItems.IMMORTAL_BUCKET.value();
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
        return 1;
    }

    @Override
    protected int getDropOff(@NotNull LevelReader levelReader) {
        return 1;
    }

    @Override
    public int getTickDelay(@NotNull LevelReader levelReader) {
        return (levelReader.getHeight() <= 35) ? 5 : 10;
    }

    @Override
    protected boolean canBeReplacedWith(@NotNull FluidState fluidState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull Fluid fluid, @NotNull Direction direction) {
        return false;
    }

    @Override
    protected float getExplosionResistance() {
        return 2;
    }

    @Override
    public @NotNull Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL_LAVA);
    }

    @Override
    protected @NotNull BlockState createLegacyBlock(@NotNull FluidState fluidState) {
        return ModBlocks.MOLTEN_IMMORTAL.value().defaultBlockState().setValue(LiquidBlock.LEVEL, getLegacyLevel(fluidState));
    }

    @Override
    public boolean isSource(@NotNull FluidState fluidState) {
        return false;
    }

    @Override
    public int getAmount(@NotNull FluidState fluidState) {
        return 0;
    }

    @Override
    public float getExplosionResistance(@NotNull FluidState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Explosion explosion) {
        return (explosion.center().distanceTo(pos.getCenter()) <= 1.00) ? 0 : 1;
    }

    public static class Source extends MoltenImmortalFluid {
        @Override
        public boolean isSource(@NotNull FluidState fluidState) {
            return true;
        }

        @Override
        public int getAmount(@NotNull FluidState fluidState) {
            return 2;
        }
    }

    public static class Flowing extends MoltenImmortalFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.@NotNull Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }
    }
}
