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

package zuo.biao.library.DEMO;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import zuo.biao.library.base.BaseTabFragment;
import zuo.biao.library.ui.WebViewActivity;

/**使用方法：复制>粘贴>改名>改代码  */
/**带标签的Fragment示例
 * @warn 复制到其它工程内使用时务必修改import R文件路径为所在应用包名
 * @author Lemon
 * @use new DemoTabFragment(),具体参考.DemoFragmentActivity(initData方法内)
 */
public class DemoTabFragment extends BaseTabFragment implements OnClickListener {
//	private static final String TAG = "DemoTabFragment";

	//与Activity通信<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public static final String ARGUMENT_RANGE = "ARGUMENT_RANGE";
	public static final String ARGUMENT_USER_ID = "ARGUMENT_USER_ID";

	/**
	 * 列表上方提示语
	 */
	public static final String ARGUMENT_REMIND = "ARGUMENT_REMIND";


	//与Activity通信>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		//		needReload = true;

		//功能归类分区方法，必须调用<<<<<<<<<<
		initView();
		initData();
		initListener();
		//功能归类分区方法，必须调用>>>>>>>>>>

		return view;
	}



	//UI显示区(操作UI，但不存在数据获取或处理代码，也不存在事件监听代码)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	//示例代码<<<<<<<<
	private TextView topRightButton;
	//示例代码>>>>>>>>
	@Override
	public void initView() {//必须在onCreate方法内调用
		//示例代码<<<<<<<<
		topRightButton = addTopRightButton(newTopRightButton(context, "了解"));
		//示例代码>>>>>>>>

		super.initView();
	}



	//UI显示区(操作UI，但不存在数据获取或处理代码，也不存在事件监听代码)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>










	//data数据区(存在数据获取或处理代码，但不存在事件监听代码)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	@Override
	public void initData() {//必须在onCreate方法内调用

		super.initData();
	}

	@Override
	protected String getTitleName() {
		return "标题";
	}

	@Override
	@Nullable
	protected String getTopReturnButtonName() {
		return "";
	}

	@Override
	protected String[] getTabNames() {
		return new String[] {"你", "我", "他"};
	}

	@Override
	protected Fragment getFragment(int position) {
		DemoFragment fragment = new DemoFragment();
		bundle = new Bundle();
		bundle.putLong(DemoFragment.ARGUMENT_USER_ID, position);
		fragment.setArguments(bundle);
		
		return fragment;
	}



	//data数据区(存在数据获取或处理代码，但不存在事件监听代码)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>








	//listener事件监听区(只要存在事件监听代码就是)<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	public static final int RESULT_MODEL = 30;
	@Override
	public void initListener() {//必须在onCreate方法内调用
		//示例代码<<<<<<<<
		topRightButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				toActivity(WebViewActivity.createIntent(context, "baidu", "www.baidu.com"));				
			}
		});
		//示例代码>>>>>>>>

		super.initListener();
	}


	//系统自带监听方法<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


	//类相关监听>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	//系统自带监听方法>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	//listener事件监听区(只要存在事件监听代码就是)>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>








	//内部类,尽量少用<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



	//内部类,尽量少用>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}