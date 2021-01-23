package com.sikimu.rieveris.game;
import android.app.*;
import android.view.*;
import android.widget.*;
import com.sikimu.rieveris.*;
import com.sikimu.rieveris.block.*;
import java.util.*;

public abstract class Game
{
	private long waitTime;
	private long nextTime;

	private static float lastPointX = -1;
	private static float lastPointY = -1;

	public Game(long wt)
	{
		waitTime = wt;
		nextTime = System.currentTimeMillis() + waitTime;
	}

	public void waitAndUpdate(Stage st)
	{
		if (nextTime > System.currentTimeMillis())
		{
			return;
		}
		update(st);
		nextTime = System.currentTimeMillis() + waitTime;
	}

	public abstract void update(Stage st);
	public abstract void draw(Stage st, Activity act);
	public abstract void event(Stage st, MotionEvent ev);

	public void drawStage(Stage st, Activity act)
	{
		TextView mainText = act.findViewById(R.id.mainTextView);
		TextView subText = act.findViewById(R.id.subTextView);

		String[][] list = new String[Stage.HEIGHT][Stage.WIDTH];

		for (String[] xl : list)
		{
			Arrays.fill(xl, "　");
		}

		for (Block block : st.getBlockList())
		{
			list[block.getY()][block.getX()] = block.getBlockImage();
		}

		if (st.getMino() != null)
		{
			for (Block block : st.getMino().getBlockList())
			{
				list[block.getY()][block.getX()] = block.getBlockImage();
			}
		}

		String text = "";
		for (String[] xl : list)
		{
			text = String.join("", xl) + "\n" + text;
		}

		mainText.setText(text);
		subText.setText(waitTime + "," + nextTime);
	}

	public static void setLastPoint(float x, float y)
	{
		lastPointX = x;
		lastPointY = y;
	}

	public static float getLastPointX()
	{
		return lastPointX;
	}

	public static float getLastPointY()
	{
		return lastPointY;
	}
}
