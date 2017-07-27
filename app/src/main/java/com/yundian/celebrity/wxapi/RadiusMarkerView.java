package com.yundian.celebrity.wxapi;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.yundian.celebrity.R;
import com.yundian.celebrity.utils.DisplayUtil;

/**
 * Created by Administrator on 2017/3/20.
 */
public class RadiusMarkerView extends MarkerView {
    private Context context;
    private TextView currentPrice;
//    private TextView time;
    private LinearLayout markerView;

    public RadiusMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        currentPrice = (TextView) findViewById(R.id.tv_currentPrice);
//        time = (TextView) findViewById(R.id.time);
        markerView = (LinearLayout) findViewById(R.id.ll_marker_line);
        this.context = context;
    }

    @Override
    public void refreshContent(Entry entry, Highlight highlight) {
        if (entry.getData() == null) {
            markerView.setVisibility(INVISIBLE);
        } else {
            markerView.setVisibility(VISIBLE);
            currentPrice.setText(entry.getVal() + "");
//            time.setText(entry.getData() + "");
        }

    }

    @Override
    public int getXOffset(float xpos) {
        if (xpos < DisplayUtil.getScreenWidth(context) / 2) {
            return -(getWidth()/2);
        }
        return -(getWidth()/2);
    }

    @Override
    public int getYOffset(float ypos) {
        int px = DisplayUtil.dip2px(10);
        return -getHeight()-px;
    }

//    @Override
//    public void draw(Canvas canvas, float posx, float posy) {
//        if (posx > DisplayUtil.getScreenWidth(context) / 2) {
//            canvas.translate(0, 0);
//        } else {
//            canvas.translate(DisplayUtil.getScreenWidth(context) - getWidth(), 0);
//        }
//        draw(canvas);
//    }
}
