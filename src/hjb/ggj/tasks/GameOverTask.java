/**
 * 
 */
package hjb.ggj.tasks;

import haframework.draw.Sprite;
import haframework.draw.SpriteFactory;
import haframework.events.TouchEvent;
import haframework.task.Task;
import hjb.ggj.TaskSet;

import java.util.Vector;

/**
 * @author hjb
 *
 */
public class GameOverTask extends Task
{
	protected Sprite m_bg = null;
	
	/**
	 * @desc	constructor
	 */
	public GameOverTask()
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void vBegin()
	{
		m_bg = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.gameover );
		m_bg.SetUV( 0.0f, 0.0f, 1.0f, 1.0f );
	}
	
	@Override
	public void vMain( float elapsed )
	{
		//TODO
	}
	
	@Override
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
				this.Stop();
				TaskSet._titleTask.Start( 0 );
				
				return true;
			}
		}
		
		return false;
	}

}
