package hjb.ggj;

import haframework.task.conf.Config;
import android.app.Activity;
import android.os.Bundle;

public class Ggj2012Activity extends Activity 
{
	protected GameApp m_app = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        
        //set the activity
        GameApp.SetActivity( this );
    }
    
    @Override
    protected void onStart()
    {
    	m_app = new GameApp();
    	Config cfg = new Config();
    	cfg._orientation = Config.ORIENTATION_PORTRAIT;
    	m_app.Create( cfg );
    	m_app.Start();
    	
    	super.onStart();
    }
    
    @Override
    protected void onStop()
    {
    	m_app.Destory();
    	
    	super.onStop();
    }
    
    @Override
    public void onBackPressed()
    {
    	//TODO
    }
}