package m.com.numbergameresolve;

public class AllAreaObject {

    // 設置物件ABCD
    AreaObject AreaA = new AreaObject();
    AreaObject AreaB = new AreaObject();
    AreaObject AreaC = new AreaObject();
    AreaObject AreaD = new AreaObject();

    //Step
    String NextStep="FirstStep";

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
}
