/**
 * 
 */
package hjb.ggj;

import haframework.HAApp;
import hjb.ggj.tasks.TestTask;

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
		( new TestTask() ).Start( 0 );
	}
	
	@Override
	public void onDestory()
	{
		//TODO
	}

}
