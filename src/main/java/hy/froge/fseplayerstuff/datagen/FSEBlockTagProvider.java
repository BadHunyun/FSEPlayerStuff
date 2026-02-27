package hy.froge.fseplayerstuff.datagen;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class FSEBlockTagProvider extends BlockTagsProvider {
    public FSEBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FSEPlayerStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.COMPRESSED_DIAMOND.value())
                .add(ModBlocks.COMPRESSED_EMERALD.value())
                .add(ModBlocks.COMPRESSED_NETHERITE.value())
                .add(ModBlocks.COMPRESSED_NETHERRACK.value())
                .add(ModBlocks.BRUST_BLOCK.value());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.COMPRESSED_DIAMOND.value())
                .add(ModBlocks.COMPRESSED_EMERALD.value());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.COMPRESSED_NETHERITE.value())
                .add(ModBlocks.BRUST_BLOCK.value());
    }
}
