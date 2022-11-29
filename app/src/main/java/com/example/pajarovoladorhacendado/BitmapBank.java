package com.example.pajarovoladorhacendado;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;

    Bitmap[] bird;

    public BitmapBank(Resources res) {

        background = BitmapFactory.decodeResource(res, R.drawable.main_background);
        background = scaleImage(background);

        bird = new Bitmap[4]; // si pusiéramos aquí distintos src de imágenes el pájaro volaría, pero solo quiero el flamenco estático
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.flamingo);
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.flamingo);
        bird[2] = BitmapFactory.decodeResource(res, R.drawable.flamingo);
        bird[3] = BitmapFactory.decodeResource(res, R.drawable.flamingo);

    }

    public Bitmap getBird(int frame){
        return bird[frame];
    }

    public int getBirdWidth(){
        return bird[0].getWidth();
    }

    public int getBirdHeight(){
        return bird[0].getHeight();
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
