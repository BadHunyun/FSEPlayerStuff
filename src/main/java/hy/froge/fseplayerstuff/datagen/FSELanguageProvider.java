package hy.froge.fseplayerstuff.datagen;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.registeries.ModBlocks;
import hy.froge.fseplayerstuff.registeries.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class FSELanguageProvider extends LanguageProvider {
    public FSELanguageProvider(PackOutput output) {
        super(output, FSEPlayerStuff.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ModBlocks.MOD_BLOCKS.forEach((k, v) -> addBlock(k::value, v));
        ModItems.MOD_ITEMS.forEach((k, v) -> addItem(k::value, v));
        add("item.fseplayerstuff.brust_alloy_pickaxe.tooltip", "A Pickaxe");
    }
}
