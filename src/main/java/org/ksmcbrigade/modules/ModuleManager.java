package org.ksmcbrigade.modules;

import java.util.ArrayList;

public class ModuleManager {
    public static ArrayList<Module> modules = new ArrayList<>();

    public enum Categories{
        BLOCK(),
        ITEM(),
        MOVE(),
        COMBAT(),
        RENDER(),
        CHAT(),
        FUN(),
        MISC();

        public ArrayList<Module> modulesList = new ArrayList<>();

        public void add(Module module){
            ModuleManager.modules.add(module);
            modulesList.add(module);
        }

        public boolean has(String name){
            for(Module module:modulesList){
                if(module.name.equals(name)){
                    return true;
                }
            }
            return false;
        }

        public Module get(String name){
            for(Module module:modulesList){
                if(module.name.equals(name)){
                    return module;
                }
            }
            return null;
        }
    }
}
