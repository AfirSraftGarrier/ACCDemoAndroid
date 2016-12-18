package afirsraftgarrier.demoandroid.framework.butterknife;


import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.EditText;
import android.widget.TextView;

import afirsraftgarrier.demoandroid.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by AfirSraftGarrier on 2016/12/17 0012.
 * <desc>
 * This require in module gradle
 * dependencies {
 * compile 'com.jakewharton:butterknife:8.4.0'
 * annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'
 * }
 * </desc>
 * <link>https://github.com/JakeWharton/butterknife</link>
 */
public class ButterknifeMain extends Activity {
    @BindView(R.id.tv_hello)
    TextView helloTextView;
    private Integer count = 0;

    @OnClick(R.id.tv_hello)
    void change() {
        this.helloTextView.setText(this.getNextCountString());
    }

    private String getNextCountString() {
        count++;
        return String.format(this.getString(R.string.framework_butterknife_hello), this.count);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_framework_butterknife_main);
        ButterKnife.bind(this);
        this.helloTextView.setText(this.getNextCountString());
    }
}