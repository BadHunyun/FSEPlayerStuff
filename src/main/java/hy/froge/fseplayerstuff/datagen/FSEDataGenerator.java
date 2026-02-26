package hy.froge.fseplayerstuff.datagen;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import net.minecraft.WorldVersion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = FSEPlayerStuff.MOD_ID)
public class FSEDataGenerator extends DataGenerator {
    public FSEDataGenerator(Path rootOutputFolder, WorldVersion version, boolean alwaysGenerate) {
        super(rootOutputFolder, version, alwaysGenerate);
    }

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new FSELanguageProvider(output));
        generator.addProvider(event.includeClient(), new FSEModelProvider.ItemProvider(output, existingFileHelper));
    }
}
