package hy.froge.fseplayerstuff.registry;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.block.BlockDoll;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> DEFERRED_REGISTER = DeferredRegister.create(Registries.BLOCK, FSEPlayerStuff.MOD_ID);

    public static Map<Holder<Block>, String> MOD_BLOCKS = new HashMap<>();

    public static final Holder<Block> MOD_DOLL = register("mod_doll", "N_FeSH's Doll", () -> new BlockDoll(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));

    private static Holder<Block> register(String id, String name, @NotNull final Supplier<? extends Block> blockSup) {
        Holder<Block> target = DEFERRED_REGISTER.register(id, blockSup);
        MOD_BLOCKS.put(target, name);
        return target;
    }

    private static Holder<Block> register(String id, String name, @NotNull BlockBehaviour.Properties properties) {
        return register(id, name, () -> new Block(properties));
    }
}
