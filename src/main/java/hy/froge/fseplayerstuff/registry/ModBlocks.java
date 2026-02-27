package hy.froge.fseplayerstuff.registry;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.block.BlockDoll;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> DEFERRED_REGISTER = DeferredRegister.create(Registries.BLOCK, FSEPlayerStuff.MOD_ID);

    public static Map<Holder<Block>, String> MOD_BLOCKS = new HashMap<>();

    // Adamantium
    public static final Holder<Block> ADAMANTIUM_ORE = register("adamantium_ore", "Adamantium Ore", BlockBehaviour.Properties.of());
    public static final Holder<Block> ADAMANTIUM_BLOCK = register("adamantium_block", "Block of Adamantium", BlockBehaviour.Properties.of());
    public static final Holder<Block> RAW_ADAMANTIUM_BLOCK = register("raw_adamantium_block", "Block of Raw Adamantium", BlockBehaviour.Properties.of());

    public static final Holder<Block> BRUST_BLOCK = register("brust_block", "Brust Block", BlockBehaviour.Properties.of().sound(SoundType.NETHERITE_BLOCK).strength(10, 100).requiresCorrectToolForDrops());
    // Compressed Blocks
    public static final Holder<Block> COMPRESSED_NETHERRACK = register("compressed_netherrack", "Compressed Netherrack", BlockBehaviour.Properties.of().sound(SoundType.NETHERRACK).strength(4, 1).requiresCorrectToolForDrops());
    public static final Holder<Block> COMPRESSED_DIAMOND = register("compressed_diamond_block", "Compressed Diamond Block", BlockBehaviour.Properties.of().strength(6, 1).requiresCorrectToolForDrops());
    public static final Holder<Block> COMPRESSED_EMERALD = register("compressed_emerald_block", "Compressed Emerald Block", BlockBehaviour.Properties.of().strength(6, 1).requiresCorrectToolForDrops());
    public static final Holder<Block> COMPRESSED_NETHERITE = register("compressed_netherite_block", "Compressed Netherite Block", BlockBehaviour.Properties.of().strength(10, 100));

    public static final Holder<Block> RAW_IMMORTAL_BLOCK = register("raw_immortal_block", "Raw Immortal Block", BlockBehaviour.Properties.of());
    public static final Holder<Block> IMMORTAL_BLOCK = register("immortal_block", "Block of Immotral", BlockBehaviour.Properties.of());
    public static final Holder<Block> N_FESH_DOLL = register("n_fesh_doll", "N_FeSH Doll", () -> new BlockDoll(BlockBehaviour.Properties.of().destroyTime(3f)));

    private static Holder<Block> register(String id, String name, @NotNull final Supplier<? extends Block> blockSup) {
        Holder<Block> target = DEFERRED_REGISTER.register(id, blockSup);
        MOD_BLOCKS.put(target, name);
        return target;
    }

    private static Holder<Block> register(String id, String name, @NotNull BlockBehaviour.Properties properties) {
        return register(id, name, () -> new Block(properties));
    }
}
