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

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.game_resolve_fragment, container, false);
        TextView = (TextView)view.findViewById(R.id.TextView);
        NumberASpinner = (Spinner)view.findViewById(R.id.NamberA_Spinner);
        NumberBSpinner = (Spinner)view.findViewById(R.id.NamberB_Spinner);
        OkButton = (Button)view.findViewById(R.id.OkButton);
        OkButton.setOnClickListener(buttonClickListener);
        //Step0, GetAreaData
        return view;
    }

    //確定Button Function
    private Button.OnClickListener buttonClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            result = toString().valueOf(NumberASpinner.getSelectedItem())+toString().valueOf(NumberBSpinner.getSelectedItem());
            CheckAndRun();
        }
    };

    //依照NextStep選擇執行程式的Switch
    private void CheckAndRun(){

        switch (AllAreaObject.getNextStep()){

            case "FirstStep":
                FirstStep();
                break;

            case "SecomdStep":
                SecomdStep();
                break;
        }
    };

    //********一階段用function*********
    private void FirstStep(){

        ///更新HIT與SUM
        int Hit = Integer.valueOf(result.substring(0,1)) + Integer.valueOf(result.substring(2,3));
        sum = sum + Hit;

        //如果A區還沒登記，登記其結果與命中次數後更新FLAG檢查目前命中總數,大於3則更新FLAG、NextStep狀態
        if (!AreaA.getFirstCheck()){
            AreaA.setName("AreaA");
            AreaA.setAreaResult(result);
            AreaA.setHit(Hit);
            AreaA.setFirstCheck(true);
            firstStepEndCheck();
        }
        //如果B區還沒登記，登記其結果與命中次數後更新FLAG檢查目前命中總數
        else if(!AreaB.getFirstCheck()){
            AreaB.setName("AreaB");
            AreaB.setAreaResult(result);
            AreaB.setHit(Hit);
            AreaB.setFirstCheck(true);
            firstStepEndCheck();
        //如果C區還沒登記，登記其結果與命中次數後更新FLAG檢查目前命中總數
        }else if (!AreaC.getFirstCheck()){
            AreaC.setName("AreaC");
            AreaC.setAreaResult(result);
            AreaC.setHit(Hit);
            AreaC.setFirstCheck(true);

            if (sum !=3){
                AreaD.setHit(1);
                sum=sum+1;}
            firstStepEndCheck();

        }
    }

    //檢測總數達三表示FiestStep完成，FLAG全體更新修正Step
    private void firstStepEndCheck(){
        if(sum == 3){
        AreaB.setFirstCheck(true);
        AreaC.setFirstCheck(true);
        AreaD.setFirstCheck(true);
        AllAreaObject.setNextStep("SecondStep");}
        NumberASpinner.setSelection(0);
        NumberBSpinner.setSelection(0);
        Log.e("AreaA",String.valueOf(AreaA.getHit())+","+String.valueOf(AreaA.getFirstCheck())+","+String.valueOf(AreaA.getAreaResult()));
        Log.e("AreaB",String.valueOf(AreaB.getHit())+","+String.valueOf(AreaB.getFirstCheck())+","+String.valueOf(AreaB.getAreaResult()));
        Log.e("AreaC",String.valueOf(AreaC.getHit())+","+String.valueOf(AreaC.getFirstCheck())+","+String.valueOf(AreaC.getAreaResult()));
        Log.e("AreaD",String.valueOf(AreaD.getHit())+","+String.valueOf(AreaD.getFirstCheck())+","+String.valueOf(AreaD.getAreaResult()));
        Log.e("NextStep",AllAreaObject.getNextStep());
    }


    //********二階段用function*********
    private void SecomdStep(){
        Type = AllAreaObject.getType();
        if (Type.equals("")){
            CheckType();
        }
        switch (Type)
        {
            case "A":
                TypeA();
                AllAreaObject.setNextStep("ThridStep");
                break;


        }


    }

    private void CheckType(){
        int TopNumber = 0;
        if(AreaA.getHit() > TopNumber){
            TopNumber = AreaA.getHit();}
        if(AreaB.getHit() > TopNumber){
            TopNumber = AreaB.getHit();}
        if(AreaC.getHit() > TopNumber){
            TopNumber = AreaC.getHit();}

        if(TopNumber == 3){
            AllAreaObject.setType("A");
        }else if(TopNumber == 2){

            if(AreaD.getHit() ==0){
                AllAreaObject.setType("B");
            }else{
                AllAreaObject.setType("C");
            }

        }else if(TopNumber == 1){
            if(AreaD.getHit() ==0){
                AllAreaObject.setType("D");
            }else{
                AllAreaObject.setType("E");
            }
        }
    }

    private void TypeA(){
        AllAreaObject.getAnswer().setNumberOne();
        if (AreaA.getHit()==3){
           

        }

    }




}
