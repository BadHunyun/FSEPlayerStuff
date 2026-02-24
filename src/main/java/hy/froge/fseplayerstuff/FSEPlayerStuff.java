package hy.froge.fseplayerstuff;

import com.mojang.logging.LogUtils;
import hy.froge.fseplayerstuff.registeries.ModBlocks;
import hy.froge.fseplayerstuff.registeries.ModCreativeTabs;
import hy.froge.fseplayerstuff.registeries.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(FSEPlayerStuff.MOD_ID)
public class FSEPlayerStuff {
    public static final String MOD_ID = "fseplayerstuff";
    private static final Logger LOGGER = LogUtils.getLogger();

    public FSEPlayerStuff(IEventBus modEventBus, ModContainer modContainer) {
        ModBlocks.DEFERRED_REGISTER.register(modEventBus);
        ModItems.DEFERRED_REGISTER.register(modEventBus);
        ModCreativeTabs.DEFERRED_REGISTER.register(modEventBus);
    }
}
