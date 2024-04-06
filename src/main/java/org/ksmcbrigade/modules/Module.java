package org.ksmcbrigade.modules;

public class Module {

    public final String name;
    public boolean enabled;
    public int key;

    public Module(String name,boolean e,int key){
        this.name = name;
        this.enabled = e;
        this.key = key;
    }

    public Module(String name,boolean e){
        this(name,e,-1);
    }

    public Module(String name){
        this(name,false);
    }

    public void enabled()throws Exception{}
    public void disabled()throws Exception{}
    public void up()throws Exception{}
    public void key(int key)throws Exception{}
    public void render()throws Exception{}

    public void set(boolean e)throws Exception{
        this.enabled = e;
        if(e){
            this.enabled();
        }
        else{
            this.disabled();
        }
    }
}
