package com.leiholmes.rxbusdemo.ui;

import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.leiholmes.rxbusdemo.R;
import com.leiholmes.rxbusdemo.entity.PostMessage1;
import com.leiholmes.rxbusdemo.entity.PostMessage2;
import com.leiholmes.rxbusdemo.util.RxBus;

import butterknife.BindView;

/**
 * Description:   发送消息的Fragment
 * author         xulei
 * Date           2017/11/24 15:17
 */
public class PostFragment extends BaseFragment {
    @BindView(R.id.tv_post_msg1)
    EditText tvPostMsg1;
    @BindView(R.id.tv_post_msg2)
    EditText tvPostMsg2;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_post;
    }

    @Override
    protected void onFragViewCreated() {
        addDisposable(RxTextView.textChanges(tvPostMsg1)
                .map(CharSequence::toString)
                .subscribe(content -> RxBus.getInstance().postOld(new PostMessage1(content))));
        addDisposable(RxTextView.textChanges(tvPostMsg2)
                .map(CharSequence::toString)
                .subscribe(content -> RxBus.getInstance().post(new PostMessage2(content))));
    }
}
