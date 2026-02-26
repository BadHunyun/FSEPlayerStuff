package hy.froge.fseplayerstuff.registry;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModLiquids {
    public static final DeferredRegister<Fluid> DEFERRED_REGISTER = DeferredRegister.create(Registries.FLUID, FSEPlayerStuff.MOD_ID);
    public static Map<Holder<Block>, String> MOD_LIQUIDS = new HashMap<>();

    public static final Holder<Fluid> MOLTEN_IMMORTAL = register("molten_immortal", "Molten Immortal", () -> new LiquidBlock(Fluids.FLOWING_LAVA, BlockBehaviour.Properties.of()));


    private static Holder<Fluid> register(String id, String name, Supplier<? extends LiquidBlock> supplier) {
        Holder<LiquidBlock> target = DEFERRED_REGISTER.register(id, supplier);
        return DEFERRED_REGISTER.register(id, supplier);
    }
}
