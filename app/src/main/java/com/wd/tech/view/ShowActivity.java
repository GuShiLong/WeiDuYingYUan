package com.wd.tech.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wd.tech.R;
import com.wd.tech.adapter.MyFragmentAdapter;
import com.wd.tech.fragment.CinemaFragment;
import com.wd.tech.fragment.FilmFragment;
import com.wd.tech.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {


    @BindView(R.id.show_viewpager)
    ViewPager showViewpager;
    @BindView(R.id.rb_movie_home)
    RadioButton rbMovieHome;
    @BindView(R.id.rb_movie_cinema)
    RadioButton rbMovieCinema;
    @BindView(R.id.rb_movie_my)
    RadioButton rbMovieMy;
    @BindView(R.id.movie_group)
    RadioGroup movieGroup;

    MyFragmentAdapter adapter;
    List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);

        list.add(new FilmFragment());
        list.add(new CinemaFragment());
        list.add(new MyFragment());
        adapter=new MyFragmentAdapter(getSupportFragmentManager(),list);
        showViewpager.setAdapter(adapter);

        showViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                movieGroup.check(movieGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        movieGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_movie_home:
                        showViewpager.setCurrentItem(0,false);
                        movieGroup.getChildAt(0).setBackgroundResource(R.mipmap.yingpiantrue);
                        movieGroup.getChildAt(1).setBackgroundResource(R.mipmap.yingyuan);
                        movieGroup.getChildAt(2).setBackgroundResource(R.mipmap.wode);
                        break;
                    case R.id.rb_movie_cinema:
                        showViewpager.setCurrentItem(1,false);
                        movieGroup.getChildAt(0).setBackgroundResource(R.mipmap.yingpian);
                        movieGroup.getChildAt(1).setBackgroundResource(R.mipmap.yingyuantrue);
                        movieGroup.getChildAt(2).setBackgroundResource(R.mipmap.wode);
                        break;
                    case R.id.rb_movie_my:
                        showViewpager.setCurrentItem(2,false);
                        movieGroup.getChildAt(0).setBackgroundResource(R.mipmap.yingpian);
                        movieGroup.getChildAt(1).setBackgroundResource(R.mipmap.yingyuan);
                        movieGroup.getChildAt(2).setBackgroundResource(R.mipmap.wodetrue);
                        break;

                        default:
                            break;
                }
            }
        });
    }
}
