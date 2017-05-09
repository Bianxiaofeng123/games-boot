//package com.games.world.applocations.jdbc.main;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//import com.avos.avoscloud.AVException;
//import com.avos.avoscloud.AVOSCloud;
//import com.avos.avoscloud.AVObject;
//import com.avos.avoscloud.AVQuery;
//import com.avos.avoscloud.FindCallback;
//
//public class MainActivity extends Activity {
//
//	private ListView mListView;
//	private ArrayList<String> dataList = new ArrayList<String>();
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//
//		AVAnalytics.trackAppOpened(getIntent());
//		setContentView(R.layout.activity_main);
//		mListView = (ListView) findViewById(R.id.post_list);
//		getData();
//	}
//
//	private void getData() {
//
//		List<String> data = new ArrayList<String>();
//
//		AVQuery<AVObject> query = new AVQuery<AVObject>("Post");
//		query.whereLessThanOrEqualTo("postId", 10);
//		query.findInBackground(new FindCallback<AVObject>() {
//
//			@Override
//			public void done(List<AVObject> arg0, AVException arg1) {
//				Log.d("查到了", arg0.size() + "");
//				int resultSize = arg0.size();
//				for (int i = 0; i < resultSize; i++) {
//					MainActivity.this.dataList.add(arg0.get(i).getString(
//							"postTitle"));
//				}
//
//				ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(
//						MainActivity.this, android.R.layout.simple_list_item_1,
//						dataList);
//				mListView.setAdapter(myArrayAdapter);
//
//			}
//
//		});
//
//	}
//
//}
