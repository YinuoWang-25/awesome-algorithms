import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private int n, top, bottom, numberOfOpenSites;
    private WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0)
            throw new IllegalArgumentException();
        this.n = N;
        this.grid = new boolean[N][N];
        this.top = 0;
        this.bottom = N * N + 1;
        this.uf = new WeightedQuickUnionUF(N * N + 2);
        this.numberOfOpenSites = 0;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        // if this site is already open, just return
        if (grid[row - 1][col - 1])
            return;

        // set it as open
        grid[row - 1][col - 1] = true;
        numberOfOpenSites++;

        // union virtual top
        if (row == 1) {
            uf.union(getSiteIndex(row, col), top);
        }
        // union virtual bottom
        if (row == n) {
            uf.union(getSiteIndex(row, col), bottom);
        }
        // union possible neighbor(s)
        if (row > 1 && isOpen(row - 1, col)) {
            uf.union(getSiteIndex(row, col), getSiteIndex(row - 1, col));
        }
        if (row < n && isOpen(row + 1, col)) {
            uf.union(getSiteIndex(row, col), getSiteIndex(row + 1, col));
        }
        if (col > 1 && isOpen(row, col - 1)) {
            uf.union(getSiteIndex(row, col), getSiteIndex(row, col - 1));
        }
        if (col < n && isOpen(row, col + 1)) {
            uf.union(getSiteIndex(row, col), getSiteIndex(row, col + 1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n)
            throw new IndexOutOfBoundsException();
        int topRoot = uf.find(0);
        int curRoot = uf.find(getSiteIndex(row, col));
        return topRoot == curRoot;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        int topRoot = uf.find(0);
        int bottomRoot = uf.find(bottom);

        return topRoot == bottomRoot;
    }

    private int getSiteIndex(int row, int col) {
        return n * (row - 1) + col;
    }

    public static void main(String[] args) {

    }
}