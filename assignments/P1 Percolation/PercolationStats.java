import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int numOfTrails;
    private double[] fractions;
    private double factor = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int N, int T) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException("N <= 0 or T <= 0");
        }
        numOfTrails = T;
        fractions = new double[numOfTrails];
        for (int expNum = 0; expNum < numOfTrails; expNum++) {
            Percolation pr = new Percolation(N);
            while (!pr.percolates()) {
                int row = StdRandom.uniform(1, N + 1), col = StdRandom.uniform(1, N + 1);
                if (!pr.isOpen(row, col))
                    pr.open(row, col);
            }
            fractions[expNum] = (double) pr.numberOfOpenSites() / (N * N);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(fractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (factor * stddev() / Math.sqrt(numOfTrails));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (factor * stddev() / Math.sqrt(numOfTrails));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats pStats = new PercolationStats(N, T);

        String confidence = pStats.confidenceLo() + ", " + pStats.confidenceHi();
        StdOut.println("mean                    = " + pStats.mean());
        StdOut.println("stddev                  = " + pStats.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }
}