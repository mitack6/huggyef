/*Copyright ©2015 TommyLemon(https://github.com/TommyLemon)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package zblibrary.demo.DEMO;

import zuo.biao.library.R;
import zuo.biao.library.base.BaseView;
import zuo.biao.library.bean.Entry;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

/**使用方法：复制>粘贴>改名>改代码  */
/**通用自定义View模板，当View比较庞大复杂且使用次数>=2时建议使用
 * @author Lemon
 * @warn 复制到其它工程内使用时务必修改import R文件路径为所在应用包名
 * @use
	DemoView demoView = new DemoView(context, inflater);
	adapter中使用convertView = demoView.getView();//[具体参考.DemoAdapter(getView使用自定义View的写法)]
    或  其它类中使用  containerView.addView(demoView.getView());
	demoView.setView(data);
	demoView.setOnDataChangedListener(onDataChangedListener);data = demoView.getData();//非必需
	demoView.setOnClickListener(onClickListener);//非必需
	...
 */
public class DemoView extends BaseView<Entry<String, String>> implements OnClickListener {
	private static final String TAG = "DemoView";

	public DemoView(Activity context, LayoutInflater inflater) {
		super(context, inflater);
	}


	public ImageView ivModelViewHead;
	public TextView tvModelViewName;
	public TextView tvModelViewNumber;
	@SuppressLint("InflateParams")
	@Override
	public View getView() {
		//TODO demo_view改为你所需要的layout文件
		convertView = inflater.inflate(R.layout.demo_view, null);

		//示例代码<<<<<<<<<<<<<<<<
		ivModelViewHead = (ImageView) findViewById(R.id.ivModelViewHead);
		tvModelViewName = (TextView) findViewById(R.id.tvModelViewName);
		tvModelViewNumber = (TextView) findViewById(R.id.tvModelViewNumber);
		//示例代码>>>>>>>>>>>>>>>>

		return convertView;
	}



	private Entry<String, String> data;//传进来的数据
	@Override
	public Entry<String, String> getData() {
		return data;
	}

	@Override
	public void setView(Entry<String, String> data){
		if (data == null) {
			Log.e(TAG, "setView data == null >> data = new Entry<>(); ");
			data = new Entry<>();
		}
		this.data = data;

		tvModelViewName.setText("" + data.getKey());
		tvModelViewNumber.setText("" + data.getValue());

		//示例代码<<<<<<<<<<<<<<<<
		ivModelViewHead.setOnClickListener(this);
		tvModelViewName.setOnClickListener(this);
		//示例代码>>>>>>>>>>>>>>>>
	}

	/**刷新界面，refresh符合习惯
	 * @param data
	 */
	public void refresh(final Entry<String, String> data) {
		setView(data);
	}

	@Override
	public void onClick(View v) {
		if (onClickListener != null) {
			onClickListener.onClick(v);
			return;
		}
		//		switch (v.getId()) {
		//		case R.id.tvModelViewName:
		//			data.setKey("New " + data.getKey());
		//			refresh(data);
		//			if (onDataChangedListener != null) {
		//				onDataChangedListener.onDataChanged();
		//			}
		//			break;
		//		default:
		//			break;
		//		}
		//Library内switch方法中case R.id.idx会报错
		if (v.getId() == R.id.tvModelViewName) {
			data.setKey("New " + data.getKey());
			refresh(data);
			if (onDataChangedListener != null) {
				onDataChangedListener.onDataChanged();
			}
		}
	}


}
