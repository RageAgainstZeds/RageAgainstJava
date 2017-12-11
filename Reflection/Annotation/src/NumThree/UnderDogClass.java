package NumThree;

public class UnderDogClass {
    @Save private int numInt;
    private String str;
    @Save private double doub;
    @Save private String txt;

    public UnderDogClass(int numInt, String str, double doub, String txt) {
        this.numInt = numInt;
        this.str = str;
        this.doub = doub;
        this.txt = txt;
    }

    public UnderDogClass() {
    }

    public int getNumInt() {
        return numInt;
    }

    public void setNumInt(int numInt) {
        this.numInt = numInt;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public double getDoub() {
        return doub;
    }

    public void setDoub(double doub) {
        this.doub = doub;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(double doub) {
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "UnderDogClass{" +
                "numInt=" + numInt +
                ", str='" + str + '\'' +
                ", doub=" + doub +
                ", txt='" + txt + '\'' +
                '}';
    }
}
