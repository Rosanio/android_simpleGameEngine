package com.epicodus.simplegameengine;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        draw();
        setContentView(ourView);
    }

    public void draw() {
        //Bitmaps are a sort of blank graphic to draw upon.
        Bitmap blankBitmap;
        //parameters are length, width, and format
        blankBitmap = Bitmap.createBitmap(600, 600, Bitmap.Config.ARGB_8888);
        Canvas canvas;
        canvas = new Canvas(blankBitmap);
        //ourview is set as the content view in onCreate, so setting ourview equal to our bitmap will
        // render whatever is drawn on the bitmap to the screen
        ourView = new ImageView(this);
        ourView.setImageBitmap(blankBitmap);

        //paint is an object which lets you draw on the canvas
        Paint paint;
        paint = new Paint();
        //make canvas background color white
        canvas.drawColor(Color.argb(255, 255, 255, 255));
        //make paint color blue
        paint.setColor(Color.argb(255, 26, 128, 182));

        Bitmap bitmapBob;
        //decoderesource is probably magic, might be useful to decode other sprites which are png files
        bitmapBob = BitmapFactory.decodeResource(this.getResources(), R.drawable.bob);
        //parameters for drawBitmap are bitmap, x-location, y-location, and paint (not sure why for
        // this last one)
        canvas.drawBitmap(bitmapBob, 500, 50, paint);
        //parameters for drawLine are startX, startY, endX, endY, paint (for color)
        canvas.drawLine(50, 50, 250, 250, paint);
        //parameters for drawText are text, startX, startY, paint
        canvas.drawText("Game Code School", 50, 50, paint);
        //parameters for drawPoint are x, y, paint
        canvas.drawPoint(40, 50, paint);
        //parameters for drawCircle are centerX, centerY, radius, paint
        canvas.drawCircle(350, 250, 100, paint);
        //make paint orange
        paint.setColor(Color.argb(255, 249, 129, 0));
        //parameters for drawRect are leftSideX, topSideY, rightSideX, bottomSideY, paint
        canvas.drawRect(50, 450, 500, 550, paint);
    }
}