package com.joaovitor.onboardslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;
    ImageView Img_Slide;
    TextView Txt_TituloSlide;
    TextView Txt_ComentSlide;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    public int[] slide_images = {
            R.drawable.eat,
            R.drawable.sleep,
            R.drawable.code
    };
    public String[] slide_heads = {
            "EAT",
            "SLEEP",
            "CODE"
    };

    public String[] slide_desc = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in nisl massa. Donec a nibh risus",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in nisl massa. Donec a nibh risus",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce in nisl massa. Donec a nibh risus"
    };

    @Override
    public int getCount() {
        return slide_heads.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout,container,false);

        Img_Slide = (ImageView)  view.findViewById(R.id.Img_Slide);
        Txt_TituloSlide = (TextView) view.findViewById(R.id.Txt_TituloSlide);
        Txt_ComentSlide = (TextView) view.findViewById(R.id.Txt_ComentSlide);

        Img_Slide.setImageResource(slide_images[position]);
        Txt_TituloSlide.setText(slide_heads[position]);
        Txt_ComentSlide.setText(slide_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object){

        container.removeView((RelativeLayout) object);
    }
}