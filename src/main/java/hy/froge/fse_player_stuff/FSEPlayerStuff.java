package hy.froge.fse_player_stuff;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(FSEPlayerStuff.MOD_ID)
public class FSEPlayerStuff {
    public static final String MOD_ID = "fse_player_stuff";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FSEPlayerStuff(IEventBus modEventBus, ModContainer modContainer) {
        FSERegistry.registerAll(modEventBus);
    }

    public static ResourceLocation location(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}
