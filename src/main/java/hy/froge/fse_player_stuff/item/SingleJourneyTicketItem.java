package hy.froge.fse_player_stuff.item;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;

public class SingleJourneyTicketItem extends Item {
    public static final Codec<SingleJourneyTicketComponent> COMPONENT_CODEC = RecordCodecBuilder.create(i ->
            i.group(
                    Codec.STRING.fieldOf("from").forGetter(SingleJourneyTicketComponent::from),
                    Codec.STRING.fieldOf("to").forGetter(SingleJourneyTicketComponent::to)
            ).apply(i, SingleJourneyTicketComponent::new)
    );

    public static final StreamCodec<ByteBuf, SingleJourneyTicketComponent> COMPONENT_STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8, SingleJourneyTicketComponent::from,
            ByteBufCodecs.STRING_UTF8, SingleJourneyTicketComponent::to,
            SingleJourneyTicketComponent::new
    );

    public SingleJourneyTicketItem(Properties properties) {
        super(properties);
    }

    public record SingleJourneyTicketComponent(String from, String to) {

    }
}
