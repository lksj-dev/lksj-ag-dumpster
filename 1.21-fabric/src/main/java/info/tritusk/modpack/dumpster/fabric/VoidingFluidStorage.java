package info.tritusk.modpack.dumpster.fabric;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;

import java.util.Iterator;
import java.util.List;

public enum VoidingFluidStorage implements Storage<FluidVariant> {
    INSTANCE;

    @Override
    public long insert(FluidVariant resource, long maxAmount, TransactionContext transaction) {
        return maxAmount;
    }

    @Override
    public boolean supportsInsertion() {
        return true;
    }

    @Override
    public long extract(FluidVariant resource, long maxAmount, TransactionContext transaction) {
        return 0;
    }

    @Override
    public boolean supportsExtraction() {
        return false;
    }

    @Override
    public Iterator<StorageView<FluidVariant>> iterator() {
        return List.<StorageView<FluidVariant>>of(View.INSTANCE).iterator();
    }

    public enum View implements StorageView<FluidVariant> {
        INSTANCE;

        @Override
        public long extract(FluidVariant resource, long maxAmount, TransactionContext transaction) {
            return 0;
        }

        @Override
        public boolean isResourceBlank() {
            return true;
        }

        @Override
        public FluidVariant getResource() {
            return FluidVariant.blank();
        }

        @Override
        public long getAmount() {
            return 0;
        }

        @Override
        public long getCapacity() {
            return Long.MAX_VALUE;
        }
    }
}
