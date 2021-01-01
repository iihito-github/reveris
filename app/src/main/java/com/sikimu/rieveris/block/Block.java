package com.sikimu.rieveris.block;
import java.util.*;

public abstract class Block
{
	private int posX,posY;

	private boolean lockFlg = false;

	public Block(int x, int y, boolean flg)
	{
		posX = x;
		posY = y;
		lockFlg = flg;
	}

	public abstract String getBlockImage();

	public void setLock()
	{
		lockFlg = true;
	}

	public boolean isLock()
	{
		return lockFlg;
	}

	public int getX()
	{
		return posX;
	}

	public int getY()
	{
		return posY;
	}
	
	public void moveX(int mov)
	{
		posX = posX + mov;
	}
	
	public void moveY(int mov)
	{
		posY = posY + mov;
	}
}
