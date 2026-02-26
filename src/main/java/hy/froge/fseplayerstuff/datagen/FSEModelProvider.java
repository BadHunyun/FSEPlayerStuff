package hy.froge.fseplayerstuff.datagen;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.registry.ModBlocks;
import hy.froge.fseplayerstuff.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class FSEModelProvider {
    public static class ItemProvider extends ItemModelProvider {
        public ItemProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
            super(output, FSEPlayerStuff.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerModels() {
            basicItem(ModItems.CREST_UPGRADE_SMITHING_TEMPLATE.value());
            // Required Texture
//            basicItem(ModItems.DIAMOND_ALLOY.value());
//            basicItem(ModItems.DIAMOND_ALLOY_PICKAXE.value());
            basicItem(ModItems.DRACONIC_TWIN_SWORD.value());
            basicItem(ModItems.DREAM_FLAYER.value());
            basicItem(ModItems.ECHO_SHADOW.value());
            basicItem(ModItems.ENDNESS.value());
            basicItem(ModItems.FORGED_UPGRADE_SMITHING_TEMPLATE.value());
            basicItem(ModItems.FORK_CORE.value());
            basicItem(ModItems.GLASS_CREST.value());
            basicItem(ModItems.GLASS_CREST_CORE.value());
            basicItem(ModItems.HEAVY_UPGRADE_SMITHING_TEMPLATE.value());
            basicItem(ModItems.MALACHITE_REAT_SWORD.value());
            basicItem(ModItems.MIRROR_CORE.value());
            basicItem(ModItems.NIGHT_CREST.value());
            basicItem(ModItems.NIGHTMARE.value());
            basicItem(ModItems.OCEAN_UPGRADE_SMITHING_TEMPLATE.value());
            basicItem(ModItems.SOUL_SEVERING_PICKAXE.value());
            basicItem(ModItems.TIO_UPGRADE_SMITHING_TEMPLATE.value());
            basicItem(ModItems.TRIDENT_HEAD.value());
            basicItem(ModItems.UPGRADE_CORE.value());
        }
    }

    public static class StateProvider extends BlockStateProvider {
        public StateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
            super(output, FSEPlayerStuff.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerStatesAndModels() {
            simpleBlockWithItem(ModBlocks.COMPRESSED_NETHERRACK.value(), cubeAll(ModBlocks.COMPRESSED_NETHERRACK.value()));
        }
    }
}
