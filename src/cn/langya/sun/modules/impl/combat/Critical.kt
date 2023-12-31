package cn.langya.sun.modules.impl.combat

import cn.langya.sun.events.impl.AttackEvent
import cn.langya.sun.modules.Category
import cn.langya.sun.modules.Module
import cn.langya.sun.values.StringValue
import com.cubk.event.annotations.EventTarget


/**
 * @author LangYa
 * @ClassName Critical
 * @date 2023/12/31 10:34
 * @Version 1.0
 */

class Critical: Module("刀刀暴击",true,Category.Combat) {

    private val modes = StringValue("Modes","Jump")

    init {
        modes.values.add("Jump")
        modes.values.add("Fake")
    }

    @EventTarget
    fun onAttack(event: AttackEvent) {
        when(modes.get()) {

            "Jump" -> {
                if(mc.player.onGround) {
                    mc.player.jump()
                }
            }

            "Fake" -> {
                mc.player.onCriticalHit(event.target)
            }

        }
    }

}