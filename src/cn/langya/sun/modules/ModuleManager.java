package cn.langya.sun.modules;

import cn.langya.sun.modules.impl.client.Client;
import cn.langya.sun.modules.impl.combat.KillAura;
import cn.langya.sun.utils.ClientUtils;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public final List<Module> modules = new ArrayList<>();

    private void registerModule(Module module) {
        modules.add(module);
    }

    public void registerModules() {
        registerModule(new Client());
        registerModule(new KillAura());
    }

    public void init() {
        ClientUtils.loginfo("[模块系统] 加载模块中...");
        registerModules();
        ClientUtils.loginfo("[模块系统] 已加载模块: " + modules.size());
    }
}