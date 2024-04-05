package net.devdyna.decor;

import com.mojang.logging.LogUtils;
import net.devdyna.decor.common.register.block.DecorBlock;
import net.devdyna.decor.common.register.item.DecorItem;
import net.devdyna.decor.common.register.tab.DecorCreativeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Decor.MOD_ID)
public class Decor {
    public static final String MOD_ID = "decor";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Decor() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        DecorItem.register(modEventBus);
        DecorBlock.register(modEventBus);
        DecorCreativeTab.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(DecorItem.DYE_ESSENCE);
            event.accept(DecorBlock.RAINBOW);
            event.accept(DecorItem.ICON);
        }
    }
}
