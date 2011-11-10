package com.alta189.chavanotify;

import java.io.File;
import java.io.IOException;

import com.alta189.chavabot.events.Order;
import com.alta189.chavabot.events.channelevents.ChannelJoinEvent;
import com.alta189.chavabot.plugins.java.JavaPlugin;
import com.alta189.chavabot.util.SettingsHandler;

public class ChavaNotify extends JavaPlugin {
	
	private NotifyListener notifyListener = null;
	private SettingsHandler settings = null;
	
	@Override
	public void onEnable() {
		notifyListener = new NotifyListener();
		try {
			settings = new SettingsHandler(ChavaNotify.class.getResource("notify.properties").openStream(), new File(this.getDataFolder(), "notify.properties"));
			settings.load();
		} catch (IOException e) {
			e.printStackTrace();
			this.getPluginLoader().disablePlugin(this);
			return;
		}
		ChannelJoinEvent.register(notifyListener, Order.Default, this);
	}

	@Override
	public void onDisable() {
		
	}

}
