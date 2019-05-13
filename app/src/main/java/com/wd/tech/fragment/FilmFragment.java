package com.wd.tech.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wd.tech.R;
import com.wd.tech.contract.ContractIntface;

/**
 * @Author：谷世龙
 * @E-mail： 15001194794@163.com
 * @Date：2019/5/11 8:32
 * @Description：描述信息
 */
public class FilmFragment extends Fragment implements ContractIntface.FilmIntface {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_film, container, false);
        return view;
    }

    @Override
    public void showHot(Object obj) {

    }

    @Override
    public void showHotshowing(Object obj) {

    }

    @Override
    public void showShangying(Object obj) {

    }
}
