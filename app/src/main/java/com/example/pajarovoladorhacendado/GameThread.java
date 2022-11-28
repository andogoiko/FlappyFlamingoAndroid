package com.example.pajarovoladorhacendado;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread{

    SurfaceHolder surfaceHolder;
    boolean isRunning;
    long startTime, loopTime;
    long DELAY = 33; // delay en milisegundos paara refresco entre pantallas


    public GameThread(SurfaceHolder surfaceHolder){
        this.surfaceHolder = surfaceHolder;
        isRunning = true;
    }

    @Override
    public void run(){

        while(isRunning){
            startTime = SystemClock.uptimeMillis();
            // bloqueando el canvas

            Canvas canvas = surfaceHolder.lockCanvas(null);

            if (canvas != null){
                synchronized (surfaceHolder){
                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
                    //desbloqueando el canvas
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

            loopTime = SystemClock.uptimeMillis() - startTime;

            // pausa de comprobación de conteo correcto de segundos

            if (loopTime < DELAY){
                try {
                    Thread.sleep(DELAY - loopTime);
                } catch (InterruptedException e) {
                    Log.e("Interrumpido", "interrumpido en la pausa");
                }
            }

        }

    }

    public boolean isRunning(){
        return isRunning;
    }

    public void setIsRunning(boolean state){
        isRunning = state;
    }

}
