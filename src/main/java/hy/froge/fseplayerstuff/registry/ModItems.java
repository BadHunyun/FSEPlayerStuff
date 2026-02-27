package hy.froge.fseplayerstuff.registry;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import hy.froge.fseplayerstuff.item.HugeWrenchItem;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> DEFERRED_REGISTER = DeferredRegister.create(Registries.ITEM, FSEPlayerStuff.MOD_ID);

    public static Map<Holder<Item>, String> MOD_ITEMS = new HashMap<>();

    // Adamantium
    public static final Holder<Item> RAW_ADAMANTIUM = register("raw_adamantium", "Raw Adamantium", () -> new Item(new Item.Properties()));
    public static final Holder<Item> ADAMANTIUM_INGOT = register("adamantium_ingot", "Adamantium Ingot", () -> new Item(new Item.Properties()));
    public static final Holder<Item> ADAMANTIUM_DUST = register("adamantium_dust", "Adamantium Dust", () -> new Item(new Item.Properties()));
    public static final Holder<Item> ADAMANTIUM_NIGGET = register("adamantium_nugget", "Adamantium Nugget", () -> new Item(new Item.Properties()));
    public static final Holder<Item> ADAMANTIUM_UPGRADE_SMITHING_TEMPLATE = registerSimpleItem("adamantium_upgrade_smithing_template", "Adamantium Upgrade Smithing Template");

    // Other
    public static final Holder<Item> COMPRESSED_NETHERRACK = registerSimpleBlockItem("compressed_netherrack", ModBlocks.COMPRESSED_NETHERRACK);
    public static final Holder<Item> CREST_UPGRADE_SMITHING_TEMPLATE = registerSimpleItem("crest_upgrade_smithing_template", "Crest Upgrade Smithing Template");
    public static final Holder<Item> DRACONIC_TWIN_SWORD = register("draconic_twin_sword", "Draconic Twin Sword", () -> new SwordItem(Tiers.NETHERITE, new Item.Properties()));
    public static final Holder<Item> DREAM_FLAYER = register("dreamflayer", "Dreamflayer", () -> new SwordItem(Tiers.NETHERITE, new Item.Properties()));
    public static final Holder<Item> ECHO_SHADOW = register("echo_shadow", "Echo Shadow", () -> new HoeItem(Tiers.NETHERITE, new Item.Properties()));
    public static final Holder<Item> ENDNESS = register("endness", "Endness", () -> new SwordItem(Tiers.NETHERITE, new Item.Properties()));
    public static final Holder<Item> FORGED_UPGRADE_SMITHING_TEMPLATE = registerSimpleItem("forged_upgrade_smithing_template", "Forged Upgrade Smithing Template");
    public static final Holder<Item> FORK_CORE = registerSimpleItem("fork_core", "Fork Core");
    public static final Holder<Item> GLASS_CREST = registerSimpleItem("glass_crest", "Glass Crest");
    public static final Holder<Item> GLASS_CREST_CORE = registerSimpleItem("glass_crest_core", "Glass Crest Core");
    public static final Holder<Item> GRAVE_DIGGER = register("grave_digger", "Grave \"Digger\"", () -> new PickaxeItem(Tiers.NETHERITE, new Item.Properties()));
    public static final Holder<Item> HEAVY_UPGRADE_SMITHING_TEMPLATE = registerSimpleItem("heavy_upgrade_smithing_template", "Heavy Upgrade Smithing Template");
    public static final Holder<Item> HIGH_PERFORMANCE_EXPLOSIVE = registerSimpleItem("high_performance_explosive", "High-Performance Explosive");
    public static final Holder<Item> HUGE_WRENCH = register("huge_wrench", "Huge Wrench", () -> new HugeWrenchItem(new Item.Properties().rarity(Rarity.EPIC).durability(1)));
    public static final Holder<Item> MALACHITE_REAT_SWORD = register("malachite_reat_sword", "Malachite Rest Sword", () -> new SwordItem(Tiers.NETHERITE, new Item.Properties()));
    public static final Holder<Item> MIRROR_CORE = registerSimpleItem("mirror_core", "Mirror Core");
    public static final Holder<Item> N_FESH_DOLL = registerSimpleBlockItem("n_fesh_doll", ModBlocks.N_FESH_DOLL);
    public static final Holder<Item> NIGHT_CREST = registerSimpleItem("night_crest", "Night Crest");
    public static final Holder<Item> NIGHTMARE = register("nightmare", "Nightmare", () -> new AxeItem(Tiers.NETHERITE, new Item.Properties()));
    public static final Holder<Item> OCEAN_UPGRADE_SMITHING_TEMPLATE = registerSimpleItem("ocean_upgrade_smithing_template", "Ocean Upgrade Smithing Template");
    public static final Holder<Item> SOUL_SEVERING_PICKAXE = register("soul_severing_pickaxe", "Soul Severing Pickaxe", () -> new PickaxeItem(Tiers.NETHERITE, new Item.Properties()));
    public static final Holder<Item> TIO_UPGRADE_SMITHING_TEMPLATE = registerSimpleItem("three_in_one_upgrade_smithing_template", "3 in 1 Upgrade Smithing template");
    public static final Holder<Item> TRIDENT_HEAD = registerSimpleItem("trident_head", "Trident Head");
    public static final Holder<Item> UPGRADE_CORE = registerSimpleItem("upgrade_core", "Upgrade Core");

    private static Holder<Item> register(String id, String name, @NotNull final Supplier<? extends Item> supplier) {
        Holder<Item> target = DEFERRED_REGISTER.register(id, supplier);
        MOD_ITEMS.put(target, name);
        return target;
    }

    private static Holder<Item> registerSimpleItem(String id, String name) {
        return register(id, name, () -> new Item(new Item.Properties()));
    }

    private static Holder<Item> registerBlockItem(String id, @NotNull Holder<Block> blockHolder, Item.Properties itemProp) {
        return DEFERRED_REGISTER.register(id, () -> new BlockItem(blockHolder.value(), itemProp));
    }

    private static Holder<Item> registerSimpleBlockItem(String id, @NotNull final Holder<Block> blockHolder) {
        return DEFERRED_REGISTER.register(id, () -> new BlockItem(blockHolder.value(), new Item.Properties()));
    }
}
