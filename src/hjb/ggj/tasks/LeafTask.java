/**
 * 
 */
package hjb.ggj.tasks;

import haframework.draw.MovieClip;
import haframework.draw.Sprite;
import haframework.draw.SpriteFactory;
import haframework.events.TouchEvent;
import haframework.sound.SoundManager;
import haframework.task.Task;
import hjb.ggj.ingame.GlobalWork;
import hjb.ggj.ingame.InGameCommon;
import hjb.ggj.ingame.LevelFactory;
import hjb.ggj.ingame.ProgressUI;
import hjb.ggj.ingame.SubLeafFactory;
import hjb.ggj.vo.LevelInfo;
import hjb.ggj.vo.SubLeafInfo;

import java.util.Vector;

/**
 * @author hejiabin
 *
 */
public class LeafTask extends Task
{
	//-------------------------- static members -------------------------
	
	static protected final String STATE_RUNNING = "state running";
	static protected final String STATE_MATCHED = "state matched";
	static protected final String STATE_PAUSE = "state pause";
	
	static protected final float ROUND = (float)( Math.PI * 2 );
	
	//------------------------- private members -------------------------
	
	protected LevelInfo m_lvInfo = null;
	protected float m_curAngle = 0.0f;
	protected float m_angleInterval = 0;
	
	protected Sprite m_bg = null;
	protected Sprite m_snakeBody = null;
	protected MovieClip m_snakeHead = null;
	protected Sprite m_leafs[] = null;
	protected Sprite m_aimFrame1 = null;
	protected Sprite m_aimFrame2 = null;
	protected Sprite m_levels[] = null;
	
	protected String m_state = null;
	protected int m_mark = 0;
	
	protected ProgressUI m_progressUI = null;
	
	//------------------------- public functions -------------------------
	
