package m.com.numbergameresolve;

public class AllAreaObject {

    // 設置物件ABCD
    AreaObject AreaA = new AreaObject();
    AreaObject AreaB = new AreaObject();
    AreaObject AreaC = new AreaObject();
    AreaObject AreaD = new AreaObject();

    //StepDefult
    String NextStep="FirstStep";

    //宣告SecondStep用物件
    SecondStepObject ComparisonObjectOne = new SecondStepObject();
    SecondStepObject ComparisonObjectTwo = new SecondStepObject();
    SecondStepObject ComparisonObjectThree = new SecondStepObject();
    SecondStepObject Answer = new SecondStepObject();

    //Type
    String Type = "";

    public AreaObject getAreaA() {
        return AreaA;
    }

    public void setAreaA(AreaObject areaA) {
        AreaA = areaA;
    }

    public AreaObject getAreaB() {
        return AreaB;
    }

    public void setAreaB(AreaObject areaB) {
        AreaB = areaB;
    }

    public AreaObject getAreaC() {
        return AreaC;
    }

    public void setAreaC(AreaObject areaC) {
        AreaC = areaC;
    }

    public AreaObject getAreaD() {
        return AreaD;
    }

    public void setAreaD(AreaObject areaD) {
        AreaD = areaD;
    }

    public String getNextStep() {
        return NextStep;
    }

    public void setNextStep(String nextStep) {
        NextStep = nextStep;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public SecondStepObject getComparisonObjectOne() {
        return ComparisonObjectOne;
    }

    public void setComparisonObjectOne(SecondStepObject comparisonObjectOne) {
        ComparisonObjectOne = comparisonObjectOne;
    }

    public SecondStepObject getComparisonObjectTwo() {
        return ComparisonObjectTwo;
    }

    public void setComparisonObjectTwo(SecondStepObject comparisonObjectTwo) {
        ComparisonObjectTwo = comparisonObjectTwo;
    }

    public SecondStepObject getComparisonObjectThree() {
        return ComparisonObjectThree;
    }

    public void setComparisonObjectThree(SecondStepObject comparisonObjectThree) {
        ComparisonObjectThree = comparisonObjectThree;
    }

    public SecondStepObject getAnswer() {
        return Answer;
    }

    public void setAnswer(SecondStepObject answer) {
        Answer = answer;
    }
}
