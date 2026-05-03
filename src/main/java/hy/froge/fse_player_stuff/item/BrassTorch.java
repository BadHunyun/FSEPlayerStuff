package hy.froge.fse_player_stuff.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public class BrassTorch extends Item {
    public BrassTorch(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult onItemUseFirst(@NotNull ItemStack itemStack, UseOnContext context) {
        assert context.getPlayer() != null;
        itemStack.consume(itemStack.getCount(), context.getPlayer());

        context.getPlayer().sendSystemMessage(Component.translatable("item.fse_player_stuff.brass_torch.on_use0").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));
        context.getPlayer().sendSystemMessage(Component.translatable("item.fse_player_stuff.brass_torch.on_use1", context.getPlayer().getName().toString()));
        context.getPlayer().sendSystemMessage(Component.translatable("item.fse_player_stuff.brass_torch.on_use2").setStyle(Style.EMPTY.withColor(ChatFormatting.YELLOW)));

        context.getPlayer().hurt(new DamageSources(RegistryAccess.EMPTY).freeze(), Integer.MAX_VALUE);

        return InteractionResult.sidedSuccess(context.getLevel().isClientSide);
    }
}
