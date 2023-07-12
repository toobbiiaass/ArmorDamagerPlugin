package firstprogramm.armordamagerwithoutrod;

import org.bukkit.plugin.java.JavaPlugin;

public final class ArmorDamagerWithoutRod extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new RodHitListener(), this);
    }
}
