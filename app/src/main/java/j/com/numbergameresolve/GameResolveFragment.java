package j.com.numbergameresolve;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import java.util.ArrayList;

public class GameResolveFragment extends Fragment {

    private String result = "";
    Spinner NumberASpinner;
    Spinner NumberBSpinner;
    private TextView TextView;
    private Button OkButton;
    private Button ResetButton;
    private ArrayList<String[]> NumberList;
    String[] LastGuess = null;
    private Button AdButton;
    private InterstitialAd interstitial;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(j.com.numbergameresolve.R.layout.game_resolve_fragment, container, false);
        TextView = (TextView)view.findViewById(j.com.numbergameresolve.R.id.TextView);
        NumberASpinner = (Spinner)view.findViewById(j.com.numbergameresolve.R.id.NamberA_Spinner);
        NumberBSpinner = (Spinner)view.findViewById(j.com.numbergameresolve.R.id.NamberB_Spinner);
        OkButton = (Button)view.findViewById(j.com.numbergameresolve.R.id.OkButton);
        OkButton.setOnClickListener(buttonClickListener);
        ResetButton = (Button)view.findViewById(j.com.numbergameresolve.R.id.ResetButton);
        ResetButton.setOnClickListener(ResetButtonClickListener);
        AdButton = (Button)view.findViewById(j.com.numbergameresolve.R.id.AdButton);
        AdButton.setOnClickListener(AdButtonClickListener);

        init();
        RandomAndSave();

        //SetAdmob
        AdView mAdView = (AdView) view.findViewById(j.com.numbergameresolve.R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // Create the interstitial.
        interstitial = new InterstitialAd(getActivity().getApplicationContext());
        interstitial.setAdUnitId("ca-app-pub-7648432463826362/5265313333");

        // Create ad request.
        adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);

        return view;
    }

    //確定Button Function
    private Button.OnClickListener buttonClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                result = toString().valueOf(NumberASpinner.getSelectedItem()) + toString().valueOf(NumberBSpinner.getSelectedItem());
                CheckAnswerAndSearch();
                RandomAndSave();
                SpinnerReset();
            }catch (Exception e){
                TextView.setText("正しい答えが存在してないですよ！");
            }
        }
    };

    private Button.OnClickListener ResetButtonClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).ResetFragmentPage();
//            init();
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

    private void RandomAndSave(){
        int random = (int) (Math.random() * NumberList.size());
        String[] Number = NumberList.get(random);
        LastGuess = Number;

        if (NumberList.size()==1){
            Number = NumberList.get(0);
            TextView.setText("答えは"+Number[2]+Number[1]+Number[0]+"です！");
            OkButton.setOnClickListener(null);
            return;
        }

        if (NumberList.size()==720){
            TextView.setText("今は720の可能性が存在しています。\nでは"+Number[2]+Number[1]+Number[0]+"を入力して、結果を教えてください！");
            return;
        }

        TextView.setText("また"+NumberList.size()+"種可能性が存在しています。\n次は"+Number[2]+Number[1]+Number[0]+"を入力しください！");

    }

    private void CheckAnswerAndSearch(){
//        Log.e("LastGuess",LastGuess[2]+LastGuess[1]+LastGuess[0]);
//        Log.e("result",result);

        ArrayList<String[]> TMP = new ArrayList<>();
        for(String[] Number : NumberList){
            if (CheckAnswer(Number)){
                TMP.add(Number);
            }
        }
        NumberList = TMP;
    }

    private boolean CheckAnswer(String[] Number){

//        Log.e("LastGuess",LastGuess[2]+LastGuess[1]+LastGuess[0]);
//        Log.e("Number",Number[2]+Number[1]+Number[0]);
//        Log.e("result",result);

        int resultA = Integer.valueOf(result.substring(0,1));
        int resultB = Integer.valueOf(result.substring(2,3));

        int sum =0;
        int A = 0;


        for (int j =0;j<3;j++){
            for (int i=0;i<3;i++){
                if(LastGuess[i]==Number[j]){
                    sum=sum+1;
                }
            }
        }

        if (sum != resultA + resultB){
            return false;
        }

        for (int i =0; i<3; i++){
            if(LastGuess[i]==Number[i]){
                A=A+1;
            }
        }

        if (A != resultA ){
            return false;
        }
        return true;
    }

    private void SpinnerReset(){
        NumberASpinner.setSelection(0);
        NumberBSpinner.setSelection(0);
    }

    private void check(){
                    for(String[] Number : NumberList){
                Log.e("System",Number[2]+Number[1]+Number[0]);
            }
            Log.e("","共有"+String.valueOf(NumberList.size())+"個可能性");
    }

    private Button.OnClickListener AdButtonClickListener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            displayInterstitial();
        }
    };

    public void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}
