package ngopi.sore.kang;
import android.widget.*;
import android.content.*;
import android.util.*;
import android.view.*;

public class ContextualLinearz extends LinearLayout
{
	LinearLayout aLin;
	
	public ContextualLinearz(Context c, AttributeSet a){
		super(c, a);
		
		aLin = (LinearLayout)findViewById(R.id.target_content);
		if(!Boolean.valueOf(c.getSharedPreferences("Anu",0).getBoolean("Sore",false)).booleanValue()){
			aLin.setVisibility(View.GONE);
		}else{
			aLin.setVisibility(View.VISIBLE);
		}
			
		BroadcastReceiver br = new BroadcastReceiver(){

			@Override
			public void onReceive(Context p1, Intent p2)
			{
				ContextualLinearz.this.aLin.setVisibility(View.VISIBLE);
			}
			
				
			};
			
		BroadcastReceiver br2 = new BroadcastReceiver(){

			@Override
			public void onReceive(Context p1, Intent p2)
			{
				ContextualLinearz.this.aLin.setVisibility(View.GONE);
			}


		};
		
		c.registerReceiver(br, new IntentFilter("linear_on"));
		c.registerReceiver(br2, new IntentFilter("linear_off"));
	}
}
