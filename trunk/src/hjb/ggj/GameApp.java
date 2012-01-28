/**
 * 
 */
package hjb.ggj;

import haframework.HAApp;
import hjb.ggj.ingame.GlobalWork;
import hjb.ggj.tasks.LeafTask;
import hjb.ggj.tasks.LogoTask;
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
		TaskSet._logoTask = new LogoTask();
		TaskSet._leafTask = new LeafTask();
		
		//TODO
		
		TaskSet._logoTask.Start( 0 );
	}
	
	@Override
	public void onDestory()
	{
		//TODO
	}

}
