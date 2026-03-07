package hy.froge.fseplayerstuff.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.block.DollBlock;
import hy.froge.fseplayerstuff.item.HugeWrenchItem;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;

public class FSERegistry {
    static final CreateRegistrate REGISTRIES = CreateRegistrate.create(FSEPlayerStuff.MOD_ID);

    static {
        REGISTRIES.setCreativeTab((DeferredHolder<CreativeModeTab, CreativeModeTab>) ModCreativeTabs.FSE_PLAYER_STUFF);
        REGISTRIES.setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE));
    }

    public static void register(IEventBus eventBus) {
        REGISTRIES.registerEventListeners(eventBus);
    }

    public static class Items {
        public static final ItemEntry<?> HUGE_WRENCH = REGISTRIES.item("huge_wrench", HugeWrenchItem::new).register();
    }

    public static class Blocks {
        public static final BlockEntry<?> MOD_DOLL = REGISTRIES.block("mod_doll", DollBlock::new).initialProperties(() -> net.minecraft.world.level.block.Blocks.WHITE_WOOL).properties(p -> p.strength(2, 5)).lang("N_FeSH Doll").register();
    }
}
