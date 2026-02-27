package hy.froge.fseplayerstuff.item.brust;

import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

public class BrustTier {
    public static final Tier TIER = new Tier() {
        @Override
        public int getUses() {
            return 250;
        }

        @Override
        public float getSpeed() {
            return 6;
        }

        @Override
        public float getAttackDamageBonus() {
            return 2;
        }

        @Override
        public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.AIR;
        }

        @Override
        public int getEnchantmentValue() {
            return 14;
        }

        @Override
        public @NotNull Ingredient getRepairIngredient() {
            return Ingredient.of(Tags.Items.INGOTS);
        }
    };
}
