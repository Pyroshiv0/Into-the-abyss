package com.pyroshiv.intotheabyss.worldgen.biomesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

import java.io.Console;
import java.util.stream.Stream;

public class AbyssBiomeSource extends BiomeSource {
    private int compt =10;
    public static final Codec<AbyssBiomeSource> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Biome.CODEC.fieldOf("volcano_crater").forGetter(bs -> bs.volcanoCrater),
            Biome.CODEC.fieldOf("underground_jungle").forGetter(bs -> bs.undergroundJungle),
            Biome.CODEC.fieldOf("abyssal_ocean").forGetter(bs -> bs.abyssalOcean),
            Biome.CODEC.fieldOf("twisted_sea").forGetter(bs -> bs.twistedSea),
            Biome.CODEC.fieldOf("hanging_cliffs").forGetter(bs -> bs.hangingCliffs),
            Biome.CODEC.fieldOf("deep_abyss").forGetter(bs -> bs.deepAbyss),
            Biome.CODEC.fieldOf("deepless_void").forGetter(bs -> bs.deeplessVoid)
    ).apply(instance, AbyssBiomeSource::new));

    private final Holder<Biome> volcanoCrater;
    private final Holder<Biome> undergroundJungle;
    private final Holder<Biome> abyssalOcean;
    private final Holder<Biome> twistedSea;
    private final Holder<Biome> hangingCliffs;
    private final Holder<Biome> deepAbyss;
    private final Holder<Biome> deeplessVoid;

    public AbyssBiomeSource(
            Holder<Biome> volcanoCrater,
            Holder<Biome> undergroundJungle,
            Holder<Biome> abyssalOcean,
            Holder<Biome> twistedSea,
            Holder<Biome> hangingCliffs,
            Holder<Biome> deepAbyss,
            Holder<Biome> deeplessVoid
    ) {
        super();
        this.volcanoCrater = volcanoCrater;
        this.undergroundJungle = undergroundJungle;
        this.abyssalOcean = abyssalOcean;
        this.twistedSea = twistedSea;
        this.hangingCliffs = hangingCliffs;
        this.deepAbyss = deepAbyss;
        this.deeplessVoid = deeplessVoid;
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler sampler) {
        int blockY = y *4 ;//-1776 correspond au miny de ma dim
        if (compt>0) {
            compt--;
            System.out.println("Valeur de blockY: " + blockY);
        }
        if (blockY >= -50 && blockY <= 250)
            return volcanoCrater;
        else if (blockY >= -350 && blockY < -50)
            return undergroundJungle;
        else if (blockY >= -550 && blockY < -350)
            return abyssalOcean;
        else if (blockY >= -700 && blockY < -550)
            return twistedSea;
        else if (blockY >= -1100 && blockY < -700)
            return hangingCliffs;
        else if (blockY >= -1600 && blockY < -1100)
            return deepAbyss;
        else if (blockY >= -1800 && blockY < -1600)
            return deeplessVoid;
        else
            return volcanoCrater;
    }

    @Override
    public Stream<Holder<Biome>> collectPossibleBiomes() {
        return Stream.of(
                volcanoCrater, undergroundJungle, abyssalOcean,
                twistedSea, hangingCliffs, deepAbyss, deeplessVoid
        );
    }
}
