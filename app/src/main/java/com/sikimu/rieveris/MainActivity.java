package com.sikimu.rieveris;

import android.app.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import com.sikimu.rieveris.game.*;

public class MainActivity extends Activity
{
	private Stage stage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		stage = new Stage();
		stage.init();
		stage.setGame(new Title());
		
		handler.post(runnable);
    }
	
	final Handler handler = new Handler();
	private final Runnable runnable = new Runnable() {
		@Override
		public void run()
		{
			long timeS = System.currentTimeMillis();
			stage.update();
			stage.draw(MainActivity.this);
			long time = System.currentTimeMillis() - timeS;
			if(time < 100)
			{
				handler.postDelayed(this, 100 - time);
			}
		}
	};

	@Override
	public boolean onTouchEvent(MotionEvent ev)
	{
		stage.event(ev);
		return true;
	}
}
