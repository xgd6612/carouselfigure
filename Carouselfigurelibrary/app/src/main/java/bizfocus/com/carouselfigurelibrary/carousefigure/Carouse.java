package bizfocus.com.carouselfigurelibrary.carousefigure;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

import bizfocus.com.carouselfigurelibrary.R;

/**
 * Created by death on 2017/7/25.
 */

public class Carouse extends RelativeLayout {


    private  ViewPager vp;
    private int durtion;
    private boolean auto;
    private List<Integer> list;
    private Context context;

    public Carouse(Context context) {
        super(context);
        this.context=context;
    }

    public Carouse(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context =context;
        View view =LayoutInflater.from(context).inflate(R.layout.carouse,this,true);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Carouse);
        durtion = ta.getInt(R.styleable.Carouse_Duration,500);
        auto = ta.getBoolean(R.styleable.Carouse_auto_circle,true);
        vp = (ViewPager) view.findViewById(R.id.vp);
        ta.recycle();
    }


    public Carouse(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }



    public void  setList(List<Integer> list){
        this.list=list;
        if(list!=null &&list.size()>0){
            vp.setAdapter(new ViewPagerAdapter());
        }
    }









    //内部类
     class ViewPagerAdapter   extends PagerAdapter {

        public ViewPagerAdapter() {

        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            LayoutParams rlp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            relativeLayout.setLayoutParams(rlp);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(list.get(position));
            imageView.setLayoutParams(rlp);
            relativeLayout.addView(imageView);
            container.addView(relativeLayout);
            return relativeLayout;
        }


        //
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
