

public class Sooduspilet extends Tavapilet {
    private double piletihind = 5.0;
    private int soodusKylastajateArv;

    public Sooduspilet(int kylastajatearv, int soodusKylastajateArv) {
        super(kylastajatearv);
        this.soodusKylastajateArv = soodusKylastajateArv;
    }

    @Override
    public double summa() {
        return (piletihind*soodusKylastajateArv);
    }

    @Override
    public String toString() {
        return
                "\tSooduspilet " + piletihind + " EUR";
    }
}
