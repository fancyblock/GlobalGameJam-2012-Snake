/**
 * 
 */
package hjb.ggj.ingame;

import haframework.draw.MovieClip;
import haframework.draw.Sprite;
import haframework.draw.SpriteFactory;

/**
 * @author hjb
 *
 */
public class ProgressUI
{
	protected Sprite m_sandglass = null;
	protected Sprite m_leftBar = null;
	protected Sprite m_rightBar = null;
	protected MovieClip m_snake = null;
	
	protected int m_mark = 0;

	/**
	 * @desc	constructor
	 */
	public ProgressUI()
	{
		m_sandglass = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.deco );
		m_sandglass.SetUV( 0, 183, 230, 54 );
		m_leftBar = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.deco );
		m_leftBar.SetUV( 0, 267, 212, 26 );
		m_rightBar = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.deco );
		m_rightBar.SetUV( 0, 239, 212, 26 );
		m_snake = SpriteFactory.Singleton().CreateMovieClip( hjb.ggj.R.drawable.snake_head_leaf, 300 );
		m_snake.AddFrame( 0, 201, 33, 33, 0, 0 );
		m_snake.AddFrame( 35, 201, 33, 33, 0, 0 );
	}

	public void Update(float elapsed)
	{
		m_snake.Update( elapsed );
	}

	public void Draw(int i, int j)
	{
		m_rightBar.Draw( i + 9, j + 10, 212 , 29 );
		m_leftBar.Draw( i + 9, j + 10, i - 10 + m_mark * 29, 29 );
		
		m_sandglass.Draw( i, j );
		m_snake.SetPos( i + 24 + m_mark * 29, j + 8 );
		m_snake.Draw();
	}

	public void SetMark(int i)
	{
		m_mark = i;
	}

}
