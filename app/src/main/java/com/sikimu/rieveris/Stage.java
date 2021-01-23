package com.sikimu.rieveris;

import com.sikimu.rieveris.block.*;
import com.sikimu.rieveris.game.*;
import java.util.*;
import android.app.*;
import android.view.*;

public class Stage
{
	public final static int WIDTH = 12;
	public final static int HEIGHT = 25;
	public final static int PLAY_HEIGHT = 20;

	private Game game;
	private Mino mino;
	private ArrayList<Block> blockList;

	public Stage()
	{
		blockList = new ArrayList<Block>();
	}

	public void init()
	{
		blockList.clear();

		for (int i = 0;i < HEIGHT;i++)
		{
			blockList.add(new Other(0, i));
			blockList.add(new Other(WIDTH - 1, i));
		}
		for (int i = 0;i < WIDTH;i++)
		{
			blockList.add(new Other(i, HEIGHT - 1));
		}
	}

	public void setNewMino()
	{
		mino = new Mino();
	}

	public boolean isDrop()
	{
		for (Block block : mino.getBlockList())
		{
			for (Block b : blockList)
			{
				if (block.getX() == b.getX()
					&& block.getY() + 1 == b.getY())
				{
					return false;
				}
			}
		}
		return true;
	}

	public void drop()
	{
		for (Block block : mino.getBlockList())
		{
			block.moveY(1);
		}
	}
	
	public boolean isSlideLeft()
	{
		for (Block block : mino.getBlockList())
		{
			for (Block b : blockList)
			{
				if (block.getX() - 1 == b.getX()
					&& block.getY() == b.getY())
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isSlideRight()
	{
		for (Block block : mino.getBlockList())
		{
			for (Block b : blockList)
			{
				if (block.getX() + 1 == b.getX()
					&& block.getY() == b.getY())
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public void slideLeft()
	{
		for (Block block : mino.getBlockList())
		{
			block.moveX(-1);
		}
	}

	public void slideRight()
	{
		for (Block block : mino.getBlockList())
		{
			block.moveX(1);
		}
	}
	
	public void spin()
	{
		mino.spin();
	}
	
	public void allLock()
	{
		blockList.addAll(mino.getBlockList());
	}

	public ArrayList<Block> getBlockList()
	{
		return blockList;
	}
	
	public Mino getMino()
	{
		return mino;
	}

	public void setGame(Game gm)
	{
		game = gm;
	}

	public void update()
	{
		game.waitAndUpdate(this);
	}

	public void draw(Activity act)
	{
		game.draw(this, act);
	}
	
	public void event(MotionEvent ev)
	{
		game.event(this, ev);
	}
	
}
