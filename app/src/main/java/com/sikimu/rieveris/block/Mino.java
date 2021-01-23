package com.sikimu.rieveris.block;

import java.util.*;

public class Mino
{
	private Block spinPoint;
	private ArrayList<Block> blockList;
	
	public Mino(){
		blockList = new ArrayList<Block>();
		
		int[][][] list =
		{
			{{4,0},{5,0},{4,1},{5,1}},
			{{4,0},{3,0},{5,0},{6,0}},
			{{3,1},{4,1},{5,1},{3,0}},
			{{3,1},{4,1},{5,1},{4,0}},
			{{3,1},{4,1},{5,1},{5,0}},
			{{3,0},{4,0},{4,1},{5,1}},
			{{3,1},{4,1},{4,0},{5,0}}
		};
		
		Random rand = new Random();
		for(int[] l : list[rand.nextInt(list.length)])
		{
			blockList.add(new Original(l[0], l[1]));
		}
		spinPoint = blockList.get(0);
	}
	
	public void spin()
	{
		for(Block block : blockList)
		{
			block.spin(spinPoint);
		}
	}
	
	public ArrayList<Block> getBlockList()
	{
		return blockList;
	}
}
