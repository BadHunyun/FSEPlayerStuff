package hy.froge.fse_player_stuff.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static hy.froge.fse_player_stuff.FSEPlayerStuff.location;

public class NorthFishItem extends Item {
    public NorthFishItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemAttributeModifiers getDefaultAttributeModifiers(@NotNull ItemStack stack) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                location("north_fish_dmg"),
                                Integer.MAX_VALUE, AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    /**
     * This is an Easter egg.
     * <p>
     * :P
     * <p>
     * When crafted by player named "MR_ZH_ZX", kill the player.
     */
    @Override
    public void onCraftedBy(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull Player player) {
        if (player.getName().getString().equals("MR_ZH_ZX")) {
            player.sendSystemMessage(Component.literal("You shall not have this item!"));
            player.kill();
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext tooltipContext, @NotNull List<Component> components, @NotNull TooltipFlag tooltipFlag) {
        components.add(Component.translatable("item.fse_player_stuff.north_fish.tooltip"));
        super.appendHoverText(itemStack, tooltipContext, components, tooltipFlag);
    }
}
