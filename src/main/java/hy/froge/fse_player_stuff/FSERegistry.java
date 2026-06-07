package hy.froge.fse_player_stuff;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import hy.froge.fse_player_stuff.block.CircuitStackBlock;
import hy.froge.fse_player_stuff.block.apg.ElectricFence;
import hy.froge.fse_player_stuff.block.apg.ElectricFenceGate;
import hy.froge.fse_player_stuff.block.stationfacility.StationManagerBlock;
import hy.froge.fse_player_stuff.block.stationfacility.entity.StationManagerBlockEntity;
import hy.froge.fse_player_stuff.item.BrassTorchItem;
import hy.froge.fse_player_stuff.item.NorthFishItem;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static hy.froge.fse_player_stuff.FSEPlayerStuff.MOD_ID;

public class FSERegistry {
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID)
            .defaultCreativeTab(Objects.requireNonNull(CreativeTabs.MOD_TAB.getKey()));
    private static final Logger LOGGER = LoggerFactory.getLogger(FSERegistry.class);


    public static class Blocks {
        public static void register() {
            LOGGER.info("Registering Blocks...");
        }

        public static final BlockEntry<ElectricFence> ELECTRIC_FENCE = REGISTRATE
                .block("electric_fence", ElectricFence::new)
                .simpleItem()
                .lang("Electric Fence")
                .register();
        public static final BlockEntry<ElectricFenceGate> ELECTRIC_FENCE_GATE = REGISTRATE
                .block("electric_fence_gate", ElectricFenceGate::new)
                .simpleItem()
                .lang("Electric Fence Gate")
                .register();

        public static final BlockEntry<StationManagerBlock> STATION_MANAGER = REGISTRATE
                .block("station_manager", StationManagerBlock::new)
                .lang("Station Manager")
                .register();

        public static final BlockEntry<CircuitStackBlock> SILICON_CIRCUIT_STACK = REGISTRATE
                .block("silicon_base_stack", CircuitStackBlock::new)
                .lang("Silicon Base Stack")
                .simpleItem()
                .register();

        public static final BlockEntry<CircuitStackBlock> ENGINEERING_CIRCUIT_STACK = REGISTRATE
                .block("engineering_base_stack", CircuitStackBlock::new)
                .lang("Engineering Base Stack")
                .simpleItem()
                .register();

        public static final BlockEntry<CircuitStackBlock> LOGIC_CIRCUIT_STACK = REGISTRATE
                .block("logic_base_stack", CircuitStackBlock::new)
                .lang("Logic Base Stack")
                .simpleItem()
                .register();

        public static final BlockEntry<CircuitStackBlock> CALCULATE_CIRCUIT_STACK = REGISTRATE
                .block("calculate_base_stack", CircuitStackBlock::new)
                .lang("Calculate Base Stack")
                .simpleItem()
                .register();

    }

    public static class BlockEntities {
        public static void register() {
            LOGGER.info("Registering Block Entities...");
        }

        public static final BlockEntityEntry<BlockEntity> STATION_MANAGER = REGISTRATE
                .blockEntity("station_manager", StationManagerBlockEntity::new)
                .validBlocks(Blocks.STATION_MANAGER)
                .register();
    }

    public static class Items {
        public static void register() {
            LOGGER.info("Registering Items...");
        }

        public static final ItemEntry<NorthFishItem> NORTH_FISH = REGISTRATE
                .item("north_fish", NorthFishItem::new)
                .lang("North Fish")
                .register();

        public static final ItemEntry<BrassTorchItem> BRASS_TORCH = REGISTRATE
                .item("brass_torch", BrassTorchItem::new)
                .lang("Brass Torch")
                .register();
    }

    public static class Fluids {
        public static void register() {
            LOGGER.info("Registering Fluids...");
        }
    }

    public static class CreativeTabs {
        public static void register(IEventBus bus) {
            CREATIVE_TABS.register(bus);
        }

        private static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

        private static final @NotNull Holder<CreativeModeTab> MOD_TAB = CREATIVE_TABS.register(MOD_ID, () ->
                CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup.fse_player_stuff"))
                        .build());
    }

    public static void registerAll(IEventBus bus) {
        REGISTRATE.setModEventBus(bus);
        BlockEntities.register();
        Blocks.register();
        Fluids.register();
        Items.register();
        CreativeTabs.register(bus);
    }
}
