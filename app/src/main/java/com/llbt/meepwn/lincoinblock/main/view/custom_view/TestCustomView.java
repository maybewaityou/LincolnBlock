package com.llbt.meepwn.lincoinblock.main.view.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.llbt.meepwn.lincoinblock.R;

/**
 * package: com.llbt.meepwn.lincoinblock.main.view.custom_view
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/21 下午1:16
 * desc:
 */
public class TestCustomView extends View {

    private String mText;

    public TestCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TestCustomView);
        mText = typedArray.getString(R.styleable.TestCustomView_text);
    }

    public final void setText(CharSequence text) {
        if(text == null) return;

        mText = text.toString();
        System.out.println("== text ===>>>> " + mText);
    }

    public final String getText() {
        return mText;
    }

}
