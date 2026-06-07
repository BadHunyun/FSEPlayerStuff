package hy.froge.fse_player_stuff.block.stationfacility.entity;

import hy.froge.fse_player_stuff.FSERegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class StationManagerBlockEntity extends BlockEntity {
    public StationManagerBlockEntity(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    public StationManagerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(FSERegistry.BlockEntities.STATION_MANAGER.get(), blockPos, blockState);
    }
}
