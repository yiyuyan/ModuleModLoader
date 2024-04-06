package org.ksmcbrigade;

import org.ksmcbrigade.mixin.Service;
import org.ksmcbrigade.mods.ModInfo;
import org.ksmcbrigade.mods.ModUtils;
import org.spongepowered.asm.launch.MixinBootstrap;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class Main {

    public static Logger LOGGER = Logger.getGlobal();

    public static void runClient(ArrayList<String> args) throws IOException, InterruptedException {
        ArrayList<String> trueArgs = new ArrayList<>();
        trueArgs.add(System.getProperty("java.home")+(System.getProperty("os.name").contains("Windows")?"\\":"/")+"bin"+(System.getProperty("os.name").contains("Windows")?"\\":"/")+"java");
        for(String arg:args){
            if(arg.contains("org.ksmcbrigade.Main")){
                trueArgs.add("net.minecraft.client.main.Main");
            }
            else{
                trueArgs.add(arg);
            }
        }
        ProcessBuilder process = new ProcessBuilder(trueArgs);
        process.inheritIO();
        process.start().waitFor();
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException, InterruptedException {

        ModUtils.getMods(System.getProperty("user.dir")+(System.getProperty("os.name").contains("Windows")?"\\":"/")+"mods");

        if(ModUtils.mods!=null){
            LOGGER.info("All mods: ");
            for(ModInfo info:ModUtils.mods){
                LOGGER.info(info.toString());
            }
        }

        System.setProperty("mixin.service", Service.class.getName());
        MixinBootstrap.init();

        ArrayList<String> RunArgs = new ArrayList<>(ManagementFactory.getRuntimeMXBean().getInputArguments());
        RunArgs.add("-cp");
        RunArgs.add(System.getProperties().getProperty("java.class.path"));
        RunArgs.add("net.minecraft.client.main.Main");
        RunArgs.addAll(Arrays.asList(args));
        runClient(RunArgs);

        LOGGER.info("The Minecraft is stopped.");
        if(ModUtils.mods!=null){
            for(ModInfo info:ModUtils.mods){
                Method ModMethod = info.main.getDeclaredMethod("disabled");ModMethod.invoke(info.instance);
            }
        }
    }
}