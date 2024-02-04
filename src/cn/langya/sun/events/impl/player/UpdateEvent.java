package cn.langya.sun.events.impl.player;

import com.cubk.event.impl.Event;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;

/**
 * @author LangYa
 * @ClassName UpdateEvent
 * @date 2023/12/28 20:26
 * @Version 1.0
 */

public class UpdateEvent implements Event {
    @Getter
    private float yaw;
    @Setter
    public float pitch;
    @Setter
    public boolean onGround;

    public UpdateEvent(float yaw,float pitch,boolean onGround) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
        Minecraft mc = Minecraft.getMinecraft();
        mc.player.prevRenderYawOffset = yaw;
        mc.player.renderYawOffset = yaw;
        mc.player.prevRotationYawHead = yaw;
        mc.player.rotationYawHead = yaw;
    }
}
