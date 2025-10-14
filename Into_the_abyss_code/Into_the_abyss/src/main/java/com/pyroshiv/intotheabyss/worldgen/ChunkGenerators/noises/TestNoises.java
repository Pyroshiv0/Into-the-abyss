package com.pyroshiv.intotheabyss.worldgen.ChunkGenerators.noises;

public class TestNoises {

    private static IslandNoise islandNoise;

    public static void main(String[] args) {
        islandNoise=new IslandNoise(1442);
        int maxRender=64;
        var noiseData=islandNoise.getIslandNoiseData();
        StringBuilder line;
        for (int x = 0; x < maxRender; x++) {
            line = new StringBuilder();
            for (int y = 0; y < maxRender; y++) {
               if (noiseData[x][y]>0) {
                   line.append('+');
               }
                line.append(String.valueOf(Math.round(100.0F*noiseData[x][y])/100.0F));
                line.append(',');


            }
            System.out.println(line.toString());
        }
    }


}
