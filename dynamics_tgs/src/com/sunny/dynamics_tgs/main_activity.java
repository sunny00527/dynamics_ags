package com.sunny.dynamics_tgs;

import java.util.ArrayList;
import java.util.List;

import com.sunny.dynamics_ags.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class main_activity extends Activity {
	StringBuilder myInterests = new StringBuilder();
	LinearLayout lincontainer;
	int rows=3;
	
	List<LinearLayout> lins=new ArrayList<LinearLayout>();
	List<LinearLayout.LayoutParams> pars=new ArrayList<LinearLayout.LayoutParams>();
	List<String[]> strs=new ArrayList<String[]>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		 lincontainer=(LinearLayout)findViewById(R.id.lincontent);
		utils.SetView(lincontainer, this, rows);
		;
		
		
		
		for (int i = 0; i < rows; i++) {
			LinearLayout lin=(LinearLayout)lincontainer.getChildAt(i);
			lins.add(lin);
			LinearLayout.LayoutParams par= (LinearLayout.LayoutParams)lin.getLayoutParams();
			par.setMargins(10, 10, 10, 10);
			pars.add(par);
		}
		initData();
	}

	void initData() {
		
	List<String[]> strs=	utils.GetData(rows);
	
	for (int i = 0; i < strs.size(); i++) {
		LinearLayout lin=(LinearLayout)lincontainer.getChildAt(i);
		String[] str=strs.get(i);
		for (int j = 0; j < str.length; j++) {
			View view = initTextView(j,i, str[j], pars.get(i), clicker1);
			if (myInterests.indexOf(str[j]) < 0)
				myInterests.append(str[j]);
			
			lin.addView(view);
		}
	}
	}

	int categoryCount = 1;// �ӷ����
	OnClickListener clicker1 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			v.setBackgroundResource(R.drawable.icon_index_user_dna_s);
			String[] strs=v.getTag().toString().split("_");
			int rowIndex = Integer.valueOf(strs[0]);
			int colIndex=Integer.valueOf(strs[1]);
			// Log.i("", ">>>>>>>>>���������"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View view = initTextView(rowIndex,colIndex, "子类", pars.get(colIndex), clicker1);
				for (int i = rowIndex; i < lins.get(colIndex).getChildCount(); i++) {

					View temp_view = lins.get(colIndex).getChildAt(i);
					temp_view.setTag(i + 1);
				}

				lins.get(colIndex).addView(view, rowIndex);
			}

		}
	};
	/*OnClickListener clicker2 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int currentIndex = Integer.valueOf(v.getTag().toString());
			v.setBackgroundResource(R.drawable.icon_index_user_dna_s);
			// Log.i("", ">>>>>>>>>���������"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "子类", par2, clicker2);
				for (int i = currentIndex; i < lin2.getChildCount(); i++) {

					View temp_view = lin2.getChildAt(i);
					temp_view.setTag(i + 1);
				}

				lin2.addView(tv, currentIndex);

				tv = initTextView(currentIndex, "子类", par1, clicker1);
				for (int i = currentIndex; i < lin1.getChildCount(); i++) {
					tv.setLayoutParams(par1);
					View view = lin1.getChildAt(i);
					view.setTag(i + 1);
				}
				lin1.addView(tv, currentIndex);
			}

		}
	};
	OnClickListener clicker3 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int currentIndex = Integer.valueOf(v.getTag().toString());
			v.setBackgroundResource(R.drawable.icon_index_user_dna_s);
			// Log.i("", ">>>>>>>>>���������"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "子类", par3, clicker3);
				for (int i = currentIndex; i < lin3.getChildCount(); i++) {

					View view = lin3.getChildAt(i);
					view.setTag(i + 1);
				}

				lin3.addView(tv, currentIndex);
			}

		}
	};
	OnClickListener clicker4 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int currentIndex = Integer.valueOf(v.getTag().toString());
			v.setBackgroundResource(R.drawable.icon_index_user_dna_s);
			// Log.i("", ">>>>>>>>>���������"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "子类", par4, clicker4);
				for (int i = currentIndex; i < lin4.getChildCount(); i++) {

					View view = lin4.getChildAt(i);
					view.setTag(i + 1);
				}

				lin4.addView(tv, currentIndex);
			}

		}
	};

	OnClickListener clicker5 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int currentIndex = Integer.valueOf(v.getTag().toString());
			v.setBackgroundResource(R.drawable.icon_index_user_dna_s);
			// Log.i("", ">>>>>>>>>���������"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "子类", par5, clicker5);
				for (int i = currentIndex; i < lin5.getChildCount(); i++) {

					View view = lin5.getChildAt(i);
					view.setTag(i + 1);
				}

				lin5.addView(tv, currentIndex);
			}

		}
	};
	OnClickListener clicker6 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int currentIndex = Integer.valueOf(v.getTag().toString());
			v.setBackgroundResource(R.drawable.icon_index_user_dna_s);
			// Log.i("", ">>>>>>>>>���������"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "子类", par6, clicker6);
				for (int i = currentIndex; i < lin6.getChildCount(); i++) {

					View view = lin6.getChildAt(i);
					view.setTag(i + 1);
				}

				lin6.addView(tv, currentIndex);
			}

		}
	};
	OnClickListener clicker7 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int currentIndex = Integer.valueOf(v.getTag().toString());
			v.setBackgroundResource(R.drawable.icon_index_user_dna_s);
			// Log.i("", ">>>>>>>>>���������"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "子类", par7, clicker7);
				for (int i = currentIndex; i < lin7.getChildCount(); i++) {

					View view = lin7.getChildAt(i);
					view.setTag(i + 1);
				}

				lin7.addView(tv, currentIndex);
			}

		}
	};*/
 
	View initTextView(int row_index,int col_index ,String value, LayoutParams par,
			OnClickListener clicker) {
		TextView tv = new TextView(main_activity.this);
		tv.setBackgroundResource(R.drawable.icon_index_user_dna_s);
		tv.setGravity(Gravity.CENTER);
		tv.setPadding(20, 5, 20, 5);
		tv.setTextSize(16);
		tv.setLayoutParams(par);
		/*if (par == par1)
			tv.setTextColor(Color.GREEN);
		else if (par == par2)
			tv.setTextColor(Color.RED);
		else if (par == par3)
			tv.setTextColor(Color.BLUE);
		else if (par == par4)
			tv.setTextColor(Color.YELLOW);
		else if (par == par5)
			tv.setTextColor(Color.BLACK);
		else if (par == par6)
			tv.setTextColor(Color.LTGRAY);
		else if (par == par7)
			tv.setTextColor(Color.CYAN);*/
		
		tv.setTextColor(Color.LTGRAY);
		tv.setText(value);
		tv.setTag(String.valueOf(row_index)+"_"+String.valueOf(col_index));
		tv.setOnClickListener(clicker);
		return tv;
	}
}
