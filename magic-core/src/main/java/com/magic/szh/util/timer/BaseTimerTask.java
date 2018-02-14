package com.magic.szh.util.timer;

import java.util.TimerTask;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.util.timer
 * file: BaseTimerTask
 * author: admin
 * date: 2018/2/14
 * description: 异步时间任务基类
 */

public class BaseTimerTask extends TimerTask {
    private ITimerListener mITimerListener;

    public BaseTimerTask(ITimerListener ITimerListener) {
        mITimerListener = ITimerListener;
    }

    @Override
    public void run() {
        if (mITimerListener != null) {
            mITimerListener.onTimer();
        }
    }

}
