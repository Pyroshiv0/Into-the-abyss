package com.pyroshiv.arsabyssaux.api.drain;

/**
 * Interface for a generic tile that holds drain.
 */

public interface IDrainTile {
    int getTransferRate();

    boolean canAcceptDrain();

    int getDrain();

    int getMaxDrain();

    void setMaxDrain(int max);

    int setDrain(final int drain);

    int addDrain(final int drain);

    int removeDrain(final int drain);
}
