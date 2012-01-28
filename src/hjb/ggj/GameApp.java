/**
 * 
 */
package hjb.ggj;

import haframework.HAApp;
import hjb.ggj.tasks.LeafTask;
import hjb.ggj.tasks.LogoTask;
import hjb.ggj.tasks.TransitionTask;

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
		TaskSet._transTask = new TransitionTask();
		
		//TODO
		
		TaskSet._logoTask.Start( 0 );
	}
	
	@Override
	public void onDestory()
	{
		//TODO
	}

}