	/**
	 * @desc	constructor
	 */
	public LeafTask() 
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void vBegin()
	{
		// init base parameter
		m_lvInfo = GlobalWork._curLevel;
		m_curAngle = 0.0f;
		m_angleInterval = InGameCommon._angleInterval;
		
		// init the graphics
		m_leafs = new Sprite[9];
		for( int i = 0; i < 9; i++ )
		{
			SubLeafInfo li = SubLeafFactory.Singleton().CreateSubLeaf( i );
			m_leafs[i] = SpriteFactory.Singleton().CreateSprite( li._resId );
			m_leafs[i].SetUV( li._u, li._v, 32, 64 );
		}
		m_snakeHead = SpriteFactory.Singleton().CreateMovieClip( hjb.ggj.R.drawable.snake_head_leaf, 167 );
		m_snakeHead.AddFrame( 0, 0, 117, 65, 0, 0 );
		m_snakeHead.AddFrame( 119, 0, 117, 65, 0, 0 );
		m_snakeHead.AddFrame( 0, 67, 117, 65, 0, 0 );
		m_snakeHead.AddFrame( 0, 134, 117, 65, 0, 0 );
		m_snakeHead.SetPos( 88, 284 );
		m_snakeBody = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.deco );
		m_snakeBody.SetUV( 0, 0, 181, 181 );
		m_snakeBody.SetAnchor( 90.5f, 90.5f );
		m_bg = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.bg );
		m_bg.SetUV( 0.0f, 0.0f, 1.0f, 1.0f );
		m_aimFrame1 = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.deco );
		m_aimFrame1.SetUV( 183, 0, 131, 116 );
		m_aimFrame1.SetAnchor( 65.5f, 58.0f );
		m_aimFrame2 = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.deco );
		m_aimFrame2.SetUV( 316, 0, 131, 116 );
		m_aimFrame2.SetAnchor( 65.5f, 58.0f );
		m_levels = new Sprite[6];
		m_levels[0] = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.achieve_bg );
		m_levels[0].SetUV( 0, 0, 320, 217 );
		m_levels[1] = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.achieve_bg );
		m_levels[1].SetUV( 322, 0, 320, 217 );
		m_levels[2] = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.achieve_bg );
		m_levels[2].SetUV( 644, 0, 320, 217 );
		m_levels[3] = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.achieve_bg );
		m_levels[3].SetUV( 0, 219, 320, 217 );
		m_levels[4] = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.achieve_bg );
		m_levels[4].SetUV( 0, 438, 320, 217 );
		m_levels[5] = SpriteFactory.Singleton().CreateSprite( hjb.ggj.R.drawable.achieve_bg );
		m_levels[5].SetUV( 0, 657, 320, 217 );
		//TODO
		
		m_state = STATE_RUNNING;
		m_mark = 0;
		
		// initial sounds
		SoundManager.Singleton().LoadSoundBGM( hjb.ggj.R.raw.bgm, "bgm" );
		SoundManager.Singleton().PlayBGM( "bgm" );
		SoundManager.Singleton().LoadSound( hjb.ggj.R.raw.right, "right" );
		SoundManager.Singleton().LoadSound( hjb.ggj.R.raw.wrong, "wrong" );
	}
	
	@Override
	public void vEnd()
	{
	}
	
	@Override
	public void vDestroy()
	{
	}
	
	@Override
	public void vMain( float elapsed )
	{
		m_curAngle += this.m_lvInfo._rotateSpeed;
		
		m_snakeHead.Update( elapsed );
	}
	
	@Override
	public void vDraw( float elapsed )
	{
		m_bg.Draw( 0, 0, 320, 560 );
		m_levels[m_mark].Draw( 0, 20 );
		
		//TODO
		
		m_aimFrame1.Draw( 160, 258 );
		
		int i;
		SubLeafInfo subLeaf;
		float leafAngle;
		
		boolean aimLeaf = false;
		for( i = 0; i < m_lvInfo._leafCnt; i++ )
		{
			subLeaf = m_lvInfo._subLeaves[i];
			
			leafAngle = m_curAngle + subLeaf._offset * m_angleInterval;
			leafAngle = normalizeAngle( leafAngle );
			
			m_leafs[subLeaf._type].SetAnchor( 16, 155 );
			m_leafs[subLeaf._type].Draw( 160, 386, -leafAngle );
			
			if( subLeaf._type == m_lvInfo._matchLeafType && !aimLeaf )
			{
				m_leafs[subLeaf._type].SetAnchor( 16, 32 );
				m_leafs[subLeaf._type].Draw( 160.0f, 386.0f );
				
				aimLeaf = true;
			}
		}
		
		m_snakeBody.Draw( 160.0f, 386.0f, -m_curAngle );
		m_snakeHead.Draw();
		
		//TODO 
	}
	
	@Override
	public boolean vOnTouchEvent( Vector<TouchEvent> events )
	{
		TouchEvent evt = events.get( 0 );
		
		if( evt != null && m_state == STATE_RUNNING )
		{
			if( evt.Type == TouchEvent.TOUCH )
			{
				int index = matchLeaf();
				
				if( index >= 0 )
				{
					if( m_mark < 5 )
					{
						m_mark++;
						
						m_lvInfo = LevelFactory.Singleton().CreateLevel( 0 );
						
						//TODO
						
						SoundManager.Singleton().PlaySE( "right" );
					}
					else
					{
						//TODO		level complete
					}
					
					//m_state = STATE_MATCHED;
					
					return true;
				}
				
				// wrong
				SoundManager.Singleton().PlaySE( "wrong" );
			}
		}
		
		return false;
	}
	
	//------------------------- private function -------------------------
	
	// judge if the leaf is match the current pattern
	protected int matchLeaf()
	{
		int cnt = m_lvInfo._leafCnt;
		SubLeafInfo subLeaf;
		float leafAngle;
		
		for( int i = 0; i < cnt; i++ )
		{
			subLeaf = m_lvInfo._subLeaves[i];
			
			leafAngle = m_curAngle + subLeaf._offset * m_angleInterval;
			leafAngle = normalizeAngle( leafAngle );
			
			// find the leaf that match the pattern
			if( Math.abs( leafAngle ) < m_lvInfo._epsion && subLeaf._type == m_lvInfo._matchLeafType )
			{
				return i;
			}
		}
		
		return -1;
	}
	
	// normalize a angle
	protected float normalizeAngle( float angle )
	{
		float ang = angle;
		
		if( ang > ROUND )
		{
			ang = ang % ROUND;
		}
		if( ang > ( ROUND / 2.0f ) )
		{
			ang = -( ROUND - ang );
		}
		
		return ang;
	}

}
