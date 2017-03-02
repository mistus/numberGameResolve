package m.com.numbergameresolve;

public class AreaObject {
    private int Hit = 0 ;
    private String AreaResult ="";
    private boolean FirstCheck = false;

    public boolean getFirstCheck() {
        return FirstCheck;
    }

    public void setFirstCheck(boolean firstCheck) {
        FirstCheck = firstCheck;
    }

    public int getHit() {
        return Hit;
    }

    public void setHit(int amount) {
        Hit = amount;
    }

    public String getAreaResult() {
        return AreaResult;
    }

    public void setAreaResult(String arearesult) {
        AreaResult = arearesult;
    }
}
