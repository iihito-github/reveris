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
	private ArrayList<Block> blockList;

	public Stage()
	{
		blockList = new ArrayList<Block>();
	}

	public void init()
	{
		blockList.clear();

		for (int i = HEIGHT - PLAY_HEIGHT;i < HEIGHT;i++)
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
		blockList.add(new Original(4, 0));
		blockList.add(new Original(4, 1));
		blockList.add(new Original(5, 0));
		blockList.add(new Original(5, 1));
	}

	public boolean isDrop()
	{
		for (Block block : getUnLockBlockList())
		{
			for (Block b : getLockBlockList())
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
		for (Block block : getUnLockBlockList())
		{
			block.moveY(1);
		}
	}

	public void allLock()
	{
		for (Block block : getUnLockBlockList())
		{
			block.setLock();
		}
	}

	public ArrayList<Block> getBlockList()
	{
		return blockList;
	}

	public ArrayList<Block> getUnLockBlockList()
	{
		ArrayList<Block> list = new ArrayList<Block>();
		for (Block block : getBlockList())
		{
			if (block.isLock())
			{
				continue;
			}
			list.add(block);
		}

		return list;
	}

	public ArrayList<Block> getLockBlockList()
	{
		ArrayList<Block> list = new ArrayList<Block>();
		for (Block block : getBlockList())
		{
			if (block.isLock() == false)
			{
				continue;
			}
			list.add(block);
		}

		return list;
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
