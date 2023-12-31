package cn.langya.sun.events.impl;

import com.cubk.event.impl.Event;
import net.minecraft.client.multiplayer.WorldClient;

/**
 * @author LangYa
 * @ClassName WorldLoadEvent
 * @date 2023/12/31 9:47
 * @Version 1.0
 */

public class WorldLoadEvent implements Event {
    public WorldClient worldClient;

    public WorldLoadEvent(final WorldClient worldClient) {
        this.worldClient = worldClient;
    }
}
