package hy.froge.fse_player_stuff.block.stationfacility;

import com.mojang.serialization.MapCodec;
import hy.froge.fse_player_stuff.block.stationfacility.entity.StationManagerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StationManagerBlock extends HorizontalDirectionalBlock implements EntityBlock {
    public final MapCodec<StationManagerBlock> CODEC = simpleCodec(StationManagerBlock::new);

    public StationManagerBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new StationManagerBlockEntity(blockPos, blockState);
    }
}
