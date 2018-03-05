package com.alu.dailyworkuts.android.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017-09-19.
 */

public class RadiusImageUtils {


    public static Drawable getDrawableForRes(Context context,int res,int radius){
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), res); // 先从资源中吧背景图获取出来
        Bitmap roundBitmap = getRoundCornerImage(bitmap, radius); // 将图片的上半部分圆弧化。
        Drawable dw = new BitmapDrawable(context.getResources(),roundBitmap);
        return dw;
    }

    /**
     * 将图片的四角圆弧化
     *
     * @param bitmap      原图
     * @param roundPixels 弧度
     * @return
     */
    public static Bitmap getRoundCornerImage(Bitmap bitmap, int roundPixels) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        Bitmap roundConcerImage = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);//创建一个和原始图片一样大小的位图
        Canvas canvas = new Canvas(roundConcerImage);//创建位图画布
        Paint paint = new Paint();//创建画笔

        Rect rect = new Rect(0, 0, width, height);//创建一个和原始图片一样大小的矩形
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);// 抗锯齿

        canvas.drawRoundRect(rectF, roundPixels, roundPixels, paint);//画一个基于前面创建的矩形大小的圆角矩形
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//设置相交模式
        canvas.drawBitmap(bitmap, null, rect, paint);//把图片画到矩形去

        return  roundConcerImage;

    }

}
