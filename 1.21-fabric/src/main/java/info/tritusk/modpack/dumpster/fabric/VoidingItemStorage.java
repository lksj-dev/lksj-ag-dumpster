package info.tritusk.modpack.dumpster.fabric;

import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;

import java.util.Iterator;
import java.util.List;

public enum VoidingItemStorage implements Storage<ItemVariant> {
    INSTANCE;

    @Override
    public long insert(ItemVariant resource, long maxAmount, TransactionContext transaction) {
        return maxAmount;
    }

    @Override
    public boolean supportsInsertion() {
        return true;
    }

    @Override
    public long extract(ItemVariant resource, long maxAmount, TransactionContext transaction) {
        return 0;
    }

    @Override
    public boolean supportsExtraction() {
        return false;
    }

    @Override
    public Iterator<StorageView<ItemVariant>> iterator() {
        return List.<StorageView<ItemVariant>>of(View.INSTANCE).iterator();
    }

    public enum View implements StorageView<ItemVariant> {
        INSTANCE;

        @Override
        public long extract(ItemVariant resource, long maxAmount, TransactionContext transaction) {
            return 0;
        }

        @Override
        public boolean isResourceBlank() {
            return true;
        }

        @Override
        public ItemVariant getResource() {
            return ItemVariant.blank();
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
