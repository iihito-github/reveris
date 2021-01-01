package com.sikimu.rieveris.game;
import com.sikimu.rieveris.*;
import android.view.*;
import android.app.*;

public class Drop extends Game
{
	public Drop()
	{
		super(1000);
	}
	
	@Override
	public void update(Stage st)
	{
		if(st.isDrop())
		{
			st.drop();
		}
		else
		{
			st.setGame(new Stop());
		}
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
