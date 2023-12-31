package cn.langya.sun.modules.impl.render

import com.cubk.event.annotations.EventTarget
import cn.langya.sun.Sun
import cn.langya.sun.events.impl.Render2DEvent
import cn.langya.sun.ui.FontManager
import cn.langya.sun.ui.Ui
import cn.langya.sun.utils.render.RenderUtil
import cn.langya.sun.values.BoolValue
import cn.langya.sun.values.IntValue


/**
 * @author LangYa
 * @ClassName Arraylist
 * @date 2023/12/28 21:19
 * @Version 1.0
 */


class ArrayList(): Ui("Arraylist",0,0,0,0) {


    val shadow = BoolValue("Shaddow",false)
    val radius = IntValue("Radius",6,10,0)

    var yPosition = 50

    @EventTarget
    fun onRender2D(event: Render2DEvent) {

        var initialYPosition = yPosition

        for (module in Sun.moduleManager.modules) {
            if (module.array && module.state) {
                val displayString = module.name
                width = FontManager.height
                height = FontManager.getStringWidth(displayString)
                y = initialYPosition
                FontManager.drawString(displayString, x, y, RenderUtil.originalRainbow(400000000L))
                initialYPosition += FontManager.height + 2
            }
        }



    }


}