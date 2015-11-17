package com.sunny.dynamics_tgs;

import java.util.ArrayList;
import java.util.List;

import com.sunny.dynamics_ags.R;
import com.sunny.element.MyGroup;
import com.sunny.element.MyTag;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class main_activity extends Activity {
	//StringBuilder myInterests = new StringBuilder();
	LinearLayout lincontainer;
	// 总行数
	int rows = 3;
	// 总的容器数，这是指LinearLayout
	List<LinearLayout> lins = new ArrayList<LinearLayout>();
	// 容器的LayoutParams
	List<LinearLayout.LayoutParams> pars = new ArrayList<LinearLayout.LayoutParams>();
	// 窗口内tag的内容集合
//	List<String[]> strs = new ArrayList<String[]>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		lincontainer = (LinearLayout) findViewById(R.id.lincontent);
		// 设置容器
		utils.SetView(lincontainer, this, rows);
		// 将容器内的容器取出
		for (int i = 0; i < rows; i++) {
			LinearLayout lin = (LinearLayout) lincontainer.getChildAt(i);
			lins.add(lin);
			LinearLayout.LayoutParams par = (LinearLayout.LayoutParams) lin
					.getLayoutParams();
			par.setMargins(10, 10, 10, 10);
			pars.add(par);
		}
		initData();
	}

	void initData() {

		//List<String[]> strs = utils.GetData(rows);
		
		List<MyGroup> groups=utils.InitData(utils.loadSource());
		
	/*	for (int row = 0; row < strs.size(); row++) {
			LinearLayout lin = (LinearLayout) lincontainer.getChildAt(row);
			String[] str = strs.get(row);
			for (int col = 0; col < str.length; col++) {
				View view = initTextView(col, row, str[col], pars.get(row), clicker1);
				if (myInterests.indexOf(str[col]) < 0)
					myInterests.append(str[col]);
				lin.addView(view);
			}
		}*/
		for (int row = 0; row < groups.size(); row++) {
			LinearLayout lin = (LinearLayout) lincontainer.getChildAt(row);
			MyGroup group = groups.get(row);
			for (int col = 0; col < group.tags.size(); col++) {
				View view = initTextView(col, row,group.tags.get(col), pars.get(row), clicker1);
				lin.addView(view);
			}
		}
	}

	//表示有多少个子类
	int categoryCount = 3;
	OnClickListener clicker1 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MyTag tag=(MyTag)v.getTag(R.id.tag);
			if(!tag.hasChild)
			{
				return;
			}
			categoryCount=tag.childs.size();
			String[] strs = v.getTag(R.id.col).toString().split("_");
			int colIndex = Integer.valueOf(strs[0]);
			int rowIndex = Integer.valueOf(strs[1]);

			LinearLayout linThird=null;
			int preCount=0;
			int nextCount=0;
			int myCount=lins.get(rowIndex).getChildCount();
			
			//判断上下哪个行比较短
			if(rowIndex>0&&rowIndex<lins.size()-1)
			{
				preCount=lins.get(rowIndex-1).getChildCount();
				nextCount=lins.get(rowIndex+1).getChildCount();
			}
			else if(rowIndex==0)
				nextCount=lins.get(rowIndex+1).getChildCount();
			else  if(rowIndex==lins.size()-1)
				preCount=lins.get(rowIndex-1).getChildCount();
			
			if(myCount>preCount||myCount>nextCount)
			{
				if(preCount>nextCount&&nextCount>0)
					linThird=lins.get(rowIndex+1);
				if(preCount>nextCount&&nextCount==0)
					linThird=lins.get(rowIndex-1);
				else if(nextCount>preCount&&preCount>0)
					linThird=lins.get(rowIndex-1);
				else if(nextCount>preCount&&preCount==0)
					linThird=null;
				else if(nextCount==preCount&&preCount>0)
					linThird=lins.get(rowIndex-1);
			}
			//判断有多少子分类,在分类大于2的时候地，和会考虑在上下的行中加入新元素
			if (categoryCount == 1) {
				addone(lins.get(rowIndex),tag.childs,colIndex, rowIndex);
			}
			else if (categoryCount == 2) {
				addtwo(lins.get(rowIndex),tag.childs,colIndex, rowIndex);
			}
			//此时考虑在上下最短的 行中加入第三个元素，以谋求平衡
			else if (categoryCount == 3) {
				addtwo(lins.get(rowIndex),tag.childs,colIndex, rowIndex);
				if(linThird!=null)
				{
					addone(linThird,tag.childs,colIndex,rowIndex);
				}
			}
		}
	};
	
	private void addtwo(LinearLayout lin,List<MyTag> tags,int colIndex, int rowIndex) {
		
			View view1 = initTextView(colIndex, rowIndex, tags.get(0),pars.get(rowIndex), clicker1);
			for (int i = colIndex; i < lin.getChildCount(); i++) {
				View temp_view = lin.getChildAt(i);
				if(i==colIndex)
					temp_view.setTag(String.valueOf(i + 1) + "_"+ String.valueOf(rowIndex));
				else
					temp_view.setTag(String.valueOf(i + 2) + "_"+ String.valueOf(rowIndex));
			}
			View view2 = initTextView(colIndex+1, rowIndex, tags.get(1),pars.get(rowIndex), clicker1);
			lin.addView(view1, colIndex);
			lin.addView(view2, colIndex+2);
		}
	
	private void addone(LinearLayout lin,List<MyTag> tags,int colIndex, int rowIndex) {
		
			View view1 = initTextView(colIndex, rowIndex, tags.get(0),pars.get(rowIndex), clicker1);
			for (int i = colIndex; i < lin.getChildCount(); i++) {
				View temp_view = lin.getChildAt(i);
				temp_view.setTag(String.valueOf(i + 1) + "_"+ String.valueOf(rowIndex));
			}
			lin.addView(view1, colIndex);
		}
	View initTextView(int col_index, int row_index, MyTag tag,
			LayoutParams par, OnClickListener clicker) {
		TextView tv = new TextView(main_activity.this);
		tv.setBackgroundResource(R.drawable.icon_index_user_dna_s);
		tv.setGravity(Gravity.CENTER);
		tv.setPadding(20, 5, 20, 5);
		tv.setTextSize(16);
		 tv.setLayoutParams(par);
		 
		 if(row_index==0)
			  tv.setTextColor(Color.parseColor("#907FE5")); 
		 else if (row_index == 1)
			 tv.setTextColor(Color.parseColor("#232323")); 
		else if (row_index == 2)
				 tv.setTextColor(Color.parseColor("#F49A7D"));
		tv.setText(tag.title);
		tv.setTag(R.id.tag, tag);
		tv.setTag(R.id.col, String.valueOf(col_index) + "_" + String.valueOf(row_index));
		//tv.setTag(String.valueOf(col_index) + "_" + String.valueOf(row_index));
		tv.setOnClickListener(clicker);
		tv.setBackgroundResource(R.drawable.icon_index_user_dna_s);
		return tv;
	}
}
