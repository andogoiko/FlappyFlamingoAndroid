package com.example.pajarovoladorhacendado;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;

    public BitmapBank(Resources res) {

        background = BitmapFactory.decodeResource(res, R.drawable.main_background);
        background = scaleImage(background);

    }

    //Return background bitmap

    public Bitmap getBackground(){
        return background;
    }

    //return background width

    public int getBackgroundWidth(){
        return background.getWidth();
    }

    //return background height

    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;

        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }

}
