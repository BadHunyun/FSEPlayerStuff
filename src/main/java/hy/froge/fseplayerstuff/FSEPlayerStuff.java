package hy.froge.fseplayerstuff;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import hy.froge.fseplayerstuff.registry.*;
import net.createmod.catnip.lang.FontHelper;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(FSEPlayerStuff.MOD_ID)
public class FSEPlayerStuff {
    public static final String MOD_ID = "fseplayerstuff";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final CreateRegistrate REGISTRIES = CreateRegistrate.create(MOD_ID)
            .defaultCreativeTab(ModCreativeTabs.KEY)
            .setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE));



    public FSEPlayerStuff(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeTabs.register(modEventBus);
        REGISTRIES.registerEventListeners(modEventBus);
        FSERegistry.Blocks.register();
        FSERegistry.Items.register();
    }
}
