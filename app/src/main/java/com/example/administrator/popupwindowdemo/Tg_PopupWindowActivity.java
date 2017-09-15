package com.example.administrator.popupwindowdemo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.popupwindowdemo.popupwindow.TypeShowDislog;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/14.
 */

public class Tg_PopupWindowActivity extends BaseActivity {
    private LinearLayout ll_qgdq;
    private TextView tv_qgdq;

    private LinearLayout ll_tglx;
    private TextView tv_tglx;

    private LinearLayout ll_xzjs;
    private TextView tv_xzjs;

    private LinearLayout ll_mrpx;
    private TextView tv_mrpx;
    private TypeShowDislog mShowDislog;

    private ArrayList<String> tglx_list=new ArrayList<>();
    private ArrayList<String> xzjs_list=new ArrayList<>();
    private ArrayList<String> mrpx_list=new ArrayList<>();
    @Override
    protected void initVariables() {
        tglx_list.add("类型不限");
        tglx_list.add("找模特通告");
        tglx_list.add("找化妆通告");
        tglx_list.add("找摄影通告");
        tglx_list.add("找美工设计通告");
        tglx_list.add("找主播");
        tglx_list.add("找美女");
        tglx_list.add("找帅哥");

        xzjs_list.add("类型不限");
        xzjs_list.add("日结");
        xzjs_list.add("次结");
        xzjs_list.add("时结");
        xzjs_list.add("件数");
        xzjs_list.add("一次性结");

        mrpx_list.add("默认排序");
        mrpx_list.add("薪资低");
        mrpx_list.add("薪资高");
        mrpx_list.add("时间");
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_tgpopuowindow);
        ll_qgdq = (LinearLayout) findViewById(R.id.ll_qgdq);
        ll_tglx = (LinearLayout) findViewById(R.id.ll_tglx);
        ll_xzjs = (LinearLayout) findViewById(R.id.ll_xzjs);
        ll_mrpx = (LinearLayout) findViewById(R.id.ll_mrpx);

        tv_qgdq = (TextView) findViewById(R.id.tv_qgdq);//全国地区
        tv_tglx = (TextView) findViewById(R.id.tv_tglx);//通告类型
        tv_xzjs = (TextView) findViewById(R.id.tv_xzjs);//薪资结算
        tv_mrpx = (TextView) findViewById(R.id.tv_mrpx);//默认排序
    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        //全国地区
        ll_qgdq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDrawableImg(tv_qgdq,R.drawable.icon_drop_down_on);

            }
        });
        //通告类型
        ll_tglx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDrawableImg(tv_tglx,R.drawable.icon_drop_down_on);
                mShowDislog=new TypeShowDislog(Tg_PopupWindowActivity.this, tglx_list, new TypeShowDislog.DialogCallback() {
                    @Override
                    public void DialogOK(String strName) {
                        Toast.makeText(getApplicationContext(),strName,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void DialogCancel() {
                        checkDrawableImg(tv_tglx,R.drawable.icon_drop_down_off);
                    }
                });
                mShowDislog.showAsDropDown(v);
                mShowDislog.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        checkDrawableImg(tv_tglx,R.drawable.icon_drop_down_off);
                    }
                });

            }
        });
        //薪资结算
        ll_xzjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDrawableImg(tv_xzjs,R.drawable.icon_drop_down_on);
                mShowDislog=new TypeShowDislog(Tg_PopupWindowActivity.this, xzjs_list, new TypeShowDislog.DialogCallback() {
                    @Override
                    public void DialogOK(String strName) {
                        Toast.makeText(getApplicationContext(),strName,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void DialogCancel() {
                        checkDrawableImg(tv_xzjs,R.drawable.icon_drop_down_off);
                    }
                });
                mShowDislog.showAsDropDown(v);
                mShowDislog.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        checkDrawableImg(tv_xzjs,R.drawable.icon_drop_down_off);
                    }
                });
            }
        });
        //默认排序
        ll_mrpx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDrawableImg(tv_mrpx,R.drawable.icon_drop_down_on);
                mShowDislog=new TypeShowDislog(Tg_PopupWindowActivity.this, mrpx_list, new TypeShowDislog.DialogCallback() {
                    @Override
                    public void DialogOK(String strName) {
                        Toast.makeText(getApplicationContext(),strName,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void DialogCancel() {
                        checkDrawableImg(tv_mrpx,R.drawable.icon_drop_down_off);
                    }
                });
                mShowDislog.showAsDropDown(v);
                mShowDislog.setOnDismissListener(new PopupWindow.OnDismissListener() {

                    @Override
                    public void onDismiss() {
                        checkDrawableImg(tv_mrpx,R.drawable.icon_drop_down_off);
                    }
                });
            }
        });


    }
    //修改那个上下的小图标
    private void checkDrawableImg(TextView tv,int icon)
    {
        Drawable drawable = mContext.getResources().getDrawable(icon);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv.setCompoundDrawables(null, null, drawable, null);
    }

    @Override
    protected void loadData() {

    }
}
