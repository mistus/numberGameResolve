package m.com.numbergameresolve;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameResolveFragment extends Fragment {

    // New AllAreaObj
    private  AllAreaObject AllAreaObject = new AllAreaObject();

    //宣告ABCD
    AreaObject AreaA = AllAreaObject.getAreaA();
    AreaObject AreaB = AllAreaObject.getAreaB();
    AreaObject AreaC = AllAreaObject.getAreaC();
    AreaObject AreaD = AllAreaObject.getAreaD();

    //宣告SecondStep
    String Type = "";

    private String result = "";
    private int sum = 0;
    Spinner NumberASpinner;
    Spinner NumberBSpinner;
    private TextView TextView;
    private Button OkButton;
    private ArrayList<String[]> NumberList;
    int count = 0;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.game_resolve_fragment, container, false);
        TextView = (TextView)view.findViewById(R.id.TextView);
        NumberASpinner = (Spinner)view.findViewById(R.id.NamberA_Spinner);
        NumberBSpinner = (Spinner)view.findViewById(R.id.NamberB_Spinner);
        OkButton = (Button)view.findViewById(R.id.OkButton);
        OkButton.setOnClickListener(buttonClickListener);
        //Step0, GetAreaData
        init();
        int random = (int) (Math.random() * NumberList.size());
        return view;
    }

    //確定Button Function
    private Button.OnClickListener buttonClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            for(String[] Number : NumberList){
                Log.e("System",Number[2]+Number[1]+Number[0]);
            }
            Log.e("","共有"+String.valueOf(NumberList.size())+"個可能性");
        }
    };

    private void init(){
        String[] Number = new String[3];
        NumberList = new ArrayList<>();
        for (int k=0;k<10;k++){
            for (int j=0;j<10;j++) {
                for (int i=0;i<10;i++) {
                    if(i==j || i==k || j==k){
                        continue;
                    }
                    String FirstNumber = String.valueOf(i);
                    String SecondNumber = String.valueOf(j);
                    String ThirdNumber = String.valueOf(k);

                    NumberList.add(new String[] {FirstNumber,SecondNumber,ThirdNumber});
                }
            }
        }
    }

}
