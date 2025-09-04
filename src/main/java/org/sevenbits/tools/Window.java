package org.sevenbits.tools;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

public class Window implements NativeKeyListener {

    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

    private boolean flag = false;

    public Window (){
    }

    public  void run() throws IOException {
        try{
            GlobalScreen.registerNativeHook();
        }catch (NativeHookException e) {
            System.err.println(e);
            System.exit(1);
        }
        GlobalScreen.addNativeKeyListener(this);
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeEvent) {
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        if (nativeEvent.getKeyCode() == NativeKeyEvent.VC_CONTROL && nativeEvent.getKeyLocation() == 2) {
            this.flag = true;
        }
        if (nativeEvent.getKeyCode() == NativeKeyEvent.VC_S && this.flag == true){
            System.out.println("CTRL-L + s");
            this.flag = false;
        }if (nativeEvent.getKeyCode() == NativeKeyEvent.VC_R && this.flag == true){
            System.out.println("CTRL-L + r");
            this.flag = false;
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeEvent) {
    }
}