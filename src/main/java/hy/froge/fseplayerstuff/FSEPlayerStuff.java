package hy.froge.fseplayerstuff;

import com.mojang.logging.LogUtils;
import hy.froge.fseplayerstuff.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(FSEPlayerStuff.MOD_ID)
public class FSEPlayerStuff {
    public static final String MOD_ID = "fseplayerstuff";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FSEPlayerStuff(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeTabs.register(modEventBus);
        FSERegistry.register(modEventBus);
    }
}
