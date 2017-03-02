package m.com.numbergameresolve;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class GameResolveFragment extends Fragment {

    // New AllAreaObj
    private  AllAreaObject AllAreaObject = new AllAreaObject();

    private String result = "";
    private int sum = 0;
    private TextView TextView;
    private Button OkButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.game_resolve_fragment, container, false);
        TextView = (TextView)view.findViewById(R.id.TextView);
        OkButton = (Button)view.findViewById(R.id.OkButton);
        OkButton.setOnClickListener(buttonClickListener);
        //Step0, GetAreaData
        return view;
    }

    //確定Button Function
    private Button.OnClickListener buttonClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            result = String.valueOf(TextView.getText());
            CheckAndRun();
        }
    };

    private void CheckAndRun(){

        switch (AllAreaObject.getNextStep()){

            case "FirstStep":

                break;
        }


    };


}
