package org.ksmcbrigade.mods;

import com.google.gson.JsonObject;

import java.io.File;

public class ModInfo {

    public File file;
    public Class<?> main;
    public JsonObject info;
    public JsonObject mixin;
    public Object instance;

    public ModInfo(File file, Class<?> main, JsonObject info, JsonObject mixin,Object instance){
        this.file = file;
        this.main = main;
        this.mixin = mixin;
        this.info = info;
        this.instance = instance;
    }

    @Override
    public String toString() {
        return "ModInfo{" +
                "file=" + file.getPath() +
                ", main=" + main.getName() +
                ", info=" + info.toString() +
                ", mixin=" + mixin.toString() +
                '}';
    }
}
