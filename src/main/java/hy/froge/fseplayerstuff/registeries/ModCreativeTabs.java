package hy.froge.fseplayerstuff.registeries;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> DEFERRED_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FSEPlayerStuff.MOD_ID);

    public static final Holder<CreativeModeTab> FSE_PLAYER_STUFF = DEFERRED_REGISTER.register("fse_player_stuff", () -> CreativeModeTab.builder()
            .title(Component.literal("FSE Player Stuff"))
            .icon(() -> ModItems.N_FESH_DOLL.value().getDefaultInstance())
            .displayItems((itemDisplayParameters, output) ->
                    ModItems.DEFERRED_REGISTER.getEntries().forEach(k ->
                            output.accept(k.get())))
            .build());
}
