package me.kingdomplugin.main.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiAccept implements Listener {
	
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		 Inventory inventory = e.getInventory();
		 ItemStack clicked = e.getCurrentItem();
		 if (inventory.getName().equals("§1invite request")) {	
			clicked.equals(player);
			if (clicked.getItemMeta().getDisplayName().contains("§a§lAccept")) {
				player.closeInventory();
				player.sendMessage("§7 Je hebt zojuist de request geaccepteerd");
			}
	    	  
	      }
	}

}
