package listviewutils;

import java.util.List;

import com.example.androidannotationstest.R;


import android.content.Context;
import android.widget.TextView;


public class MyAdapter extends CommomAdapter<String> {
	
	public MyAdapter(Context context, List<String> datas, int layoutResource) {
		super(context, datas, layoutResource);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setDatas(CommomViewHolder holder, String string) {
		((TextView)(holder.getView(R.id.item_tv))).setText(string);
	}

}
