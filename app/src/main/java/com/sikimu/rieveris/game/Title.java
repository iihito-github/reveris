package com.sikimu.rieveris.game;
import android.app.*;
import android.view.*;
import android.widget.*;
import com.sikimu.rieveris.*;

public class Title extends Game
{
	public Title()
	{
		super(0);
	}

	@Override
	public void update(Stage s)
	{
	}

	@Override
	public void draw(Stage st, Activity act)
	{
		TextView mainText = act.findViewById(R.id.mainTextView);
		mainText.setText("Rieveris");

	}

	@Override
	public void event(Stage st, MotionEvent ev)
	{
		if (ev.getAction() == MotionEvent.ACTION_UP)
		{
			st.setGame(new SetBlock());
		}
	}

}
