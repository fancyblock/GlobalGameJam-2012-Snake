/**
 * 
 */
package hjb.ggj.ingame;

import hjb.ggj.vo.LevelInfo;
import hjb.ggj.vo.SubLeafInfo;

/**
 * @author hejiabin
 *
 */
public class LevelFactory 
{
	protected static LevelFactory m_instance = null;
	protected static boolean m_safyFlag = false;
	
	/**
	 * @desc	return the instance of this singleton
	 * @return
	 */
	static public LevelFactory Singleton()
	{
		if( m_instance == null )
		{
			m_safyFlag = true;
			m_instance = new LevelFactory();
			m_safyFlag = false;
		}
		
		return m_instance;
	}
	
	/**
	 * @desc	constructor
	 */
	public LevelFactory() 
	{
		if( m_safyFlag == false )
		{
			throw new Error( "[Error]: LevelFactory is a singleton , can not be created directly !" );
		}
		
		initial();
	}
	
	/**
	 * @desc	create a level
	 * @param	level
	 * @return
	 */
	public LevelInfo CreateLevel( int level )
	{
		LevelInfo li = new LevelInfo();
		li._subLeaves = new SubLeafInfo[24];
		li._leafCnt = 0;
		
		for( int i = 0; i <= 24; i++ )
		{
			if( Math.random() > 0.6f )
			{
				li._subLeaves[li._leafCnt] = SubLeafFactory.Singleton().CreateSubLeaf( (int)( Math.random() * 9 ) );
				li._subLeaves[li._leafCnt]._offset = i;
				
				li._leafCnt ++;
			}
		}
		
		// set a leaf for match
		li._matchLeafType = li._subLeaves[(int)( Math.random() * li._leafCnt )]._type;
		
		return li;
	}
	
	// initial the factory
	protected void initial() 
	{
		// TODO Auto-generated method stub
	}

}
