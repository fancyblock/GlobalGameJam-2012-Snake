/**
 * 
 */
package hjb.ggj;

import haframework.HAApp;
import hjb.ggj.ingame.GlobalWork;
import hjb.ggj.tasks.LeafTask;
import hjb.ggj.vo.LevelInfo;

/**
 * @author hjb
 *
 */
public class GameApp extends HAApp
{

	/**
	 * @desc	constructor
	 */
	public GameApp()
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate()
	{
		// init the tasks
		TaskSet._leafTask = new LeafTask();
		
		// init the first level	[temp]
		GlobalWork._curLevel = new LevelInfo();
		
		//( new TestTask() ).Start( 0 );	//TEMP
		TaskSet._leafTask.Start( 0 );
	}
	
	@Override
	public void onDestory()
	{
		//TODO
	}

}
