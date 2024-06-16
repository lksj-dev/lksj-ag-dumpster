package info.tritusk.modpack.dumpster.forge;


import net.minecraftforge.energy.IEnergyStorage;

public enum VoidingEnergyHandler implements IEnergyStorage {
    INSTANCE;

    @Override
    public int receiveEnergy(int toReceive, boolean simulate) {
        return toReceive;
    }

    @Override
    public int extractEnergy(int toExtract, boolean simulate) {
        return 0;
    }

    @Override
    public int getEnergyStored() {
        return 0;
    }

    @Override
    public int getMaxEnergyStored() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean canExtract() {
        return false;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
}
