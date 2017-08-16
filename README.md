# HighlightTextView
对SpannableStringBuilder进行封装，轻松实现部分文字高亮、点击、添加删除线，更换字体、图片替换等功能。

## 添加依赖
- 方法1：
~~~
  allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
  }
  
  dependencies {
      compile 'com.github.albert-lii:HighlightTextView:1.0.0'
  }
~~~
- 方法2：
~~~
  compile project(':highlighttextview')
~~~

## 使用方法
- 布局文件
~~~
<com.liyi.highlight.HighlightTextView
    android:id="@+id/highlighttextView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:textSize="15sp" />    
~~~
- 代码中设置
~~~
    highlighttextView.addContent("文字内容")
                // 设置文字颜色（12：文字颜色转变的开始位置，14：文字颜色转变的结束位置）
                // 同时提供方法：.addFontColorStyleByKey(@ColorInt int color, String key)
                .addFontColorStyle(Color.YELLOW, 12, 14)
                // 设置文字背景色
                // 同时提供方法：.addBgColorStyleByKey(@ColorInt int color, String key)
                .addBgColorStyle(Color.BLUE, 0, 10）
                // 直接搜索“文字内容”中的所有“关键字”，对所有“关键字”添加超链接
                // 同时提供方法：.addURLStyle(String url, int start, int end)
                .addURLStyleByKey("http://www.baidu.com", "关键字")
                // 直接搜索“文字内容”中的所有“关键字”，对所有“关键字”添加点击事件
                // 同时提供方法：.addClickStyle(final OnHighlightClickListener listener, final boolean isNeedUnderLine, 
                int start,int end)
                .addClickStyleByKey(new HighlightTextView.OnHighlightClickListener() {
                    @Override
                    public void onTextClick(int position, View v) {
                        Toast.makeText(MainActivity.this, "关键字", Toast.LENGTH_SHORT).show();
                    }
                 }, true, "关键字")// true：是否添加下划线
                 // 将文字替换为图片（ImageSpan.ALIGN_BOTTOM：图片与文字底部对齐）
                 // 同时提供方法：.addImageStyle(ImageSpan span, int start, int end)
                 // drawable也可以是span、bitmap、resouceId
                 .addImageStyleByKey(drawable, ImageSpan.ALIGN_BOTTOM, "关键字")
                 // 设置字体样式
                 // .addTypefaceStyle(int style, int start, int end) 
                 // .addTypefaceStyleByKey(int style, String key)
                 // 加删除线
                 // .addStrikethroughStyle(int start, int end)
                 // .addStrikethroughStyleByKey(String key)
                 // 执行
                 .build();
                 
                 
    // 此方法搜索字符串中所有的key，并返回每个key的开始位置与结束位置的数组列表（return List<int[]> ===> int[0]开始位置，int[1]结束位置）             
    highlighttextView.searchAllIndex(String key)      
~~~

## LICENSE
Copyright 2017 liyi

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

