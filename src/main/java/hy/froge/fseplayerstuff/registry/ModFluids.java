package hy.froge.fseplayerstuff.registry;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.fluid.immortal.MoltenImmortalFluid;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModFluids {
    public static final DeferredRegister<Fluid> DEFERRED_REGISTER = DeferredRegister.create(Registries.FLUID, FSEPlayerStuff.MOD_ID);

    public static final Map<Holder<Fluid>, String> MOD_FLUIDS = new HashMap<>();

    public static final Holder<Fluid> MOLTEN_IMMORTAL = register("molten_immortal", "Molten Immortal", MoltenImmortalFluid.Source::new);
    public static final Holder<Fluid> FLOWING_MOLTEN_IMMORTAL = register("flowing_molten_immortal", "Flowing Molten Immortal", MoltenImmortalFluid.Flowing::new);

    private static Holder<Fluid> register(String id, String name, Supplier<? extends Fluid> supplier) {
        Holder<Fluid> target = DEFERRED_REGISTER.register(id, supplier);
        MOD_FLUIDS.put(target, name);
        return target;
    }
}
