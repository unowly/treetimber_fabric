package dev.unowly.networking.packet;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import static dev.unowly.TreeTimber.MOD_ID;

public record TimberModeS2CPayload(Boolean enabled) implements CustomPayload {
    public static final Identifier TIMBER_MODE_PAYLOAD_ID = Identifier.of(MOD_ID, "timber_mode");
    public static final CustomPayload.Id<TimberModeS2CPayload> ID = new CustomPayload.Id<>(TIMBER_MODE_PAYLOAD_ID);
    public static final PacketCodec<RegistryByteBuf, TimberModeS2CPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.BOOLEAN, TimberModeS2CPayload::enabled, TimberModeS2CPayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
