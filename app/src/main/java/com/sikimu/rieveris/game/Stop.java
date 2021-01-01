package com.sikimu.rieveris.game;
import com.sikimu.rieveris.*;
import android.view.*;
import android.app.*;

public class Stop extends Game
{

	public Stop()
	{
		super(1000);
	}
	
	@Override
	public void update(Stage st)
	{
		st.allLock();
		st.setGame(new SetBlock());
	}

	@Override
	public void draw(Stage st, Activity act)
	{
		drawStage(st,act);
	}

	@Override
	public void event(Stage st, MotionEvent ev)
	{
		// TODO: Implement this method
	}

	
}
