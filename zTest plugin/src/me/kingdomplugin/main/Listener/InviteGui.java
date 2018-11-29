package me.kingdomplugin.main.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class InviteGui {
	public static void openGui(Player player) {
		
		Inventory InviteGui = Bukkit.createInventory(null, 9, "§1invite request");
		
		ItemStack Accept = new ItemStack(Material.WOOL, 1, (byte)5);
		ItemMeta AcceptMeta = Accept.getItemMeta();
		AcceptMeta.setDisplayName("§a§lAccept");
		Accept.setItemMeta(AcceptMeta);
		InviteGui.setItem(3, Accept);
		
		ItemStack Decline = new ItemStack(Material.WOOL, 1, (byte)14);
		ItemMeta DeclineMeta = Decline.getItemMeta();
		DeclineMeta.setDisplayName("§c§lDecline");
		Decline.setItemMeta(DeclineMeta);
		InviteGui.setItem(5, Decline);
		
		player.openInventory(InviteGui);
		
	}

}
