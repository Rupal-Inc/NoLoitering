package me.rupalinc.NoLoitering;


import java.util.logging.Logger;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import me.rupalinc.NoLoitering.commands.CommandManager;


public class Main extends JavaPlugin {
	public final static Logger logger = Logger.getLogger("Minecraft");
	public static Main instance;
	public static boolean startPlugin;
	public static Plugin plugin;

	
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults();
		saveDefaultConfig();
		
		instance = this;
		startPlugin = false;
		plugin = this;
		
	
		
		getCommand("noloitering").setExecutor((new CommandManager()));
		getCommand("noloitering").setTabCompleter((new CommandManager()));
		
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion()
		+ " Has been enabled!");	

	}
	
	@Override
	public void onDisable() {
		this.saveConfig();
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info(pdfFile.getName() + " Has been disabled!");
		instance = null;
	}
	
	
	
	public boolean isNum(String num) {
		try {
			Long.valueOf(num);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	
}
	

	
