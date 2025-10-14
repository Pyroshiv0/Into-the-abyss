package com.pyroshiv.intotheabyss.worldgen.ChunkGenerators.noises;

import com.pyroshiv.intotheabyss.utility.FastNoiseLite;

public class IslandNoise {

    private final FastNoiseLite islandNoise = new FastNoiseLite();
    private float[][] islandNoiseData;

    public IslandNoise() {initNoise();}
    public IslandNoise(int seed) {initNoise(seed);}

    private void initNoise(){
        //values determined using the online preview
        //General
        islandNoise.SetNoiseType(FastNoiseLite.NoiseType.Cellular);
        islandNoise.SetFrequency(0.017F);

        //Cellular
        islandNoise.SetCellularDistanceFunction(FastNoiseLite.CellularDistanceFunction.Manhattan);
        islandNoise.SetCellularReturnType(FastNoiseLite.CellularReturnType.CellValue);
        islandNoise.SetCellularJitter(0.650F);

        //Domain Warp
        islandNoise.SetDomainWarpType(FastNoiseLite.DomainWarpType.OpenSimplex2);
        islandNoise.SetDomainWarpAmp(16.00F);

        //Domain Warp Fractal
        islandNoise.SetFractalType(FastNoiseLite.FractalType.DomainWarpIndependent);
        islandNoise.SetFractalOctaves(3);
        islandNoise.SetFractalLacunarity(1.0F);
        islandNoise.SetFractalGain(0.7F);


        float[][] noiseData = new float[1024][1024];
        for (int x = 0; x < 128; x++)
        {
            for (int y = 0; y < 128; y++)
            {
                FastNoiseLite.Vector2 coord = new FastNoiseLite.Vector2(x, y);
                islandNoise.DomainWarp(coord);
                noiseData[x][y] = islandNoise.GetNoise(coord.x, coord.y);
            }
        }
        islandNoiseData = noiseData;
    }
    private void initNoise(int seed){
        islandNoise.SetSeed(seed);
        initNoise();
    }

    public float[][] getIslandNoiseData(){
        return islandNoiseData;
    }
}
