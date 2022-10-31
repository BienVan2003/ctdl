public class Fraction {
    private int numer = 0;
    private int denom = 1;
    private Fraction next;
    public Fraction(){
    }
    public Fraction(int x, int y){
        numer = x;
        denom = y;
    }
    public Fraction(Fraction f){
        numer = f.numer;
        denom = f.denom;
    }
    
    public int getTu() {
        return numer;
    }

    public void setTu(int tu) {
        this.numer = tu;
    }

    public int getMau() {
        return denom;
    }

    public void setMau(int mau) {
        this.denom = mau;
    }

    public int timUSCLN(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
    
    public void toiGianPhanSo() {
        int i = timUSCLN(this.getTu(), this.getMau());
        this.setTu(this.getTu() / i);
        this.setMau(this.getMau() / i);
    }

    public void connectVSFraction (Fraction f){
        next = f;
    }

    @Override
    public String toString() {
        return String.format("Fraction: %d/%d", numer,denom);
    }
    public boolean equals(Object f){
        if(f instanceof Fraction){
            this.toiGianPhanSo();
            Fraction temp = new Fraction();
            temp = (Fraction) f;
            temp.toiGianPhanSo();
            if(this.numer == temp.numer && this.denom == temp.denom){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}


