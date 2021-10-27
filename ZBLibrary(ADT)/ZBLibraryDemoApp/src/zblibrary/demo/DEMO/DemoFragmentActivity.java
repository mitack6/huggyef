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

import zblibrary.demo.R;
import zblibrary.demo.DEMO.DemoBroadcastReceiver.OnHeadsetConnectionChangedListener;
import zuo.biao.library.base.BaseFragmentActivity;
import zuo.biao.library.interfaces.OnFinishListener;
import zuo.biao.library.util.StringUtil;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**使用方法：复制>粘贴>改名>改代码  */
/**fragmentActivity示例
 * @author Lemon
 * @warn 复制到其它工程内使用时务必修改import R文件路径为所在应用包名
 * @use toActivity(DemoFragmentActivity.createIntent(...));
 */
public class DemoFragmentActivity extends BaseFragmentActivity implements OnClickListener, OnFinishListener, OnHeadsetConnectionChangedListener {
	//	private static final String TAG = "DemoFragmentActivity";

	//启动方法<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	//示例代码<<<<<<<<
	public static final String INTENT_USER_ID = "INTENT_USER_ID";
	//示例代码>>>>>>>>

	/**启动这个Activity的Intent
	 * @param context
	 * @param title
	 * @return
	 */
	public static Intent createIntent(Context context, String title) {
		return new Intent(context, DemoFragmentActivity.class).putExtra(INTENT_TITLE, title);
	}

	//启动方法>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO demo_fragment_activity改为你所需要的layout文件；传this是为了全局滑动返回
		setContentView(R.layout.demo_fragment_activity, this);
		//类相关初始化，必须使用<<<<<<<<<<<<<<<<
		context = this;
		isAlive = true;
		fragmentManager = getSupportFragmentManager();
		//类相关初始化，必须使用>>>>>>>>>>>>>>>>

		//功能归类分区方法，必须调用<<<<<<<<<<
		initView();
		initData();
		initListener();
		//功能归类分区方法，必须调用>>>>>>>>>>

	}


	//UI显示区(操作UI，但不存在数据获取或处理代码，也不存在事件监听代码)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	//示例代码<<<<<<<<
	private TextView tvDemoFragmentActivityTitle;
	private DemoFragment demoFragment;
	//示例代码>>>>>>>>
	@Override
	public void initView() {//必须在onCreate方法内调用
		//示例代码<<<<<<<<
		tvDemoFragmentActivityTitle = (TextView) findViewById(R.id.tvDemoFragmentActivityTitle);
		//示例代码>>>>>>>>
	}



	//UI显示区(操作UI，但不存在数据获取或处理代码，也不存在事件监听代码)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>










	//data数据区(存在数据获取或处理代码，但不存在事件监听代码)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


	@Override
	public void initData() {//必须在onCreate方法内调用

		//示例代码<<<<<<<<
		intent = getIntent();
		if (StringUtil.isNotEmpty(intent.getStringExtra(INTENT_TITLE), true)) {
			tvDemoFragmentActivityTitle.setText("" + StringUtil.getCurrentString());
		}

		showShortToast("userId = " + intent.getLongExtra(INTENT_USER_ID, 0));

		bundle = new Bundle();
		bundle.putLong(DemoFragment.ARGUMENT_USER_ID, intent.getLongExtra(INTENT_USER_ID, 0));
		demoFragment = new DemoFragment();
		demoFragment.setArguments(bundle);

		fragmentManager
		.beginTransaction()
		.add(R.id.flDemoFragmentActivityContainer, demoFragment)
		.show(demoFragment)
		.commit();
		//示例代码>>>>>>>>
	}

	//data数据区(存在数据获取或处理代码，但不存在事件监听代码)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>








	//listener事件监听区(只要存在事件监听代码就是)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	//示例代码<<<<<<<<<<<<<<<<<<<
	private DemoBroadcastReceiver demoBroadcastReceiver;//BroadcastReceiver使用示例
	//示例代码>>>>>>>>>>>>>>>>>>>
	@Override
	public void initListener() {//必须在onCreate方法内调用
		//示例代码<<<<<<<<<<<<<<<<<<<
		findViewById(R.id.tvDemoFragmentActivityReturn).setOnClickListener(this);
		
		demoBroadcastReceiver = new DemoBroadcastReceiver(context).register(this);
		//示例代码>>>>>>>>>>>>>>>>>>>
	}

	//示例代码<<<<<<<<<<<<<<<<<<<
	@Override
	public void onHeadsetConnectionChanged(boolean isConnected) {
		showShortToast(isConnected ? "已插入耳机" : "请插入耳机");
	}
	//示例代码>>>>>>>>>>>>>>>>>>>

	
	//系统自带监听方法<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


	//示例代码<<<<<<<<<<<<<<<<<<<
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tvDemoFragmentActivityReturn:
			finish();
			break;
		default:
			break;
		}
	}
	//示例代码>>>>>>>>>>>>>>>>>>>


	//类相关监听<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	//示例代码<<<<<<<<<<<<<<<<<<<
	@Override
	protected void onDestroy() {
		super.onDestroy();
		demoBroadcastReceiver.unregister();
	}
	//示例代码>>>>>>>>>>>>>>>>>>>

	//类相关监听>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	//系统自带监听方法>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	//listener事件监听区(只要存在事件监听代码就是)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>








	//内部类,尽量少用<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	//内部类,尽量少用>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}