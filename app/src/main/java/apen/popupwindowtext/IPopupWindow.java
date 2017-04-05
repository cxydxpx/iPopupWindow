package apen.popupwindowtext;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 * Created by 002 on 2017/4/5.
 */

public class IPopupWindow extends PopupWindow {

    private Button takePhotoBtn, pickPhotoBtn, cancelBtn;
    private View mMenuView;

    public IPopupWindow(Context context, View.OnClickListener itemsOnClick) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.layout_dialog_pic, null);
		takePhotoBtn = (Button) mMenuView.findViewById(R.id.takePhotoBtn);
		pickPhotoBtn = (Button) mMenuView.findViewById(R.id.pickPhotoBtn);
		cancelBtn = (Button) mMenuView.findViewById(R.id.cancelBtn);
		cancelBtn.setOnClickListener(itemsOnClick);
		pickPhotoBtn.setOnClickListener(itemsOnClick);
		takePhotoBtn.setOnClickListener(itemsOnClick);

        this.setWidth(LinearLayout.LayoutParams.
                MATCH_PARENT);
        this.setHeight(LinearLayout.LayoutParams.
                MATCH_PARENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.setContentView(mMenuView);
//        this.setAnimationStyle(R.style.PopupAnimation);
        ColorDrawable dw = new ColorDrawable(0x80000000);
        this.setBackgroundDrawable(dw);
//
        this.update();
        mMenuView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

    }

    public void showPopupWindow(View parent){

        if (!this.isShowing()){
            this.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
        }else {
            this.dismiss();
        }

    }
}
