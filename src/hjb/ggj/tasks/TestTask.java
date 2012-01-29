/**
 * 
 */
package hjb.ggj.tasks;

import haframework.draw.Sprite;
import haframework.draw.SpriteFactory;
import haframework.task.Task;

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
		m_bg = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.ggj2012logo );
		m_bg.SetUV( 0.0f, 0.0f, 1.0f, 1.0f );
	}
	
	public void vDraw( float elapsed )
	{
		m_bg.Draw( 0, 0, 300, 300 );
	}

}
