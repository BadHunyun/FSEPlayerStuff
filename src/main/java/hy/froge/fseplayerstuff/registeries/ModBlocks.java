package hy.froge.fseplayerstuff.registeries;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.block.BlockDoll;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> DEFERRED_REGISTER = DeferredRegister.create(Registries.BLOCK, FSEPlayerStuff.MOD_ID);

    public static final Holder<Block> N_FESH_DOLL = register("n_fesh_doll", () -> new BlockDoll(BlockBehaviour.Properties.of().destroyTime(3f)));

    private static Holder<Block> register(String id, Supplier<? extends Block> supplier) {
        return DEFERRED_REGISTER.register(id, supplier).getDelegate();
    }
}
