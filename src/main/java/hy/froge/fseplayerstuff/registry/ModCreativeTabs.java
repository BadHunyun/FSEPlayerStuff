package hy.froge.fseplayerstuff.registry;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    private static final DeferredRegister<CreativeModeTab> DEFERRED_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FSEPlayerStuff.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FSE_PLAYER_STUFF = DEFERRED_REGISTER.register("fse_player_stuff", () ->
            CreativeModeTab.builder()
                    .title(Component.literal("FSE Player Stuff"))
                    .icon(FSERegistry.Blocks.MOD_DOLL::asStack)
                    .build());

    public static final ResourceKey<CreativeModeTab> KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB, ResourceLocation.fromNamespaceAndPath(
                    FSEPlayerStuff.MOD_ID, "fse_player_stuff"
            )
    );

    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTER.register(eventBus);
    }
}
