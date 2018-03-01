package com.magic.szh.cnf_168p2p.widget;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.security.PublicKey;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.widget
 * file: CircleProgressBar
 * author: admin
 * date: 2018/3/1
 * description: 圆环进度条
 */

public class CircleProgressBar extends View {
    // 默认半径大小
    private final int DEFAULT_RADIUS = 60;
    // 最大进度值
    private final int MAX_PROGRESS = 100;
    // 指定进度
    private int progress = 0;
    // 当前进度值
    private int currentProgress = 0;
    // 进度条背景色
    private final String RING_COLOR = "#dedede";
    // 当前进度颜色
    private final String PROGRESS_COLOR = "#f65b66";
    private final int PROGRESS_WAITH = 10;
    Paint mPaint;
    RectF mOval;

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measure(widthMeasureSpec), measure(heightMeasureSpec));
    }

    /**
     * 设置布局的尺寸
     * @param measureSpec 尺寸
     * @return 计算后的尺寸
     */
    private int measure(int measureSpec) {
        int result;
        // 获取测量模式和测量大小
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize + PROGRESS_WAITH*2;
        } else {
            //半径*2 + 进度条宽度*2
            int measure = measureBackground();
            if (measure <= 0) measure = DEFAULT_RADIUS * 2;
            result = measure + PROGRESS_WAITH * 2;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    private int measureBackground() {
        BitmapDrawable drawable = (BitmapDrawable) getBackground();
        Bitmap bitmap = drawable.getBitmap();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        return Math.min(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        canvas.drawColor(Color.parseColor("#00000000"));

        mOval.left = mOval.top = PROGRESS_WAITH;
        mOval.right = mOval.bottom = width - PROGRESS_WAITH;
        drawStroke(canvas);
        if (currentProgress < progress) {
            currentProgress++;
            postInvalidateDelayed(1);
        }
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mOval = new RectF();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    /**
     * 绘制进度条
     * @param canvas 画布对象
     */
    private void drawStroke(Canvas canvas) {
        mPaint.setColor(Color.parseColor(RING_COLOR));
        mPaint.setStrokeWidth(PROGRESS_WAITH);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(mOval, -90, 360, false, mPaint);
        mPaint.setColor(Color.parseColor(PROGRESS_COLOR));
        canvas.drawArc(mOval, -90, ((float) currentProgress / MAX_PROGRESS) * 360, false, mPaint);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }
}
