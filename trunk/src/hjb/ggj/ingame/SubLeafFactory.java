/**
 * 
 */
package hjb.ggj.ingame;

import hjb.ggj.vo.SubLeafInfo;

/**
 * @author hejiabin
 *
 */
public class SubLeafFactory 
{
	protected static SubLeafFactory m_instance = null;
	protected static boolean m_safyFlag = false;
	
	/**
	 * @desc	return the instance of this singleton
	 * @return
	 */
	static public SubLeafFactory Singleton()
	{
		if( m_instance == null )
		{
			m_safyFlag = true;
			m_instance = new SubLeafFactory();
			m_safyFlag = false;
		}
		
		return m_instance;
	}
	
	/**
	 * @desc	constructor
	 */
	public SubLeafFactory() 
	{
		if( m_safyFlag == false )
		{
			throw new Error( "[Error]: SubLeafFactory is a singleton , can not be created directly !" );
		}
		
		initial();
	}
	
	/**
	 * @desc	create a subLeaf
	 * @param	type
	 * @return
	 */
	public SubLeafInfo CreateSubLeaf( int type )
	{
		SubLeafInfo leaf = new SubLeafInfo();
		
		//TODO
		
		return leaf;
	}
	
	//---------------------------- private function ----------------------------
	
	// initial this factory
	protected void initial()
	{
		//TODO
	}

}
