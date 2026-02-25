package hy.froge.fseplayerstuff.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemBrustAlloyPickaxe extends PickaxeItem {
    public ItemBrustAlloyPickaxe(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipContext, @NotNull List<Component> components, @NotNull TooltipFlag tooltipFlag) {
        components.add(Component.translatable("item.fseplayerstuff.brust_alloy_pickaxe.tooltip"));

        super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
    }
}
