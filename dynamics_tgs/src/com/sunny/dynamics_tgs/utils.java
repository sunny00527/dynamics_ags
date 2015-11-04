package com.sunny.dynamics_tgs;

import java.util.ArrayList;
import java.util.List;

import android.animation.LayoutTransition;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.Gravity;
import android.widget.LinearLayout;

public class utils {

	public static void  SetView(LinearLayout container,Context context,int rows)
	{
		
		for (int i = 0; i < rows; i++) {
			
			
			LinearLayout linctr=new LinearLayout(context);
			LayoutTransition layoutTransition = new LayoutTransition();
			
			linctr.setLayoutTransition(layoutTransition);
			linctr.setGravity(Gravity.CENTER);
			linctr.setOrientation(LinearLayout.HORIZONTAL);
			
			LayoutParams par=new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			linctr.setLayoutParams(par);
			container.addView(linctr);
			
		}
	}
	
	public static List<String[]> GetData(int rows)
	{
		List<String[]> strs=new ArrayList<String[]>();
		for (int i = 0; i < rows; i++) {
			String[] str = null;
			if(i==0)
			str =new String[] {"电影","音乐"};
			else if(i==1)
			str = new String[]{ "TV", "明星", "海报" };
			else if(i==2)
				str = new String[]{"书评", "书单 ", "DIY", "烹饪"};
			else if(i==3)
					str = new String[] { "自助游", "骑行" };
			else if(i==4)
				str = new String[]{ "恋爱", "吐槽", "穿搭" };
			else if(i==5)
				str = new String[]{ "护肤", "互联网", "个人管理", "职场" };
			else if(i==6)
				str = new String[] { "明星", "食堂" };
			strs.add(str);
		}
		return strs;
	}
}
