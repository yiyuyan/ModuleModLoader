package org.ksmcbrigade.mods;

public class RunClassLoader extends ClassLoader{
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (name.equals("java.lang.System")) {
            return super.loadClass("com.example.CustomSystem", resolve);
        } else {
            return super.loadClass(name, resolve);
        }
    }
}
