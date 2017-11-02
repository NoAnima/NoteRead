package runix.noteread;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

public class SeachActivity extends AppCompatActivity {

    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach);
//        WindowManager.LayoutParams lp=getWindow().getAttributes();
//        lp.alpha=0.5f;
//        lp.dimAmount=1.0f;
//
//        getWindow().setAttributes(lp);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);



        mEditText= (EditText) findViewById(R.id.et_seach);

        setEdit();
    }

    private void setEdit(){
        float scrollX= mEditText.getScrollX();
        float scrollY=mEditText.getScrollY();

        final float x= mEditText.getX();
        final float y= mEditText.getY();

        float tranX= mEditText.getTranslationX();
        float tranY= mEditText.getTranslationY();
        Log.i("setEdit","scrollX:"+scrollX+"  scrollY:"+scrollY +"   x:" +x+"   y:"+y);
//        mEditText.setX(x+200);
//        mEditText.setY(y+100);

        AnimationSet animationSet=new AnimationSet(true);

        TranslateAnimation translateAnimation =new TranslateAnimation(
                //X轴初始位置
                Animation.RELATIVE_TO_SELF, 0.5f,
                //X轴移动的结束位置
                Animation.RELATIVE_TO_SELF,x,
                //y轴开始位置
                Animation.RELATIVE_TO_SELF,0.5f,
                //y轴移动后的结束位置
                Animation.RELATIVE_TO_SELF,y);
        //3秒完成动画
        translateAnimation.setDuration(3000);
        //如果fillAfter的值为真的话，动画结束后，控件停留在执行后的状态
        animationSet.setFillAfter(true);
        //将AlphaAnimation这个已经设置好的动画添加到 AnimationSet中
        animationSet.addAnimation(translateAnimation);
        //启动动画
        mEditText.startAnimation(animationSet);


//       mEditText.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               mEditText.setTranslationX(x);
//               mEditText.setTranslationY(y);
//           }
//       });

//        WindowManager manager =getWindowManager();
//        getWindow().setBackgroundDrawableResource(R.color.colorTransparent);
//        manager.getDefaultDisplay()
        ValueAnimator valueAnimator= ObjectAnimator.ofInt(this,"backgroundColor", Color.TRANSPARENT,Color.WHITE);


        valueAnimator.setDuration(3000);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);

        valueAnimator.start();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
