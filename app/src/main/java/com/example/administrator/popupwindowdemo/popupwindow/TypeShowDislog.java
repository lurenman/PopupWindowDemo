package com.example.administrator.popupwindowdemo.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.administrator.popupwindowdemo.R;
import com.example.administrator.popupwindowdemo.adapter.TypeShowDislogAdapter;

import java.util.ArrayList;


public class TypeShowDislog extends PopupWindow {

    private View mMenuView;

    private ListView mlistView;
    private TypeShowDislogAdapter mAdapter;
    private ArrayList<String> mDatas = new ArrayList<String>();

    private Context mcontext;

    /**
     * it will show the OK/CANCEL dialog like iphone, make sure no keyboard is
     * visible
     */
    @SuppressWarnings("deprecation")
    public TypeShowDislog(Activity context, ArrayList<String> datas,
                          final DialogCallback callback) {
        super(context);
        mcontext = context;
        mDatas = datas;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.type_showdislog, null);

        initView();
        initEvent(callback);

        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.FILL_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.FILL_PARENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // // 设置SelectPicPopupWindow弹出窗体动画效果
       //  this.setAnimationStyle(R.style.AnimBottom);
        this.setAnimationStyle(R.anim.ceshi);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x99000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {

                // int height =
                // mMenuView.findViewById(R.id.pop_layout).getTop();
                // int y = (int) event.getY();
                // if (event.getAction() == MotionEvent.ACTION_UP) {
                // if (y < height) {
                // dismiss();
                // }
                // }
                callback.DialogCancel();
                dismiss();
                return true;
            }
        });
    }

    private void initView() {
        mlistView = (ListView) mMenuView.findViewById(R.id.lv_list);
        mAdapter = new TypeShowDislogAdapter(mcontext, mDatas);
        mlistView.setAdapter(mAdapter);
    }

    private void initEvent(final DialogCallback callback) {
        mlistView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
                dismiss();
                callback.DialogOK(tv_name.getText().toString());
            }
        });
    }

    // 对外界开放的回调接口
    public interface DialogCallback {
        // 注意 此方法是用来设置目标对象的图像资源
        public void DialogOK(String strName);

        public void DialogCancel();
    }
}
