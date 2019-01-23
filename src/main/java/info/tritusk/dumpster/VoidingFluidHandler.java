package info.tritusk.dumpster;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.FluidTankProperties;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import javax.annotation.Nullable;

public final class VoidingFluidHandler implements IFluidHandler {

    public static final VoidingFluidHandler INSTANCE = new VoidingFluidHandler();

    private static final IFluidTankProperties[] TANK_PROPERTIES;

    static {
        TANK_PROPERTIES = new IFluidTankProperties[] { new FluidTankProperties(null, Integer.MAX_VALUE, true, false)};
    }

    private VoidingFluidHandler() {
        // No-op. What else can we do here?
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * As a {@code VoidingFluidHandler}, although this effectively stores no
     * fluid, for sake of precisely reflecting its properties, this will return
     * an array with only one element, and that IFluidTankProperties will have
     * the following behaviors:
     * <ul>
     *     <li>
     *         {@link IFluidTankProperties#getContents()} always returns {@code null}.
     *     </li>
     *     <li>
     *         {@link IFluidTankProperties#getCapacity()} always returns {@link
     *         Integer#MAX_VALUE 2147483647}.
     *     </li>
     *     <li>
     *         Both {@link IFluidTankProperties#canFill()} and {@link
     *         IFluidTankProperties#canFillFluidType(FluidStack)} always return
     *         {@code true}.
     *     </li>
     *     <li>
     *         Both {@link IFluidTankProperties#canDrain()} and {@link
     *         IFluidTankProperties#canDrainFluidType(FluidStack)} always return
     *         {@code false}.
     *     </li>
     * </ul>
     *
     * @return Array of IFluidTankProperties with length of one, which represents
     *         the only (virtual) "tank" that this has.
     */
    @Override
    public IFluidTankProperties[] getTankProperties() {
        return TANK_PROPERTIES;
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
