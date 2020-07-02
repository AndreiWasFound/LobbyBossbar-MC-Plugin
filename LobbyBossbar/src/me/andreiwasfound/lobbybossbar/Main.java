package me.andreiwasfound.lobbybossbar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public Bar bar;
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		bar = new Bar(this);
		bar.createBar();
		
		if (Bukkit.getOnlinePlayers().size() > 0)
			for (Player on : Bukkit.getOnlinePlayers())
				bar.addPlayer(on);
	}
	
	@Override
	public void onDisable() {
		bar.getBar().removeAll();
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if (!bar.getBar().getPlayers().contains(event.getPlayer()))
			bar.addPlayer(event.getPlayer());
	}

}
