package cn.langya.sun.modules.impl.client;

import cn.langya.sun.modules.Category;
import cn.langya.sun.modules.Module;
import cn.langya.sun.ui.screen.clickgui.DropdownClickGUI;
import org.lwjgl.input.Keyboard;

/**
 * @author LangYa
 * @ClassName ClickGui
 * @date 2024/1/9 下午 08:52
 * @Version 1.0
 */

public class ClickGui extends Module {
    @Override
    public void onEnable() {
        mc.displayGuiScreen(new DropdownClickGUI());
    }

    public ClickGui() {
        super("ClickGui", Category.Client);
        keyCode = Keyboard.KEY_RSHIFT;
    }
}
