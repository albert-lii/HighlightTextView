package com.liyi.example;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.liyi.highlight.HighlightTextView;

public class MainActivity extends AppCompatActivity {
    private HighlightTextView tv1, tv2, tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (HighlightTextView) findViewById(R.id.tv_1);
        tv2 = (HighlightTextView) findViewById(R.id.tv_2);
        tv3 = (HighlightTextView) findViewById(R.id.tv_3);
        tv4 = (HighlightTextView) findViewById(R.id.tv_4);

        tv1.addBgColorStyle(Color.BLUE, 0, 10)
                .addFontColorStyle(Color.YELLOW, 12, 14)
                .build();
        tv2.addContent("\n\n2、路飞上上去就是一拳，一招猿王枪，多弗朗明哥差点招架不住，多弗朗明哥立马觉醒果实能力：'十六发神圣凶弹.神诛杀!'路飞勃然变色，" +
                "直接开大，‘大猿王枪’，多弗朗明哥败！")
                .addClickStyleByKey(new HighlightTextView.OnHighlightClickListener() {
                    @Override
                    public void onTextClick(int position, View v) {
                        Toast.makeText(MainActivity.this, "我是多弗朗明哥", Toast.LENGTH_SHORT).show();
                    }
                }, true, "多弗朗明哥")
                .build();
        tv3.addContent("\n\n3、路飞上上去就是一拳，一招猿王枪，多弗朗明哥差点招架不住，多弗朗明哥立马觉醒果实能力：'十六发神圣凶弹.神诛杀!'路飞勃然变色，" +
                "直接开大，‘大猿王枪’，多弗朗明哥败！")
                .addURLStyleByKey("http://www.baidu.com", "猿王枪")
                .build();
        Drawable d = getResources().getDrawable(R.mipmap.ic_launcher);
        d.setBounds(0, 0,50, 50);
        tv4.addContent("\n\n4、路飞上上去就是一拳，一招猿王枪，多弗朗明哥差点招架不住，多弗朗明哥立马觉醒果实能力：'十六发神圣凶弹.神诛杀!'路飞勃然变色，" +
                "直接开大，‘大猿王枪’，多弗朗明哥败！")
                .addImageStyleByKey(d, ImageSpan.ALIGN_BOTTOM, "多弗朗明哥")
                .build();
    }
}
