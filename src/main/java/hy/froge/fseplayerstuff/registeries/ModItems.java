package hy.froge.fseplayerstuff.registeries;

import hy.froge.fseplayerstuff.FSEPlayerStuff;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> DEFERRED_REGISTER = DeferredRegister.create(Registries.ITEM, FSEPlayerStuff.MOD_ID);

    public static Map<Holder<Item>, String> MOD_ITEMS = new HashMap<>();

    public static final Holder<Item> N_FESH_DOLL = registerSimpleBlockItem("n_fesh_doll", "N_FeSH Doll", ModBlocks.N_FESH_DOLL, new Item.Properties());

    private static Holder<Item> register(String id, String name, Supplier<? extends Item> supplier) {
        Holder<Item> target = DEFERRED_REGISTER.register(id, supplier);
        MOD_ITEMS.put(target, name);

        return target;
    }

    private static Holder<Item> registerSimpleBlockItem(String id, String name, Holder<Block> blockHolder, Item.Properties itemProp) {
        Holder<Item> target = DEFERRED_REGISTER.register(id, () -> new BlockItem(blockHolder.value(), itemProp));
        MOD_ITEMS.put(target, name);

        return target;
    }
}
