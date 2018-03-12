package com.joaovitor.onboardslider;

import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.joaovitor.onboardslider.SliderAdapter;

public class telaMain extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout Lay_Dots;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button Btn_Next;
    private Button Btn_Back;

    private int PaginaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_main);

        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        Lay_Dots = (LinearLayout) findViewById(R.id.Lay_Dots);
        Btn_Back = (Button) findViewById(R.id.Btn_Back);
        Btn_Next = (Button) findViewById(R.id.Btn_Next);

        sliderAdapter = new SliderAdapter(this);

        //Seta o adaptador e adiciona os indicadores de ponto.
        mViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);

        mViewPager.addOnPageChangeListener(viewListener);

        Btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(PaginaAtual + 1);
            }
        });
        Btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(PaginaAtual - 1);
            }
        });
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        //Remove a criação de novos pontos no layout
        Lay_Dots.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.CorBrancaTransparente));
            Lay_Dots.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.CorBranca));
        }
    }

    OnPageChangeListener viewListener = new OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        //adiciona as opções das paginas do View pager.
        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            //Valor inteiro nulo recebe a posição atual.
            PaginaAtual = position;

            //Condição para exibição das abas do layout.
            if (position == 0) {
                Btn_Next.setEnabled(true);
                Btn_Back.setEnabled(false);
                Btn_Back.setVisibility(View.INVISIBLE);

                Btn_Next.setText("Next");
                Btn_Back.setText("");
            } else if (position == 1) {
                Btn_Next.setEnabled(true);
                Btn_Back.setEnabled(true);
                Btn_Back.setVisibility(View.VISIBLE);

                Btn_Next.setText("Next");
                Btn_Back.setText("Back");
            } else {
                Btn_Next.setEnabled(true);
                Btn_Back.setEnabled(true);
                Btn_Back.setVisibility(View.VISIBLE);

                Btn_Next.setText("Finish");
                Btn_Back.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
