package hy.froge.fseplayerstuff.item;

import hy.froge.fseplayerstuff.registry.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class DiamondAlloyPickaxeItem extends PickaxeItem {
    public static final Tier TIER = new Tier() {
        @Override
        public int getUses() {
            return 4096;
        }

        @Override
        public float getSpeed() {
            return 3;
        }

        @Override
        public float getAttackDamageBonus() {
            return 0;
        }

        @Override
        public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.AIR;
        }

        @Override
        public int getEnchantmentValue() {
            return 42;
        }

        @Override
        public @NotNull Ingredient getRepairIngredient() {
            return Ingredient.of(ModItems.DIAMOND_ALLOY.value());
        }
    };

    public DiamondAlloyPickaxeItem(Properties properties) {
        super(TIER, properties);
    }
}
