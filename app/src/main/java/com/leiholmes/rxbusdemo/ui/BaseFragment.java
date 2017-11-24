package com.leiholmes.rxbusdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Description:
 * author         xulei
 * Date           2017/11/24
 */

public abstract class BaseFragment extends Fragment {
    protected View view;
    protected CompositeDisposable compositeDisposable;
    private Unbinder mUnbinder;

    protected abstract int getLayoutId();

    protected abstract void onFragViewCreated();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), null);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        onFragViewCreated();
    }

    /**
     * 添加订阅
     */
    protected void addDisposable(Disposable mDisposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(mDisposable);
    }

    /**
     * 取消所有订阅
     */
    protected void clearDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
        clearDisposable();
    }
}
