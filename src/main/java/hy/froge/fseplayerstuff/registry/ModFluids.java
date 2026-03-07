package hy.froge.fseplayerstuff.registry;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModFluids {

    public static class Fluids {
        public static final DeferredRegister<Fluid> DEFERRED_REGISTER = DeferredRegister.create(Registries.FLUID, FSEPlayerStuff.MOD_ID);
        public static final Map<Holder<Fluid>, String> MOD_FLUIDS = new HashMap<>();

        private static Holder<Fluid> register(String id, String name, Supplier<? extends Fluid> supplier) {
            Holder<Fluid> target = DEFERRED_REGISTER.register(id, supplier);
            MOD_FLUIDS.put(target, name);
            return target;
        }

        private static class FluidProperties {
        }
    }

    public static class FluidTypes {
        public static final DeferredRegister<FluidType> DEFERRED_REGISTER = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, FSEPlayerStuff.MOD_ID);
        public static final Map<Holder<FluidType>, String> MOD_FLUID_TYPES = new HashMap<>();

        private static Holder<FluidType> register(String id, String name, Supplier<? extends FluidType> supplier) {
            Holder<FluidType> target = DEFERRED_REGISTER.register(id, supplier);
            MOD_FLUID_TYPES.put(target, name);
            return target;
        }
    }


}
