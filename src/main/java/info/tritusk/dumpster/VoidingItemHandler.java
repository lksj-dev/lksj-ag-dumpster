package info.tritusk.dumpster;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;

public final class VoidingItemHandler implements IItemHandler {

    public static final VoidingItemHandler INSTANCE = new VoidingItemHandler();

    private VoidingItemHandler() {
        // No-op. What else can we do here?
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * It is assumed that there is only one slot available.
     *
     * @return Constant one (1).
     */
    @Override
    public int getSlots() {
        return 1;
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * As a {@code VoidingItemHandler}, it effectively stores nothing.
     * Therefore, this method will always return {@link ItemStack#EMPTY}.
     *
     * @return ItemStack.EMPTY, always.
     */
    @Nonnull
    @Override
    public ItemStack getStackInSlot(int slot) {
        return ItemStack.EMPTY;
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * As a {@code VoidingItemHandler}, it will unconditionally accept
     * any provided input and immediately discard it by performing no
     * operations. Therefore, this method will always return {@link
     * ItemStack#EMPTY}.
     *
     * @return ItemStack.EMPTY, always.
     */
    @Nonnull
    @Override
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        return ItemStack.EMPTY;
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * As a {@code VoidingItemHandler}, it effectively stores nothing, and
     * thus nothing can be extracted out from any of given slot. Therefore,
     * this method will always return {@link ItemStack#EMPTY}.
     *
     * @return ItemStack.EMPTY, always.
     */
    @Nonnull
    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        return ItemStack.EMPTY;
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * It is assumed that each slot of this IItemHandler has a maximum stack
     * size limit that is the same as of most of items in Minecraft.
     *
     * @return Constant sixty-four (64), which is maximum stack size for most
     *         items in Minecraft.
     */
    @Override
    public int getSlotLimit(int slot) {
        return 64;
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * As a {@code VoidingItemHandler}, it will unconditionally accept
     * any provided input. Therefore, any input is valid for this.
     *
     * @return boolean value of true, always.
     */
    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return true;
    }
}
