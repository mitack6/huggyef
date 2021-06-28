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

package zuo.biao.library.MODEL;

import zuo.biao.library.R;
import zuo.biao.library.base.BaseActivity;
import zuo.biao.library.interfaces.OnPageReturnListener;
import zuo.biao.library.manager.TimeRefresher;
import zuo.biao.library.manager.TimeRefresher.OnTimeRefreshListener;
import zuo.biao.library.util.StringUtil;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

/**时间刷新器使用activity示例
 * @author Lemon
 * @warn 复制到其它工程内使用时务必修改import zuo.biao.library.R;的文件路径（这里是zuo.biao.library）为所在应用包名
 * @use toActivity(ModelUseTimeRefresherUseTimeRefresherActivity.createIntent(...));
 */
public class ModelUseTimeRefresherActivity extends BaseActivity 
implements OnClickListener, OnPageReturnListener, OnTimeRefreshListener {
	private static final String TAG = "ModelUseTimeRefresherActivity";

	//启动方法<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	/**启动这个Activity的Intent
	 * @param context
	 * @return
	 */
	public static Intent createIntent(Context context) {
		return new Intent(context, ModelUseTimeRefresherActivity.class);
	}

	//启动方法>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//model_use_time_refresher_activity改为你所需要的layout文件；传this是为了全局滑动返回
		setContentView(R.layout.model_use_time_refresher_activity, this);
		//类相关初始化，必须使用<<<<<<<<<<<<<<<<
		context = this;
		isActivityAlive = true;
		//类相关初始化，必须使用>>>>>>>>>>>>>>>>

		//功能归类分区方法，必须调用<<<<<<<<<<
		initView();
		initData();
		initListener();
		//功能归类分区方法，必须调用>>>>>>>>>>

	}


	//UI显示区(操作UI，但不存在数据获取或处理代码，也不存在事件监听代码)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	//示例代码<<<<<<<<
	private TextView tvModelUseTimeRefresherTitle;

	private TextView tvModelUseTimeRefresherCount;

	private EditText etModelUseTimeRefresher;
	//示例代码>>>>>>>>
	@Override
	public void initView() {//必须调用

		//示例代码<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		tvModelUseTimeRefresherTitle = (TextView) findViewById(R.id.tvModelUseTimeRefresherTitle);

		tvModelUseTimeRefresherCount = (TextView) findViewById(R.id.tvModelUseTimeRefresherCount);

		etModelUseTimeRefresher = (EditText) findViewById(R.id.etModelUseTimeRefresher);

		//示例代码>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	}

	private void clear() {
		TimeRefresher.getInstance().removeTimeRefreshListener(TAG);
		count = 0;
		tvModelUseTimeRefresherCount.setText("0");		
	}


	private boolean isToStop = false;
	private void stopOrContinu() {
		isToStop = !isToStop;
	}

	//UI显示区(操作UI，但不存在数据获取或处理代码，也不存在事件监听代码)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>










	//data数据区(存在数据获取或处理代码，但不存在事件监听代码)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	@Override
	public void initData() {//必须调用

		//示例代码<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

		if (StringUtil.isNotEmpty(getIntent().getStringExtra(INTENT_TITLE), false)) {
			tvModelUseTimeRefresherTitle.setText("" + StringUtil.getCurrentString());
		}

		//示例代码>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	}


	//data数据区(存在数据获取或处理代码，但不存在事件监听代码)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>








	//listener事件监听区(只要存在事件监听代码就是)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	@Override
	public void initListener() {//必须调用
		//示例代码<<<<<<<<<<<<<<<<<<<
		findViewById(R.id.tvModelUseTimeRefresherReturn).setOnClickListener(this);
		findViewById(R.id.ivModelUseTimeRefresherForward).setOnClickListener(this);

		tvModelUseTimeRefresherCount.setOnClickListener(this);
		findViewById(R.id.ibtnModelUseTimeRefresher).setOnClickListener(this);
		//示例代码>>>>>>>>>>>>>>>>>>>
	}

	@Override
	public void onTimerStart() {
		showShortToast("start");
	}
	private int count = 0;
	@Override
	public void onTimerRefresh() {
		if (isToStop == false) {
			count ++ ;
			tvModelUseTimeRefresherCount.setText("" + count);
		}
	}
	@Override
	public void onTimerStop() {
		showShortToast("stop");
	}

	//系统自带监听方法<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


	//示例代码<<<<<<<<<<<<<<<<<<<
	//	@Override
	//	public void onClick(View v) {
	//		switch (v.getId()) {
	//		case R.id.tvModelUseTimeRefresherReturn:
	//			onPageReturn();
	//			break;
	//		case R.id.ivModelUseTimeRefresherForward:
	//			clear();
	//			break;
	//		case R.id.tvModelUseTimeRefresherCount:
	//			stopOrContinu();
	//			break;
	//		case R.id.ibtnModelUseTimeRefresher:
	//			clear();
	//
	//			number = StringUtil.getNumber(etModelUseTimeRefresher);
	//			if (StringUtil.isNotEmpty(number, true)) {
	//				TimeRefresher.getInstance().addTimeRefreshListener(TAG
	//						, 0 + Integer.valueOf(number), this);
	//			}
	//			break;
	//		default:
	//			break;
	//		}
	//	}
	//Library内switch方法中case R.id.idx会报错
	private String number;
	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.tvModelUseTimeRefresherReturn) {
			onPageReturn();
		} else if (v.getId() == R.id.ivModelUseTimeRefresherForward) {
			clear();
		} else if (v.getId() == R.id.tvModelUseTimeRefresherCount) {
			stopOrContinu();
		} else if (v.getId() == R.id.ibtnModelUseTimeRefresher) {
			clear();
			isToStop = false;

			number = StringUtil.getNumber(etModelUseTimeRefresher);
			if (StringUtil.isNotEmpty(number, true)) {
				TimeRefresher.getInstance().addTimeRefreshListener(TAG
						, 0 + Integer.valueOf(number), this);
			}
		}
	}

	//示例代码>>>>>>>>>>>>>>>>>>>




	//类相关监听<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


	@Override
	protected void onDestroy() {
		TimeRefresher.getInstance().removeTimeRefreshListener(TAG);
		super.onDestroy();
	}


	//类相关监听>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	//系统自带监听方法>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	//listener事件监听区(只要存在事件监听代码就是)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>








	//内部类,尽量少用<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	//内部类,尽量少用>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}