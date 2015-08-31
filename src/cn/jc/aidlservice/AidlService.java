package cn.jc.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class AidlService extends Service {

	public AidlService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate() {
		super.onCreate();
		catBinder = new CatBinder();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return catBinder;
	}
	

	private CatBinder catBinder;

	//
	public class CatBinder extends ICat.Stub {
		@Override
		public String getColor() throws RemoteException {
			return "get from remote service";
		}

		@Override
		public double getWeight() throws RemoteException {
			return 999.9;
		}
	}

	@Override
	public void onDestroy() {
		System.out.println("remote service destroy");
	}

}
