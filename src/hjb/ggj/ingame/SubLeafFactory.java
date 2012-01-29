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
	
	protected int MAX_LEAF = 20;
	protected int m_resIdLib[] = null;
	protected int m_uLib[] = null;
	protected int m_vLib[] = null;
	
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
		
		leaf._type = type;
		leaf._offset = 0;
		
		leaf._resId = m_resIdLib[type];
		leaf._u = m_uLib[type];
		leaf._v = m_vLib[type];
		
		return leaf;
	}
	
	//---------------------------- private function ----------------------------
	
	// initial this factory
	protected void initial()
	{
		 m_resIdLib = new int[MAX_LEAF];
		 m_uLib = new int[MAX_LEAF];
		 m_vLib = new int[MAX_LEAF];
		 
		 m_resIdLib[0] = hjb.ggj.R.drawable.snake_head_leaf;
		 m_resIdLib[1] = hjb.ggj.R.drawable.snake_head_leaf;
		 m_resIdLib[2] = hjb.ggj.R.drawable.snake_head_leaf;
		 m_resIdLib[3] = hjb.ggj.R.drawable.snake_head_leaf;
		 m_resIdLib[4] = hjb.ggj.R.drawable.snake_head_leaf;
		 m_resIdLib[5] = hjb.ggj.R.drawable.snake_head_leaf;
		 m_resIdLib[6] = hjb.ggj.R.drawable.snake_head_leaf;
		 m_resIdLib[7] = hjb.ggj.R.drawable.snake_head_leaf;
		 m_resIdLib[8] = hjb.ggj.R.drawable.deco;
		 
		 m_uLib[0] = 119; m_vLib[0] = 67;
		 m_uLib[1] = 153; m_vLib[1] = 67;
		 m_uLib[2] = 187; m_vLib[2] = 67;
		 m_uLib[3] = 221; m_vLib[3] = 67;
		 m_uLib[4] = 119; m_vLib[4] = 133;
		 m_uLib[5] = 153; m_vLib[5] = 133;
		 m_uLib[6] = 187; m_vLib[6] = 133;
		 m_uLib[7] = 221; m_vLib[7] = 133;
		 m_uLib[8] = 449; m_vLib[8] = 0;
	}
}
