package m.com.numbergameresolve;

public class SecondStepObject {

    private String Name = "";
    private String result = "";
    private String NumberOne = "";
    private String NumberTwo = "";
    private String NumberThree = "";
    private String LastResult="";
    private int LestNumber=0;
    private int turn = 0;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNumberOne() {
        return NumberOne;
    }

    public void setNumberOne(String numberOne) {
        NumberOne = numberOne;
    }

    public String getNumberTwo() {
        return NumberTwo;
    }

    public void setNumberTwo(String numberTwo) {
        NumberTwo = numberTwo;
    }

    public String getNumberThree() {
        return NumberThree;
    }

    public void setNumberThree(String numberThree) {
        NumberThree = numberThree;
    }

    public String getLastResult() {
        return LastResult;
    }

    public void setLastResult(String lastResult) {
        LastResult = lastResult;
    }

    public int getLestNumber() {
        return LestNumber;
    }

    public void setLestNumber(int lestNumber) {
        LestNumber = lestNumber;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}

