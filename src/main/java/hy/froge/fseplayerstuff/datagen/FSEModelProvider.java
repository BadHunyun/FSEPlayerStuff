package hy.froge.fseplayerstuff.datagen;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.registry.ModItems;
import net.minecraft.data.PackOutput;
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
            ModItems.MOD_ITEMS.forEach((k, v) -> {
                basicItem(k.value()); // Waiting for texture.
            });
        }
    }

    public static class StateProvider extends BlockStateProvider {
        public StateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
            super(output, FSEPlayerStuff.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerStatesAndModels() {
        }
    }
}
