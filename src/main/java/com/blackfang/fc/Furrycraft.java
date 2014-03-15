package com.blackfang.fc;

import com.blackfang.fc.lib.Reference;
import cpw.mods.fml.common.mod;
import cpw.mods.fml.common.mod.Init;
import cpw.mods.fml.common.mod.PostInit;
import cpw.mods.fml.common.mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

/**
 * FurryCraft
 * <p/>
 * Furrycraft
 *
 * @author Lone Blackfang
 */
@Mod(modid = Reference.MOD_ID,name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(channels = {Reference.CHANNEL_NAME}, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)


public class Furrycraft{
    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
    	// set version number
        event.getModMetadata().version = Reference.VERSION_NUMBER;
        
        // Conduct the version check and log the result
        VersionHelper.execute();

        // Initialize the Version Check Tick Handler (Client only)
        TickRegistry.registerTickHandler(new VersionCheckTickHandler(), Side.CLIENT);

        // Initialize the InterModCommunications Tick Handler (Server only)
        TickRegistry.registerScheduledTickHandler(new InterModCommsHandler(), Side.SERVER);

        // Initialize the Render Tick Handler (Client only)
        proxy.registerRenderTickHandler();

        // Register the KeyBinding Handler (Client only)
        proxy.registerKeyBindingHandler();

        // Register the Sound Handler (Client only)
        proxy.registerSoundHandler();

        // Initialize mod blocks
        ModBlocks.init();

        // Initialize mod items
        ModItems.init();
    }
    
    @Init
    public void load(FMLInitializationEvent event)
    {
    	// Needs to be worked on
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event)
    {
    	// Needs to be worked on
    }
}
