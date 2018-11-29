package me.kingdomplugin.main.Commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import me.kingdomplugin.main.Main;
import me.kingdomplugin.main.Listener.InviteGui;

	public class Commands implements CommandExecutor {						
					
		public YamlConfiguration Yamlfile;
		public File data;	
		public ArrayList<Player> Lijst = new ArrayList<Player>();		
		
		public void save_data(String file, String path, String value) {
			   Map<String, Object> data = new HashMap<String, Object>();			  
			   data.put(path, value);	
			   DumperOptions options = new DumperOptions();
		       options.setIndent(2);
		       options.setPrettyFlow(true);
		       options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
			   Yaml yaml = new Yaml(options);
			   FileWriter writer;
			try {
				writer = new FileWriter("plugins/KingdomPlugin/" + file + ".yml");
				yaml.dump(data, writer);	
				
			} catch (IOException e) {
				e.printStackTrace();
			}   			  
		}

		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {												
			if (cmd.getName().equalsIgnoreCase("channel") && sender instanceof Player) {
				if (args != null) {	
				Player player = (Player) sender;			
				if (args.length == 0) {
				player.sendMessage("§4Error");
				return true;
				}
				if (args.length == 1);
				String join = args[0];
				String leave = args[0];
				String list = args[0];
				if (join.equalsIgnoreCase("Join")) {
					if (args.length == 2) {
					String Kingdom = args[1];					
					Main.getInstance().getConfig().getString(Kingdom);
					if (Kingdom == null) {
						player.sendMessage("§c§lSorry§f, §7Dit kingdom bestaat niet!");
						return true;
					} else {
						// arraylist met channel
						player.sendMessage("§aSucces! §f- §7U zit nu in channel §f" + Kingdom);
					}
				}
			}
				if (leave.equalsIgnoreCase("Leave")) {
					//player.sendMessage("§2");
				}
				if (list.equalsIgnoreCase("List")) {
					if (args.length == 2) {						
						// list
					}
					
					// kingdom player lijst die online zijn 
					// nog als verduidelijking zeggen dat die in dat kingdom zit en die chat
					// alleen mensen weergeven die online zijn in juist kingdom
				}
			}	
				return true;
		}	
			if (cmd.getName().equalsIgnoreCase("k") && sender instanceof Player) {		
				if (args != null) {	
					Player player = (Player) sender;					
					if (args.length == 0) {
					player.sendMessage("§4Error probeer /k help");
					return true;
					}
				
					if (args.length == 1);
					String kick = args[0];
					String setrank = args[0];
					String setkingdom = args[0];
					String setspawn = args[0];
					String spawn = args[0];
					String tp = args[0];
					String tphere = args[0];
					String friendlyfire = args[0];
					String ally = args[0];
					String enemy = args[0];
					String neutral = args[0];
					String invite = args[0];
					String join = args[0];
					String create = args[0];
					String help = args[0];
					String remove = args[0];
					
					if (create.equalsIgnoreCase("create")) {	
						if (player.hasPermission("kingdom.create")) {
						if (args.length == 3) {
							player.sendMessage("§c§lSorry§f, §7Probeer /k create (Kingdom) (prefix) (Tab)");
							return true;
						}
						if (args.length == 2) {
							player.sendMessage("§c§lSorry§f, §7Probeer /k create (Kingdom) (prefix) (Tab)");
							return true;
						}
						if (args.length >= 5) {
							player.sendMessage("§c§lSorry§f, §7Probeer /k create (Kingdom) (prefix) (Tab)");
							return true;
						}
						if (args.length == 4) {
							String KingdomNaam = args[1];
							String Prefix = args[2];
							String Tab = args[3];								
							data = new File("plugins/KingdomPlugin/" + args[1] + ".yml");
							if (!data.exists()) {
							try {
								data.createNewFile();	
								Yamlfile = YamlConfiguration.loadConfiguration(data);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
							player.sendMessage("§7Het kingdom§f " + KingdomNaam + " §7is nu aangemaakt!");
							Main.getInstance().getConfig().set("Kingdom", KingdomNaam);
							Main.getInstance().getConfig().set("Prefix", Prefix);
							Main.getInstance().getConfig().set("Tab", Tab);
							Main.getInstance().saveConfig();
							Main.getInstance().reloadConfig();
							Main.getInstance().getConfig();							
							// maak direct een channel aan voor dat kingdom
						}					
					}
				}
					if (kick.equalsIgnoreCase("kick")) {
						if (player.hasPermission("kingdom.kick")) {
							Player target = Bukkit.getServer().getPlayer(args[1]);
							if (target == null) {
								player.sendMessage("§c§lSorry§f, §7Speler §f" + args[1] + " §7is niet online!" );
								return true;
							}
							for (int i = 0; i < Lijst.size(); i++) {
								if (target.equals(i)) {
									Lijst.remove(target);
								} else {
									player.sendMessage("§c§lSorry§f, §7Deze speler zit niet in uw kingdom!");
									return true;
								}								
							}
						} 
						if (!player.hasPermission("kingdom.kick")) {
							player.sendMessage("§c§lSorry§f, §7U heeft geen permissie tot dit commando!");
							return true;
						}
					}
					if (setrank.equalsIgnoreCase("setrank")) {
						
					}
					if (setkingdom.equalsIgnoreCase("setkingdom")) {						
						if (player.hasPermission("kingdom.setkingdom")) {	
							if (args.length <= 2) {
								player.sendMessage("§c§lSorry§f, §7Probeer /k setkingdom (Speler) (Kingdom)");
								return true;
							}
							if (args.length >= 4) {
								player.sendMessage("§c§lSorry§f, §7Probeer /k setkingdom (Speler) (Kingdom)");
								return true;
							}
							if (args.length == 3) {
								Player target = Bukkit.getServer().getPlayer(args[1]);
								String kingdom = Main.getInstance().getConfig().getString(args[2]);
								if (kingdom == null) {
									player.sendMessage("§c§lSorry§f, §7Dit kingdom bestaat niet!");
									return true;
								}
								if (target == null) {
									player.sendMessage("§c§lSorry§f, §7Deze speler is niet online!");
									return true;
								}									 
								this.save_data(args[2], target.getName(), args[2]);
								Lijst.add(target);	
								player.sendMessage("§a§lSucces! §f- §7De speler §f" + target.getName() + " §7zit nu in " + args[2]);																						
							}
						
						}
						if (!player.hasPermission("kingdom.setkingdom")) {
							player.sendMessage("§c§lSorry§f, §7U heeft geen permissie tot dit commando!");
							return true;
						}
							
					}
					if (setspawn.equalsIgnoreCase("setspawn")) {
						if (player.hasPermission("kingdom.setspawn")) {
							if (args.length >= 3) {
								player.sendMessage("§c§lSorry§f, §7Probeer /k setspawn (kingdom)");
								return true;
							}
							if (args.length <= 1) {
								player.sendMessage("§c§lSorry§f, §7Probeer /k setspawn (kingdom)");
								return true;
							}
							if (args.length == 2) {								
							if	(Main.getInstance().getConfig().get(args[1]) == null) {
								player.sendMessage("§c§lSorry§f, §7Kingdom " + args[1] + " bestaat niet!");
								return true;	
							}
								Main.getInstance().getConfig().set(args[1] + " Spawn Location X", player.getLocation().getBlockX());
								Main.getInstance().getConfig().set(args[1] + " Spawn Location Y", player.getLocation().getBlockY());
								Main.getInstance().getConfig().set(args[1] + " Spawn Location Z", player.getLocation().getBlockZ());
								Main.getInstance().saveConfig();
								Main.getInstance().reloadConfig();
								Main.getInstance().getConfig();
								player.sendMessage("§a§lSucces! §f- §7De kingdomspawn van §f" + args[1] + " §7is getzet!");
								
							}
						}
					}
					if (spawn.equalsIgnoreCase("spawn")) {
						if (args.length >= 3) {
							player.sendMessage("§c§lSorry§f, §7Probeer /k spawn (kingdom)");
							return true;
						}
						if (args.length <= 1) {
							player.sendMessage("§c§lSorry§f, §7Probeer /k spawn (kingdom)");
							return true;
						}
						if (args.length == 2) {							
							Main.getInstance().getConfig().get(args[1]);
							World w = player.getWorld();
							double x = Main.getInstance().getConfig().getDouble(args[1] + " Spawn Location X");
							double y = Main.getInstance().getConfig().getDouble(args[1] + " Spawn Location Y");
							double z = Main.getInstance().getConfig().getDouble(args[1] + " Spawn Location Z");
							Location loc = new Location(w, x +0.5, y, z +0.5);
							player.teleport(loc);
							player.sendMessage("§7U bent nu in " + args[1]);
							if (args[1] == null) {
								player.sendMessage("§7Spawn §f" + args[1] + " §7bestaat niet!");
								return true;
								// spawn hoofdlette gevoelig vrij maken
							}
						}
					}
					if (tp.equalsIgnoreCase("tp")) {
						// alleen de personen uit je kingdom
					}
					if (tphere.equalsIgnoreCase("tphere")) {
						// alleen de personen uit je kingdom
					}
					if (friendlyfire.equalsIgnoreCase("friendlyfire")) {
						if (player.hasPermission("kingdom.friendlyfire")) {
							// alleen alle mensen uit je kingdom kan je hitten
						} else {
							player.sendMessage("§4Error");
							return true;
						}
					}
					if (ally.equalsIgnoreCase("ally")) {
						// /k ally kindom
					}
					if (enemy.equalsIgnoreCase("enemy")) {
						
					}
					if (neutral.equalsIgnoreCase("neutral")) {
						
					}
					if (invite.equalsIgnoreCase("invite")) {
						if (player.hasPermission("kingdom.invite")) {
							if (args.length == 2) {
							Player target = Bukkit.getServer().getPlayer(args[1]);
							InviteGui.openGui(target);
							} else {
								player.sendMessage("§4Error");
								return true;
							}
						} else {
							player.sendMessage("§4U kunt deze command niet gebruiken probeer /k help");
						}
						
					}
					if (join.equalsIgnoreCase("join")) {
						// je kan pas joinen als je een invite heb gehad
					}
					if (help.equalsIgnoreCase("help")) {
						player.sendMessage("§2/Channel join (kdnaam) §7- §aHier bij join je een kingdom");
						player.sendMessage("§2/Channel leave §7- §aHier bij leave je een kingdom chat");
						player.sendMessage("§2/Channel list (kdnaam) §7- §aHier bij zie je ieder lid van dit dat kingdom");
						player.sendMessage("§2/k kick (player) §7- §aHier bij kick je een speler van het kingdom");
						player.sendMessage("§2/k setrank (player) (rank) §7- §aHier bij geef u een rank aan een speler");
						player.sendMessage("§2/k setkingdom (player) (kingdom) §7- §aHier bij zet je een speler in een kingdom");
						player.sendMessage("§2/k setspawn (kdnaam) §7- §aHier kunt je de spawn zetten van het kingdom");
						player.sendMessage("§2/k spawn §7- §aHier bij teleporteer je naar het kingdom spawnpoint");
						player.sendMessage("§2/k tp (player) §7- §aHier bij teleporteer je naar de speler");
						player.sendMessage("§2/k tphere (player) §7- §aHier bij teleporteer je de speler naar jou");
						player.sendMessage("§2/k friendlyfire (kdnaam) true/false §7- §aHier bij kan je instellen of dit kingdom wel of niet tegen je kan pvp'n");
						player.sendMessage("§2/k ally (kdnaam) §7- §aHier bij maak je een kingdom je ally");
						player.sendMessage("§2/k enemy (kdnaam) §7- §aHier bij maak je een kingdom je enemy");
						player.sendMessage("§2/k neutral (kdnaam) §7- §aHier bij maak je een kingdom neutral");
						player.sendMessage("§2/k invite (speler) §7- §aHier bij kan je een speler tot uw kingdom inviten");
						player.sendMessage("§2/k join (kdnaam) §7- §aHier bij join je een kingdom");
						player.sendMessage("§2/k create (kdnaam) §7- §aHier bij maakt u een kingdom aan!");
						player.sendMessage("§2/k help §7- §aDit weergeeft dit lijstje nog eens"); 
						player.sendMessage("§2/k remove (kdnaam) §7- §aDit verwijdert het kingdom"); 
					}
					if (remove.equalsIgnoreCase("remove")) {
						String r = args[1];
						if (args.length == 1) {
							player.sendMessage("§4Error");
							return true;
						}
						if (args.length == 2) {
							data.equals(r);
							data.delete();
							if (!data.exists()) {
								player.sendMessage("§4Error");
							}
						}
						if (args.length >= 2) {
							player.sendMessage("§4Error");
						}
					}
				}
					return true;
			}				
			if (cmd.getName().equalsIgnoreCase("kd") && sender instanceof Player) {
				if (args != null) {	
				Player player = (Player) sender;
					if (args.length == 0) {
					player.sendMessage("§4Error");
					return true;
					}
					if (args.length == 1) {
					String relations = args [0];
					if (relations.equalsIgnoreCase("relations")) {
						// laat zien welke ally enimy of neutraal zijn
					}
				}	
			}
		}
			return false;	
	}
} // /k remove  removed een kingdom

