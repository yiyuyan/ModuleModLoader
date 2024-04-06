package org.ksmcbrigade.mods;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.jar.JarFile;

public class ModUtils {
    public static ArrayList<ModInfo> mods;
    public static ModClassLoader loader;

    public static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public static void getMods(String dirStr) {
        File dir = new File(dirStr);
        while (!dir.exists()){
            dir.mkdirs();
        }
        if(dir.isDirectory()){
            FileFilter filter = pathname -> pathname.getName().toLowerCase().endsWith(".jar") || pathname.getName().toLowerCase().endsWith(".zip");
            File[] files = dir.listFiles(filter);
            if(files!=null && !Arrays.equals(files, new File[0])){
                mods = new ArrayList<>();
                ArrayList<URL> urls = new ArrayList<>();
                for(File file: files){
                    try {
                        JarFile Jarfile = new JarFile(file);
                        JsonObject info = JsonParser.parseString(convertInputStreamToString(Jarfile.getInputStream(Jarfile.getEntry("info.json")))).getAsJsonObject();
                        JsonObject mixin = JsonParser.parseString(convertInputStreamToString(Jarfile.getInputStream(Jarfile.getEntry(info.get("mixin").getAsString())))).getAsJsonObject();
                        Jarfile.close();
                        urls.add(file.toURL());
                        if(loader==null){
                            loader = new ModClassLoader(urls.toArray(new URL[0]));
                        }
                        else{
                            loader.addURL(file.toURL());
                        }
                        Class<?> modMain = loader.findClass(info.get("main").getAsString());
                        Object ins = modMain.newInstance();
                        mods.add(new ModInfo(file,modMain,info,mixin,ins));
                        Method method = modMain.getDeclaredMethod("load");
                        method.invoke(ins);
                    }
                    catch (Exception E){
                        System.out.println("Can't load the mod file: "+file.getPath());
                    }
                }
            }
        }
    }
}
