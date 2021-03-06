package spoilagesystem.EventHandlers;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import spoilagesystem.FoodSpoilage;
import spoilagesystem.StorageManager;
import spoilagesystem.TimeStamper;

public class ItemSpawnEventHandler implements Listener {

    @EventHandler()
    public void handle(ItemSpawnEvent event) {

        ItemStack item = event.getEntity().getItemStack();
        Material type = item.getType();
        int time = StorageManager.getInstance().getTime(type);

        // if timestamp not already assigned
        if (time != 0 && !TimeStamper.getInstance().timeStampAssigned(item)) {
            event.getEntity().setItemStack(TimeStamper.getInstance().assignTimeStamp(item, time));
        }

    }

}
