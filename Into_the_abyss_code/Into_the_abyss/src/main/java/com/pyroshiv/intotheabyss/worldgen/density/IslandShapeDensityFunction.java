package com.pyroshiv.intotheabyss.worldgen.density;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.util.Mth;
import net.minecraft.world.level.levelgen.DensityFunction;



public class IslandShapeDensityFunction implements DensityFunction {

    public static final KeyDispatchDataCodec<IslandShapeDensityFunction> CODEC =
            KeyDispatchDataCodec.of(
                    RecordCodecBuilder.create(instance -> instance.group(
                            Codec.DOUBLE.optionalFieldOf("outer_radius", 1000.0).forGetter(f -> f.outerRadius),
                            Codec.DOUBLE.optionalFieldOf("plateau_radius", 500.0).forGetter(f -> f.plateauRadius), // Nouveau: rayon du plateau
                            Codec.DOUBLE.optionalFieldOf("plateau_height", 1.0).forGetter(f -> f.plateauHeight), // Nouveau: hauteur relative du plateau (densité max)
                            Codec.DOUBLE.optionalFieldOf("base_height", 0.0).forGetter(f -> f.baseHeight) // Nouveau: hauteur relative de la base (densité min)
                    ).apply(instance, IslandShapeDensityFunction::new))
            );

    private final double outerRadius;
    private final double plateauRadius;
    private final double plateauHeight;
    private final double baseHeight;

    public IslandShapeDensityFunction(double outerRadius, double plateauRadius, double plateauHeight, double baseHeight) {
        this.outerRadius = outerRadius;
        this.plateauRadius = plateauRadius;
        this.plateauHeight = plateauHeight;
        this.baseHeight = baseHeight;
    }

    @Override
    public double compute(FunctionContext context) {
        double x = context.blockX();
        double z = context.blockZ();
        double dist = Math.sqrt(x * x + z * z);

        if (dist <= plateauRadius) {
            // Dans le rayon du plateau, la densité est constante (plateauHeight)
            return plateauHeight;
        } else if (dist < outerRadius) {
            // Dans la zone de transition (pente)
            double normalizedSlopeDist = (dist - plateauRadius) / (outerRadius - plateauRadius);
            // Interpolation linéaire entre plateauHeight et baseHeight
            return Mth.lerp(normalizedSlopeDist, plateauHeight, baseHeight); // Erreur: Devrait être baseHeight, plateauHeight pour une descente
            // Correction:
            // return Mth.lerp(normalizedSlopeDist, plateauHeight, baseHeight);
            // En fait, Mth.lerp(t, min, max) fait min + t * (max - min)
            // Pour une descente de plateauHeight à baseHeight, il faut que quand normalizedSlopeDist est 0, on ait plateauHeight,
            // et quand normalizedSlopeDist est 1, on ait baseHeight.
            // Donc, return Mth.lerp(normalizedSlopeDist, plateauHeight, baseHeight); est correct si plateauHeight > baseHeight.
            // Sinon, pour une descente: plateauHeight - normalizedSlopeDist * (plateauHeight - baseHeight)
            // Ou plus simplement, Mth.lerp est bien pour l'interpolation.
            // Le problème est que la pente doit aller de plateau_height à base_height.
            // Si plateauHeight = 1.0 et baseHeight = 0.0:
            // dist = plateauRadius -> normalizedSlopeDist = 0 -> return 1.0
            // dist = outerRadius - epsilon -> normalizedSlopeDist = 1 -> return 0.0
            // C'est déjà ce que fait Mth.lerp(t, start, end).
            // Donc la formule est OK pour une descente linéaire.

            // Alternative pour une pente plus complexe, comme Mth.clamp(1.0 - normalizedSlopeDist, 0.0, 1.0)
            // Mais Mth.lerp est bon pour une pente linéaire.
        } else {
            // Au-delà du rayon externe, la densité est minimale (baseHeight)
            return baseHeight;
        }
    }

    @Override
    public void fillArray(double[] array, ContextProvider contextProvider) {
        for (int i = 0; i < array.length; i++) {
            array[i] = compute(contextProvider.forIndex(i));
        }
    }

    @Override
    public double minValue() {
        return baseHeight; // La valeur minimale que la fonction peut renvoyer
    }

    @Override
    public double maxValue() {
        return plateauHeight; // La valeur maximale que la fonction peut renvoyer
    }

    @Override
    public KeyDispatchDataCodec<? extends DensityFunction> codec() {
        return CODEC;
    }

    @Override
    public DensityFunction mapAll(Visitor visitor) {
        return this;
    }
}