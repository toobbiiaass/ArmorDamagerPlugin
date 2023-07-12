package firstprogramm.armordamagerwithoutrod;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

public class RodHitListener implements Listener {
    @EventHandler
    public void onRodHookHitPlayer(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof FishHook){
            if (e.getEntity() instanceof Player) {
                Player damagedPlayer = (Player) e.getEntity();
                ItemStack[] armorContents = damagedPlayer.getInventory().getArmorContents();
                for (ItemStack armorItem : armorContents) {
                    if (armorItem != null && armorItem.getType() != Material.AIR) {
                       int addOneDurabilityBack= armorItem.getDurability()-1;
                        armorItem.setDurability((short) addOneDurabilityBack);
                    }
                }

                damagedPlayer.getInventory().setArmorContents(armorContents);
            }
        }

    }
}
