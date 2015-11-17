package com.sunny.dynamics_tgs;

import java.util.ArrayList;
import java.util.List;

import com.sunny.element.MyGroup;
import com.sunny.element.MyTag;

import android.animation.LayoutTransition;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class utils {

	public static void SetView(LinearLayout container, Context context, int rows) {

		for (int i = 0; i < rows; i++) {

			LinearLayout linctr = new LinearLayout(context);
			LayoutTransition layoutTransition = new LayoutTransition();

			linctr.setLayoutTransition(layoutTransition);
			linctr.setGravity(Gravity.CENTER);
			linctr.setOrientation(LinearLayout.HORIZONTAL);

			LayoutParams par = new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT);
			linctr.setLayoutParams(par);
			container.addView(linctr);

		}
	}

	public static void SetView2(LinearLayout container, Context context,
			int rows) {

		for (int i = 0; i < rows; i++) {

			RelativeLayout linctr = new RelativeLayout(context);
			LayoutTransition layoutTransition = new LayoutTransition();

			linctr.setLayoutTransition(layoutTransition);
			// linctr.setGravity(Gravity.CENTER);

			RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			linctr.setLayoutParams(par);
			container.addView(linctr);

		}
	}

	public static List<String[]> GetData(int rows) {
		List<String[]> strs = new ArrayList<String[]>();
		for (int i = 0; i < rows; i++) {
			String[] str = null;
			if (i == 0)
				str = new String[] { "电影", "音乐" };
			else if (i == 1)
				str = new String[] { "TV", "明星", "海报" };
			else if (i == 2)
				str = new String[] { "书评", "书单 " };
			else if (i == 3)
				str = new String[] { "自助游", "骑行", "DIY" };
			else if (i == 4)
				str = new String[] { "恋爱", "吐槽" };
			else if (i == 5)
				str = new String[] { "护肤", "互联网", "个人管理" };
			else if (i == 6)
				str = new String[] { "明星", "食堂" };
			strs.add(str);
		}
		return strs;
	}

	public static List<MyGroup> InitData(MyGroup mygroup) {
		// int first=2,second=3;;
		List<MyGroup> groups = new ArrayList<MyGroup>();
		int count = mygroup.tags.size() / 5;
		int yu = mygroup.tags.size() % 5;
		for (int i = 1; i <= count; i++) {
			MyGroup group = new MyGroup();
			group.tags = new ArrayList<MyTag>();
			group.tags.add(mygroup.tags.get(5 * i - 5));
			group.tags.add(mygroup.tags.get(5 * i - 4));
			groups.add(group);

			group = new MyGroup();
			group.tags = new ArrayList<MyTag>();
			group.tags.add(mygroup.tags.get(5 * i - 3));
			group.tags.add(mygroup.tags.get(5 * i - 2));
			group.tags.add(mygroup.tags.get(5 * i - 1));
			groups.add(group);
		}
		for (int i = 0; i < yu; i++) {
			MyGroup group = new MyGroup();
			group.tags = new ArrayList<MyTag>();
			group.tags.add(mygroup.tags.get(5 * count + i));
			groups.add(group);
		}
		return groups;
	}

	static MyGroup loadSource() {
		MyGroup group = new MyGroup();
		group.tags = new ArrayList<MyTag>();

		MyTag tag = new MyTag();
		tag.title = "电影";
		tag.hasChild = true;
		tag.childs = new ArrayList<MyTag>();
		MyTag child_tag = new MyTag();
		child_tag.title = "欧美";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(child_tag);
		child_tag = new MyTag();
		child_tag.title = "日本";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(child_tag);
		child_tag = new MyTag();
		child_tag.title = "大陆";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(child_tag);
		group.tags.add(tag);

		tag = new MyTag();
		tag.title = "音乐";
		tag.hasChild = true;
		tag.childs = new ArrayList<MyTag>();
		child_tag = new MyTag();
		child_tag.title = "爵士乐";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(child_tag);
		child_tag = new MyTag();
		child_tag.title = "流行";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(child_tag);
		group.tags.add(tag);

		tag = new MyTag();
		tag.title = "TV";
		tag.hasChild = true;
		tag.childs = new ArrayList<MyTag>();
		child_tag = new MyTag();
		child_tag.title = "芒果台";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(tag);
		group.tags.add(tag);

		tag = new MyTag();
		tag.title = "海报";
		tag.hasChild = true;
		tag.childs = new ArrayList<MyTag>();
		child_tag = new MyTag();
		child_tag.title = "大海报";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(child_tag);
		group.tags.add(tag);

		tag = new MyTag();
		tag.title = "书评";
		tag.hasChild = false;
		group.tags.add(tag);

		tag = new MyTag();
		tag.title = "书单";
		tag.hasChild = true;
		tag.childs = new ArrayList<MyTag>();
		child_tag = new MyTag();
		child_tag.title = "历史";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(child_tag);
		child_tag = new MyTag();
		child_tag.title = "文化";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(child_tag);
		child_tag = new MyTag();
		child_tag.title = "小说";
		child_tag.hasChild = false;
		child_tag.childs = null;
		tag.childs.add(child_tag);
		group.tags.add(tag);
		return group;
	}

}
