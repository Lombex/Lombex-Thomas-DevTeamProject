package me.kingdomplugin.main.api;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;


public class Tab {
	
	public static void set(String color, Player p, String header, String footer)
	  {
	    if (header == null) {
	      header = "";
	    }
	    if (footer == null) {
	      footer = "";
	    }
	    IChatBaseComponent tabHeader = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + header.replaceAll("&", "�") + "\"}");
	    IChatBaseComponent tabFooter = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + footer.replaceAll("&", "�") + "\"}");
	    
	    PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter(tabHeader);
	    try
	    {
	      Field field = headerPacket.getClass().getDeclaredField("b");
	      field.setAccessible(true);
	      field.set(headerPacket, tabFooter);
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	      ((CraftPlayer)p).getHandle().playerConnection.sendPacket(headerPacket);
	    }
	  }

}
