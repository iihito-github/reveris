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
		switch(ev.getAction())
		{
			case MotionEvent.ACTION_DOWN:
				setLastPoint(ev.getX(),ev.getY());
				break;
			case MotionEvent.ACTION_UP:
				if(ev.getEventTime() - ev.getDownTime() < 500){
					st.spin();
				}
				break;
			case MotionEvent.ACTION_MOVE:
				float x = ev.getX() - getLastPointX();
				if(x < -50)
				{
					if(st.isSlideLeft())
					{
						st.slideLeft();
					}
					setLastPoint(ev.getX(),ev.getY());
				}
				else if(x > 50)
				{
					if(st.isSlideRight())
					{
						st.slideRight();
					}
					setLastPoint(ev.getX(),ev.getY());
				}
				break;
		}
		
	}

}
