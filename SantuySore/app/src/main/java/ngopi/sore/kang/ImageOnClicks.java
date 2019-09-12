package ngopi.sore.kang;
import android.content.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class ImageOnClicks extends ImageView
{
	
	public ImageOnClicks(final Context context, AttributeSet attr){
		super(context, attr);
		ImageView aView = (ImageView)findViewById(R.id.onclicks);
		aView.setImageResource(R.drawable.ic_launcher);
		if(Boolean.valueOf(context.getSharedPreferences("Anu",0).getBoolean("Sore",false)).booleanValue()){
			aView.setSelected(false);
		}else{
			aView.setSelected(true);
		}
		aView.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					if(p1.isSelected()){
						p1.setSelected(false);
						Intent intent = new Intent();
						intent.setAction("linear_off");
						context.sendBroadcast(intent);
						SharedPreferences.Editor spe = context.getSharedPreferences("Anu",0).edit();
						spe.putBoolean("Sore",false);
						spe.commit();
						return;
					}
					
					p1.setSelected(true);
					Intent intents = new Intent();
					intents.setAction("linear_on");
					context.sendBroadcast(intents);
					SharedPreferences.Editor spet = context.getSharedPreferences("Anu",0).edit();
					spet.putBoolean("Sore",true);
					spet.commit();
					return;
				}
				
				
			});
	}
}
