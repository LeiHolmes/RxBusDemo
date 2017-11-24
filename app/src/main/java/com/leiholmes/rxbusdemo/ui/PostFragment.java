package com.leiholmes.rxbusdemo.ui;

import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;
import com.leiholmes.rxbusdemo.R;
import com.leiholmes.rxbusdemo.entity.PostMessage1;
import com.leiholmes.rxbusdemo.util.RxBus;

import butterknife.BindView;
import io.reactivex.disposables.CompositeDisposable;
/**
 * Description:   发送消息的Fragment
 * author         xulei
 * Date           2017/11/24 15:17
 */
public class PostFragment extends BaseFragment {
    @BindView(R.id.tv_post_msg)
    EditText tvPostMsg;

    public PostFragment() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_post;
    }

    @Override
    protected void onFragViewCreated() {
        addDisposable(RxTextView.textChanges(tvPostMsg)
                .map(CharSequence::toString)
                .subscribe(content -> RxBus.getInstance().post(new PostMessage1(content))));
    }
}
