package info.tritusk.modpack.dumpster.forge;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DumpsterBlockForgeVer extends Block implements EntityBlock {
    public DumpsterBlockForgeVer(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new Logic(blockPos, blockState);
    }

    public static final class Logic extends BlockEntity {

        public static BlockEntityType<Logic> type;

        final LazyOptional<IItemHandler> inv = LazyOptional.of(() -> VoidingItemHandler.INSTANCE);
        final LazyOptional<IFluidHandler> tank = LazyOptional.of(() -> VoidingFluidHandler.INSTANCE);
        final LazyOptional<IEnergyStorage> energy = LazyOptional.of(() -> VoidingEnergyHandler.INSTANCE);

        public Logic(BlockPos pos, BlockState state) {
            super(type, pos, state);
        }

        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            if (cap == ForgeCapabilities.ITEM_HANDLER) {
                return this.inv.cast();
            } else if (cap == ForgeCapabilities.FLUID_HANDLER) {
                return this.tank.cast();
            } else if (cap == ForgeCapabilities.ENERGY) {
                return this.energy.cast();
            } else {
                return super.getCapability(cap, side);
            }
        }

        @Override
        public void invalidateCaps() {
            super.invalidateCaps();
            this.inv.invalidate();
            this.tank.invalidate();
            this.energy.invalidate();
        }
    }
}
