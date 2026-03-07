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

    public static final Holder<Item> MOD_DOLL = registerSimpleBlockItem("mod_doll", ModBlocks.MOD_DOLL);
    public static final Holder<Item> HUGE_WRENCH = register("huge_wrench", "Huge Wrench", () -> new HugeWrenchItem(new Item.Properties()));

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
        return registerBlockItem(id, blockHolder, new Item.Properties());
    }
}
