package com.bm.container.view;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import java.util.ArrayList;

public class TextUtil {
    public static void setText(Context context, TextView tv,
                               ArrayList<String> str, ArrayList<Integer> color,
                               ArrayList<Float> text_size_list) {
//		                       ArrayList<Float> text_size_list, ClickListener clickListener) {
        // 累加数组所有的字符串为一个字符串
        StringBuffer long_str = new StringBuffer();
        for (int i = 0; i < str.size(); i++) {
            long_str.append(str.get(i));
        }
        SpannableString builder = new SpannableString(long_str.toString());
//		// 设置不同字符串的点击事件
//		for (int i = 0; i < str.size(); i++) {
//			int p = i;
//			int star = long_str.toString().indexOf(str.get(i));
//			int end = star + str.get(i).length();
//			builder.setSpan(new Clickable(clickListener, p), star, end,
//					Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//		}

        // 设置不同字符串的颜色

        ArrayList<ForegroundColorSpan> foregroundColorSpans = new ArrayList<ForegroundColorSpan>();
        for (int i = 0; i < color.size(); i++) {
            foregroundColorSpans.add(new ForegroundColorSpan(color.get(i)));
        }
        for (int i = 0; i < str.size(); i++) {
            int star = long_str.toString().indexOf(str.get(i));
            int end = star + str.get(i).length();
            builder.setSpan(foregroundColorSpans.get(i), star, end,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        // 设置不同字符串的字号
//		ArrayList<AbsoluteSizeSpan> absoluteSizeSpans = new ArrayList<AbsoluteSizeSpan>();
//		for (int i = 0; i < color.size(); i++) {
//			absoluteSizeSpans.add(new AbsoluteSizeSpan(sp2px(context,
//					text_size_list.get(i))));
//		}
//		for (int i = 0; i < str.size(); i++) {
//			int star = long_str.toString().indexOf(str.get(i));
//			int end = star + str.get(i).length();
//			builder.setSpan(absoluteSizeSpans.get(i), star, end,
//					Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//		}
        // 设置点击后的颜色为透明，否则会一直出现高亮
        tv.setHighlightColor(Color.TRANSPARENT);
        tv.setClickable(true);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(builder);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }


}
