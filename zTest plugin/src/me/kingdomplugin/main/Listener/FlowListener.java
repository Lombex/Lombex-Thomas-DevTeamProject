package me.kingdomplugin.main.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import me.kingdomplugin.main.Main;

public class FlowListener implements Listener {
	
	@EventHandler
	  public void onBlockFromTo(BlockFromToEvent event)
	  {
	    @SuppressWarnings("deprecation")
		int id = event.getBlock().getTypeId();
	    if ((id == 8) || (id == 9)) {
	    	boolean water = Main.getInstance().getConfig().getBoolean("waterflow");
	    	if (water == true) {
	    		event.setCancelled(true);
	    	} 
	    	if (water == false) {
	    		event.setCancelled(false); 
	    	}
	    }
	    if ((id == 10) || (id == 11)) {
	    	boolean lava = Main.getInstance().getConfig().getBoolean("lavaflow");
	    	if (lava == true) {
	    		event.setCancelled(true);
	    	} 
	    	if (lava == false) {
	    		event.setCancelled(false);
	    	}
	    }
	    
	  } 
	}


