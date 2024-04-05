package net.devdyna.decor.common.register.tab;

import net.devdyna.decor.Decor;
import net.devdyna.decor.common.register.item.DecorItem;
import net.devdyna.decor.common.register.block.DecorBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DecorCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Decor.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DECOR_TAB = CREATIVE_MODE_TABS.register("decor_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DecorBlock.RAINBOW.get()))
                    .title(Component.translatable("creativetab.decor_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(DecorBlock.RAINBOW.get());
                        pOutput.accept(DecorItem.DYE_ESSENCE.get());
						pOutput.accept(DecorItem.ICON.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
