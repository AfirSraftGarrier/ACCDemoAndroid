package afirsraftgarrier.demoandroid.snap.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.widget.TextView;

import afirsraftgarrier.demoandroid.R;

/**
 * Created by AfirSraftGarrier on 2016/12/12 0012.
 */

public class SimpleThreadActivity extends Activity {
    private TextView mTvServiceInfo;
    private Handler handler;
    private static final int TAG_REFRESH = 0;
    private static final String PARAM_DATA_RATE = "rate";
    private Thread thread;
    private static boolean close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_handler);
        mTvServiceInfo = (TextView) findViewById(R.id.id_textview);
        this.handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == TAG_REFRESH) {
                    String result = "实时更新中，当前大盘指数：<font color='red'>%d</font>";
                    result = String.format(result, msg.getData().getInt(PARAM_DATA_RATE));
                    mTvServiceInfo.setText(Html.fromHtml(result));
                }
            }
        };
        this.close = false;
        getSimpleThread(this.handler).start();
    }

    private static Thread getSimpleThread(final Handler handler) {
        return new Thread() {
            public void run() {
                while (!close) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(PARAM_DATA_RATE, (int) (Math.random() * 3000 + 1000));
                    Message message = handler.obtainMessage(TAG_REFRESH);
                    message.setData(bundle);
                    message.sendToTarget();
                }
            }
        };
    }

    private static Thread getRunnableThread(final Handler handler) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (!close) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt(PARAM_DATA_RATE, (int) (Math.random() * 3000 + 1000));
                    Message message = handler.obtainMessage(TAG_REFRESH);
                    message.setData(bundle);
                    message.sendToTarget();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        close = true;
    }
}
