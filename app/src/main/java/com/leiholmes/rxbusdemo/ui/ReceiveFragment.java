package com.leiholmes.rxbusdemo.ui;

import android.widget.TextView;

import com.leiholmes.rxbusdemo.R;
import com.leiholmes.rxbusdemo.entity.PostMessage1;
import com.leiholmes.rxbusdemo.util.RxBus;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
/**
 * Description:   接收消息的Fragment
 * author         xulei
 * Date           2017/11/24 15:17
 */
public class ReceiveFragment extends BaseFragment {
    @BindView(R.id.tv_receive_msg)
    TextView tvReceiveMsg;

    public ReceiveFragment() {
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_receive;
    }

    @Override
    protected void onFragViewCreated() {
        addDisposable(RxBus.getInstance()
                .toFlowable(PostMessage1.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postMessage -> tvReceiveMsg.setText(postMessage.getMessage())));
    }
}
