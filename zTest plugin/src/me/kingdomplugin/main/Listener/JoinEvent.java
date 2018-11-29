package me.kingdomplugin.main.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import me.kingdomplugin.main.Main;
import me.kingdomplugin.main.api.Tab;

public class JoinEvent implements Listener {
		
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		e.setJoinMessage("");
		Player p = (Player) e.getPlayer();
		String TabColor = Main.getInstance().getConfig().getString("Tab");
		TabColor.replaceAll("&", "§");
		Tab.set(TabColor, p, "Test", "Test");
			}					
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		e.setQuitMessage("");
	}

}
