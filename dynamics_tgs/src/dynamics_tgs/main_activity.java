package dynamics_tgs;

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
	LinearLayout lin1, lin2, lin3, lin4, lin5, lin6, lin7;
	String[] strs1 = { "安全", "大数据" };
	String[] strs2 = { "机器人", "政策", "工业4.0" };
	String[] strs3 = { "圈子", "匡恩", "网络", "交换机" };
	String[] strs4 = { "病毒", "水电站" };
	String[] strs5 = { "路由", "安全卫士", "专家" };
	String[] strs6 = { "低压变频", "仪表", "现场总线", "自动化" };
	String[] strs7 = { "PAC", "展会" };
	LinearLayout.LayoutParams par1, par2, par3, par4, par5, par6, par7;
	StringBuilder myInterests = new StringBuilder();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		lin1 = (LinearLayout) findViewById(R.id.lin1);
		lin2 = (LinearLayout) findViewById(R.id.lin2);
		lin3 = (LinearLayout) findViewById(R.id.lin3);
		lin4 = (LinearLayout) findViewById(R.id.lin4);
		lin5 = (LinearLayout) findViewById(R.id.lin5);
		lin6 = (LinearLayout) findViewById(R.id.lin6);
		lin7 = (LinearLayout) findViewById(R.id.lin7);
		par1 = (LinearLayout.LayoutParams) lin1.getLayoutParams();
		par2 = (LinearLayout.LayoutParams) lin2.getLayoutParams();
		par3 = (LinearLayout.LayoutParams) lin3.getLayoutParams();
		par4 = (LinearLayout.LayoutParams) lin4.getLayoutParams();
		par5 = (LinearLayout.LayoutParams) lin5.getLayoutParams();
		par6 = (LinearLayout.LayoutParams) lin6.getLayoutParams();
		par7 = (LinearLayout.LayoutParams) lin7.getLayoutParams();

		par1.setMargins(10, 10, 10, 10);
		par2.setMargins(10, 10, 10, 10);
		par3.setMargins(10, 10, 10, 10);
		par4.setMargins(10, 10, 10, 10);
		par5.setMargins(10, 10, 10, 10);
		par6.setMargins(10, 10, 10, 10);
		par7.setMargins(10, 10, 10, 10);
		initData();
	}

	void initData() {
		for (int i = 0; i < strs1.length; i++) {

			View view = initTextView(i, strs1[i], par1, clicker1);
			if (myInterests.indexOf(strs1[i]) < 0)
				myInterests.append(strs1[i]);
			lin1.addView(view);
		}
		for (int i = 0; i < strs2.length; i++) {
			View view = initTextView(i, strs2[i], par2, clicker2);
			if (myInterests.indexOf(strs2[i]) < 0)
				myInterests.append(strs2[i]);
			lin2.addView(view);
		}
		for (int i = 0; i < strs3.length; i++) {
			View view = initTextView(i, strs3[i], par3, clicker3);
			if (myInterests.indexOf(strs3[i]) < 0)
				myInterests.append(strs3[i]);
			lin3.addView(view);
		}
		for (int i = 0; i < strs4.length; i++) {
			View view = initTextView(i, strs4[i], par4, clicker4);
			if (myInterests.indexOf(strs4[i]) < 0)
				myInterests.append(strs4[i]);
			lin4.addView(view);
		}
		for (int i = 0; i < strs5.length; i++) {
			View view = initTextView(i, strs5[i], par5, clicker5);
			if (myInterests.indexOf(strs5[i]) < 0)
				myInterests.append(strs5[i]);
			lin5.addView(view);
		}
		for (int i = 0; i < strs6.length; i++) {
			View view = initTextView(i, strs6[i], par6, clicker6);
			if (myInterests.indexOf(strs6[i]) < 0)
				myInterests.append(strs6[i]);
			lin6.addView(view);
		}
		for (int i = 0; i < strs7.length; i++) {
			View view = initTextView(i, strs7[i], par7, clicker7);
			if (myInterests.indexOf(strs7[i]) < 0)
				myInterests.append(strs7[i]);
			lin7.addView(view);
		}
	}

	int categoryCount = 1;// 子分類個數
	OnClickListener clicker1 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			v.setBackgroundResource(R.drawable.icon_index_user_dna_s);
			int currentIndex = Integer.valueOf(v.getTag().toString());
			// Log.i("", ">>>>>>>>>点击的索引"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View view = initTextView(currentIndex, "类", par1, clicker1);
				for (int i = currentIndex; i < lin1.getChildCount(); i++) {

					View temp_view = lin1.getChildAt(i);
					temp_view.setTag(i + 1);
				}

				lin1.addView(view, currentIndex);
			}

		}
	};
	OnClickListener clicker2 = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int currentIndex = Integer.valueOf(v.getTag().toString());
			v.setBackgroundResource(R.drawable.icon_index_user_dna_s);
			// Log.i("", ">>>>>>>>>点击的索引"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "类", par2, clicker2);
				for (int i = currentIndex; i < lin2.getChildCount(); i++) {

					View temp_view = lin2.getChildAt(i);
					temp_view.setTag(i + 1);
				}

				lin2.addView(tv, currentIndex);

				tv = initTextView(currentIndex, "类", par1, clicker1);
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
			// Log.i("", ">>>>>>>>>点击的索引"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "类", par3, clicker3);
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
			// Log.i("", ">>>>>>>>>点击的索引"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "类", par4, clicker4);
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
			// Log.i("", ">>>>>>>>>点击的索引"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "类", par5, clicker5);
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
			// Log.i("", ">>>>>>>>>点击的索引"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "类", par6, clicker6);
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
			// Log.i("", ">>>>>>>>>点击的索引"+String.valueOf(currentIndex));
			if (categoryCount == 1) {
				View tv = initTextView(currentIndex, "类", par7, clicker7);
				for (int i = currentIndex; i < lin7.getChildCount(); i++) {

					View view = lin7.getChildAt(i);
					view.setTag(i + 1);
				}

				lin7.addView(tv, currentIndex);
			}

		}
	};
 
	View initTextView(int index, String value, LayoutParams par,
			OnClickListener clicker) {
		TextView tv = new TextView(main_activity.this);
		tv.setBackgroundResource(R.drawable.icon_index_user_dna_s);
		tv.setGravity(Gravity.CENTER);
		tv.setPadding(20, 5, 20, 5);
		tv.setTextSize(16);
		tv.setLayoutParams(par);
		if (par == par1)
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
			tv.setTextColor(Color.CYAN);
		tv.setText(value);
		tv.setTag(index);
		tv.setOnClickListener(clicker);
		return tv;
	}
}
