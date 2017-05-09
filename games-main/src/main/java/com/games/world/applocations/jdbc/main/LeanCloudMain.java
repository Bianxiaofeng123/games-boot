package com.games.world.applocations.jdbc.main;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;

public class LeanCloudMain {
	public static void main(String[] args) throws Exception{
		try {
			 // 启用北美节点
//	        AVOSCloud.useAVCloudUS();
	        // 初始化参数依次为 AppId, AppKey, MasterKey
	        AVOSCloud.initialize("K1sab8ifelDlRyeb7I48nJh0-gzGzoHsz","hvG2Vz4OcAVa0RC14g3s3Pg8","YyMpSfc2WhHmokuv721pSxQq");
	        
	        AVObject testObject = new AVObject("TestObject");
	        testObject.put("words","Hello World!");
	        testObject.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void open(final AVIMClientCallback callback) ;
	
//	public void name() {
//		AVIMClient imClient = AVIMClient.getInstance("Tom");
//		imClient.open(new IMClientCallback(){
//		  @Override
//		  public void done(AVIMClient client, AVException e) {
//		    if (null != e) {
//		      // 出错了，可能是网络问题无法连接 LeanCloud 云端，请检查网络之后重试。
//		      // 此时聊天服务不可用。
//		      e.printStackTrace();
//		    } else {
//		      // 成功登录，可以开始进行聊天了（假设为 MainActivity）。
//		      Intent intent = new Intent(currentActivity, MainActivity.class);
//		      currentActivity.startActivity(intent);
//		    };
//		  }
//		}); 
//	}
	
	
}
