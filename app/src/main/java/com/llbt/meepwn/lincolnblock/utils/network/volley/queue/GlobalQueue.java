package com.llbt.meepwn.lincolnblock.utils.network.volley.queue;

import android.content.Context;

import com.llbt.meepwn.lincolnblock.library.volley.RequestQueue;
import com.llbt.meepwn.lincolnblock.library.volley.toolbox.Volley;

/**
 * package: com.llbt.meepwn.lincolnblock.utils.network.volley.queue
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/5/3 上午9:20
 * desc: Volley全局队列(单例)
 */
public class GlobalQueue {

	private volatile static RequestQueue queue;

	public static RequestQueue getGlobalQueue(Context context) {
		if (queue == null) {
			synchronized (GlobalQueue.class) {
				if (queue == null) {
					queue = Volley.newRequestQueue(context);
				}
			}
		}
		return queue;
	}

}
