package hy.froge.fseplayerstuff.registry;

import com.simibubi.create.foundation.data.ModelGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import hy.froge.fseplayerstuff.block.DollBlock;
import hy.froge.fseplayerstuff.item.HugeWrenchItem;
import net.minecraft.world.item.BlockItem;

import static hy.froge.fseplayerstuff.FSEPlayerStuff.REGISTRIES;

public class FSERegistry {
    public static class Items {
        public static final ItemEntry<HugeWrenchItem> HUGE_WRENCH = REGISTRIES.item("huge_wrench", HugeWrenchItem::new).register();

        public static void register() {}
    }

    public static class Blocks {
        public static final BlockEntry<DollBlock> MOD_DOLL = REGISTRIES.block("mod_doll", DollBlock::new)
                .initialProperties(SharedProperties::softMetal)
                .properties(p -> p.strength(2, 5))
                .lang("N_FeSH Doll")
                .item(BlockItem::new)
                .transform(ModelGen.customItemModel())
                .register();

        public static void register() {} // Java is sus.
    }
}
