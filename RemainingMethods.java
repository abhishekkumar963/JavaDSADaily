import java.util.*;

public class RemainingMethods {

    private boolean[] isSuspicious;
    private boolean[] isVisited;
    private List<Integer>[] undirectedGraph;
    private List<Integer>[] directedGraph;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        isSuspicious = new boolean[n];
        isVisited = new boolean[n];
        undirectedGraph = new ArrayList[n];
        directedGraph = new ArrayList[n];

        Arrays.setAll(undirectedGraph, i -> new ArrayList<>());
        Arrays.setAll(directedGraph, i -> new ArrayList<>());

        for (int[] invocation : invocations) {
            int caller = invocation[0];
            int callee = invocation[1];

            undirectedGraph[caller].add(callee);
            undirectedGraph[callee].add(caller);

            directedGraph[caller].add(callee);
        }

        markSuspiciousFromSource(k);

        for (int method = 0; method < n; method++) {
            if (!isSuspicious[method] && !isVisited[method]) {
                markConnectedAsSafe(method);
            }
        }

        List<Integer> remainingMethodsList = new ArrayList<>();
        for (int method = 0; method < n; method++) {
            if (!isSuspicious[method]) {
                remainingMethodsList.add(method);
            }
        }

        return remainingMethodsList;
    }

    private void markSuspiciousFromSource(int currentMethod) {
        isSuspicious[currentMethod] = true;

        for (int calledMethod : directedGraph[currentMethod]) {
            if (!isSuspicious[calledMethod]) {
                markSuspiciousFromSource(calledMethod);
            }
        }
    }

    private void markConnectedAsSafe(int currentMethod) {
        isVisited[currentMethod] = true;

        for (int connectedMethod : undirectedGraph[currentMethod]) {
            if (!isVisited[connectedMethod]) {
                isSuspicious[connectedMethod] = false;
                markConnectedAsSafe(connectedMethod);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of methods (n): ");
        int n = sc.nextInt();

        System.out.print("Enter suspicious method (k): ");
        int k = sc.nextInt();

        System.out.print("Enter number of invocations: ");
        int m = sc.nextInt();

        int[][] invocations = new int[m][2];

        System.out.println("Enter caller and callee:");
        for (int i = 0; i < m; i++) {
            invocations[i][0] = sc.nextInt();
            invocations[i][1] = sc.nextInt();
        }

        RemainingMethods obj = new RemainingMethods();
        List<Integer> result = obj.remainingMethods(n, k, invocations);

        System.out.println("Remaining Methods: " + result);

        sc.close();
    }
}