package afirsraftgarrier.demoandroid.snap.loadpic.zhy;

import android.support.v4.app.Fragment;

import afirsraftgarrier.demoandroid.R;

public class ZHYImageLoadActivity extends AbsSingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ListImgsFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_single_fragment;
    }
}
