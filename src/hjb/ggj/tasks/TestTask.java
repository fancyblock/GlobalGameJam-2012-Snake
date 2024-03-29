/**
 * 
 */
package hjb.ggj.tasks;

import java.util.Vector;

import haframework.draw.Sprite;
import haframework.draw.SpriteFactory;
import haframework.events.TouchEvent;
import haframework.task.Task;
import hjb.ggj.TaskSet;
import hjb.ggj.ingame.GlobalWork;
import hjb.ggj.ingame.LevelFactory;

/**
 * @author hjb
 *
 */
public class TestTask extends Task
{
	protected Sprite m_bg = null;

	/**
	 * @desc	constructor
	 */
	public TestTask()
	{
	}
	
	public void vBegin()
	{
		m_bg = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.title );
		m_bg.SetUV( 0.0f, 0.0f, 1.0f, 1.0f );
	}
	
	public void vDraw( float elapsed )
	{
		m_bg.Draw( 0, 0, 320, 560 );
	}
	
	@Override
	public boolean vOnTouchEvent( Vector<TouchEvent> events )
	{
		TouchEvent evt = events.get( 0 );
		
		if( evt != null )
		{
			if( evt.Type == TouchEvent.TOUCH )
			{
				// init the first level	[temp]
				GlobalWork._rotateSpeed = 0.015f;
				GlobalWork._curLevel = LevelFactory.Singleton().CreateLevel( 1 );
				
				this.Stop();
				TaskSet._leafTask.Start( 0 );
				
				return true;
			}
		}
		
		return false;
	}

}
