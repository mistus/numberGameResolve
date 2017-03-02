package m.com.numbergameresolve;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    private GameResolveFragment GameResolveFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResetFragmentPage();
        //Step0, GetAreaData
    }

    public void ResetFragmentPage(){
        GameResolveFragment = new GameResolveFragment();
        FragmentTransaction FragmentTransaction = getFragmentManager().beginTransaction();
        FragmentTransaction.replace(R.id.displayPage, GameResolveFragment);
        FragmentTransaction.commit();
    }
}
