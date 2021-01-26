public class Pair {
    int max;
    int freq;

    public Pair(int max, int freq) {
        this.max = max;
        this.freq = freq;
    }

    @Override
    public String toString() {
        return "{" + this.max + ":" + this.freq + "}";
    }
}
