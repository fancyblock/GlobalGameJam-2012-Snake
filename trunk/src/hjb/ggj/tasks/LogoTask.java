/**
 * 
 */
package hjb.ggj.tasks;

import haframework.draw.Sprite;
import haframework.draw.SpriteFactory;
import haframework.task.Task;
import hjb.ggj.TaskSet;
import hjb.ggj.ingame.GlobalWork;
import hjb.ggj.vo.LevelInfo;

/**
 * @author hejiabin
 *
 */
public class LogoTask extends Task 
{
	protected Sprite m_bg = null;
	protected float m_time = 0.0f;

	/**
	 * @desc	constructor
	 */
	public LogoTask() 
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void vBegin()
	{
		m_bg = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.ggjlogo );
		m_bg.SetUV( 0.0f, 0.0f, 1.0f, 1.0f );
		
		m_time = 0.0f;
	}
	
	@Override
	public void vMain( float elapsed )
	{
		m_time += 0.1f;
		
		if( m_time > 10.0f )
		{
			// init the first level	[temp]
			GlobalWork._curLevel = new LevelInfo();
			
			this.Stop();
			TaskSet._leafTask.Start( 0 );
		}
	}
	
	@Override
	public void vDraw( float elapsed )
	{
		m_bg.Draw( 0, 0, 320, 480 );
	}

}
