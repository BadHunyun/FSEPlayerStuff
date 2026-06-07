package hy.froge.fse_player_stuff.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public class BrassTorchItem extends Item {
    public BrassTorchItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult onItemUseFirst(@NotNull ItemStack itemStack, UseOnContext context) {
        Player player = context.getPlayer();
        assert player != null;
        itemStack.consume(itemStack.getCount(), player);

        player.sendSystemMessage(Component.translatable("item.fse_player_stuff.brass_torch.on_use0").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
        player.sendSystemMessage(Component.translatable("item.fse_player_stuff.brass_torch.on_use1", player.getName()));
        player.sendSystemMessage(Component.translatable("item.fse_player_stuff.brass_torch.on_use2").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));

        player.hurt(context.getLevel().damageSources().freeze(), Integer.MAX_VALUE);

        return InteractionResult.sidedSuccess(context.getLevel().isClientSide);
    }
}
