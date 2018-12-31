package info.tritusk.dumpster;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import javax.annotation.Nullable;

public final class VoidingFluidHandler implements IFluidHandler {

    public static final VoidingFluidHandler INSTANCE = new VoidingFluidHandler();

    private VoidingFluidHandler() {
        // No-op. What else can we do here?
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * As a {@code VoidingFluidHandler}, there is effectively nothing
     * stored in the handler, so an empty array will always be returned.
     *
     * @return Empty array of IFluidTankProperties
     */
    @Override
    public IFluidTankProperties[] getTankProperties() {
        return new IFluidTankProperties[0];
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * As a {@code VoidingFluidHandler}, it will accept any input. When
     * {@code null} input is provided, it returns zero.
     *
     * @return FluidStack.amount, or 0 if resource is null.
     */
    @Override
    public int fill(FluidStack resource, boolean doFill) {
        return resource == null ? 0 : resource.amount;
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * As a {@code VoidingFluidHandler}, nothing can be drained from this.
     * Therefore, it will always return {@code null}.
     *
     * @return null, always.
     */
    @Nullable
    @Override
    public FluidStack drain(FluidStack resource, boolean doDrain) {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * As a {@code VoidingFluidHandler}, nothing can be drained from this.
     * Therefore, it will always return {@code null}.
     *
     * @return null, always.
     */
    @Nullable
    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        return null;
    }
}
