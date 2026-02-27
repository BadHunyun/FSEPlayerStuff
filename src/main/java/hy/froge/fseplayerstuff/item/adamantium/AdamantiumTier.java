package hy.froge.fseplayerstuff.item.adamantium;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class AdamantiumTier {
    public static final Tier TIER = new Tier() {
        @Override
        public int getUses() {
            return 256;
        }

        @Override
        public float getSpeed() {
            return 3;
        }

        @Override
        public float getAttackDamageBonus() {
            return 1;
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return null;
        }

        @Override
        public int getEnchantmentValue() {
            return 1;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return null;
        }
    };
}
