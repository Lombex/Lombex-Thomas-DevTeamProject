package me.kingdomplugin.main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import me.kingdomplugin.main.Commands.Commands;
import me.kingdomplugin.main.Listener.FlowListener;
import me.kingdomplugin.main.Listener.GuiAccept;
import me.kingdomplugin.main.Listener.JoinEvent;

public class Main extends JavaPlugin implements Listener {
	
    private static Main instance;
    public Main() {
        instance = this;
    }
    public static Main getInstance() {
        return instance;
    }
	
	public void onEnable() {

		getLogger().info("Loading...");
		getCommand("channel").setExecutor(new Commands());
		getCommand("k").setExecutor(new Commands());
		getCommand("List").setExecutor(new Commands());
		
		getServer().getPluginManager().registerEvents(new FlowListener(), this);
		getServer().getPluginManager().registerEvents(new JoinEvent(), this);	
		getServer().getPluginManager().registerEvents(new GuiAccept(), this);	
		this.saveResource("config.yml", false);
		for (int i = 0; i < 101; i++) {
			getLogger().info(i + "%");
			if (i == 100) {
				getLogger().info("Loading Competed!");
				getLogger().info("KingdomPlugin Enabled!");
				
		  }
	   }
	}
	
		
	public void onDisable() {
		getLogger().info("The KingdomPlugin is Disabled!");
	}
		
}
