/**
 * Created by Tang on 2017/9/17.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
    public static void main(String[] args){
        System.out.print(new UniqueBinarySearchTrees().numTrees(4));
    }
}
