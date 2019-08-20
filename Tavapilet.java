

public class Tavapilet {
    private double piletihind = 10.0;
    private int kylastajatearv;

    public Tavapilet(int kylastajatearv) {
        this.kylastajatearv = kylastajatearv;
    }

    public double summa(){
        return (piletihind*kylastajatearv);
    }

    @Override
    public String toString() {
        return
                "\tTavapilet " + piletihind + " EUR";
    }
}
