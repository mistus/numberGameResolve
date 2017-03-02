package m.com.numbergameresolve;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private GameResolveFragment GameResolveFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ResetFragmentPage();
        //Step0, GetAreaData

    }

    private void ResetFragmentPage(){
        GameResolveFragment = new GameResolveFragment();
        FragmentTransaction FragmentTransaction = getFragmentManager().beginTransaction();
        FragmentTransaction.replace(R.id.displayPage, GameResolveFragment);
        FragmentTransaction.commit();
    }
}
