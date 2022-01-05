package de.ingressboy.smpcore;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class SmpCore extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        ShapelessRecipe totemofundyingrecipe = new ShapelessRecipe(new NamespacedKey(this, "totem_of_undying"), new ItemStack(Material.TOTEM_OF_UNDYING));
        totemofundyingrecipe.addIngredient(Material.NETHERITE_INGOT);
        totemofundyingrecipe.addIngredient(Material.DIAMOND);
        Bukkit.addRecipe(totemofundyingrecipe);
        Bukkit.getPluginManager().registerEvents(this, this);

        ShapelessRecipe elytrarecipe = new ShapelessRecipe(new NamespacedKey(this, "elytra"), new ItemStack(Material.ELYTRA));
        elytrarecipe.addIngredient(Material.TOTEM_OF_UNDYING);
        elytrarecipe.addIngredient(Material.DIAMOND);
        Bukkit.addRecipe(elytrarecipe);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {

    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GOLD + "Willkommen auf SMP1!");

        event.getPlayer().discoverRecipe(new NamespacedKey(this, "totem_of_undying"));
        event.getPlayer().discoverRecipe(new NamespacedKey(this, "elytra"));
    }
}
