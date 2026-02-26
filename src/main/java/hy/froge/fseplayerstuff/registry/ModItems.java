package hy.froge.fseplayerstuff.registry;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.item.DiamondAlloyPickaxeItem;
import hy.froge.fseplayerstuff.item.ItemHugeWrench;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> DEFERRED_REGISTER = DeferredRegister.create(Registries.ITEM, FSEPlayerStuff.MOD_ID);

    public static Map<Holder<Item>, String> MOD_ITEMS = new HashMap<>();

    public static final Holder<Item> DIAMOND_ALLOY =
            register(
                    "diamond_alloy_ingot", "Diamond Alloy Ingot", () ->
                            new Item(new Item.Properties())
            );

    public static final Holder<Item> DIAMOND_ALLOY_PICKAXE =
            register("diamond_alloy_pickaxe", "Diamond Alloy Pickaxe", () ->
                    new DiamondAlloyPickaxeItem(
                            new Item.Properties()
                                    .attributes(
                                            PickaxeItem.createAttributes(
                                                    DiamondAlloyPickaxeItem.TIER,
                                                    3f,
                                                    4f
                                            )
                                    )
                    )
            );

    public static final Holder<Item> N_FESH_DOLL =
            registerSimpleBlockItem("n_fesh_doll",
                    ModBlocks.N_FESH_DOLL,
                    new Item.Properties()
            );

    public static final Holder<Item> HUGE_WRENCH =
            register("huge_wrench", "Huge Wrench", () ->
                    new ItemHugeWrench(new Item.Properties()
                            .rarity(Rarity.EPIC)
                            .durability(1)
                    )
            );

    private static Holder<Item> register(String id, String name, @NotNull final Supplier<? extends Item> supplier) {
        Holder<Item> target = DEFERRED_REGISTER.register(id, supplier);
        MOD_ITEMS.put(target, name);
        return target;
    }

    private static Holder<Item> registerSimpleBlockItem(String id, @NotNull final Holder<Block> blockHolder, Item.Properties itemProp) {
        return DEFERRED_REGISTER.register(id, () -> new BlockItem(blockHolder.value(), itemProp));
    }
}
