package com.llbt.meepwn.lincoinblock.utils.binding;

import android.databinding.BindingConversion;
import android.graphics.drawable.ColorDrawable;

/**
 * package: com.llbt.meepwn.lincoinblock.utils
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/20 下午12:00
 * desc: Binding转换器
 */
public class Conversion {

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

}
