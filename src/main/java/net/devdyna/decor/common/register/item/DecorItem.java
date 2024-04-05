package net.devdyna.decor.common.register.item;

import net.devdyna.decor.Decor;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class DecorItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Decor.MOD_ID);

    public static final RegistryObject<Item> DYE_ESSENCE = ITEMS.register("dye_essence",
            () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> ICON = ITEMS.register("icon",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
