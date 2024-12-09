package recursion;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'kFactorization' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY A
     */

    static List<Integer> bestPath = null;

    public static List<Integer> kFactorization(int n, List<Integer> A) {

        // Sort A for lexicographical order
        Collections.sort(A);

        // Start recursive search
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(1); // Start with 1
        findPath(1, n, A, currentPath);

        // Print the result
        if (bestPath == null) {
            return List.of(-1);
        } else {
            var temp = new ArrayList<Integer>(bestPath);
            bestPath = null;
            return temp;
        }
    }

    public static void findPath(int current, int target, List<Integer> A, List<Integer> currentPath) {
        // Base case: if we reached the target
        if (current == target) {
            if (bestPath == null || currentPath.size() < bestPath.size() ||
                    (currentPath.size() == bestPath.size() && isLexicographicallySmaller(currentPath, bestPath))) {
                bestPath = new ArrayList<>(currentPath);
            }
            return;
        }

        // If the current value exceeds the target, stop exploring this path
        if (current > target) {
            return;
        }

        // Try all possible multiplications
        for (int factor : A) {
            if (target % (current * factor) == 0) { // Only proceed if (current * factor) is a factor of the target
                currentPath.add(current * factor);
                findPath(current * factor, target, A, currentPath);
                currentPath.remove(currentPath.size() - 1); // Backtrack
            }
        }
    }

    public static boolean isLexicographicallySmaller(List<Integer> path1, List<Integer> path2) {
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            if (!path1.get(i).equals(path2.get(i))) {
                return path1.get(i) < path2.get(i);
            }
        }
        return path1.size() < path2.size();
    }
}

public class KFactorization {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.kFactorization(n, A);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
