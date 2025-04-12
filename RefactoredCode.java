
import java.io.*;
import java.util.*;

public class BogglePlayer {

    static final int SIZE = 26;
    static final int M = 4;
    static final int N = 4;

    static class TrieNode {
        TrieNode[] children = new TrieNode[SIZE];
        boolean isEndOfWord = false;
    }

    static TrieNode root = new TrieNode();
    static HeapPriorityQueue<Integer, Word> heapPQ = new HeapPriorityQueue<>();
    static Set<String> uniqueWords = new HashSet<>();

    public BogglePlayer(String wordFile) {
        buildTrie(wordFile);
    }

    public void buildTrie(String wordFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(wordFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addWordToTrie(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addWordToTrie(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'A';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public Word[] getWords(char[][] boggle) {
        Word[] myWords = new Word[20];
        boolean[][] visited = new boolean[M][N];
        TrieNode currChild = root;
        StringBuilder str = new StringBuilder();
        heapPQ.insert(0, new Word(""));

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char current = boggle[i][j];
                if (currChild.children[current - 'A'] != null) {
                    str.append(current);
                    if (current == 'Q') str.append('U');
                    dfs(currChild.children[current - 'A'], boggle, i, j, visited, str.toString(), new ArrayList<>());
                    str.setLength(0);
                }
            }
        }

        int copyCount = Math.min(heapPQ.size(), 20);
        for (int i = 0; i < copyCount; i++) {
            myWords[i] = heapPQ.removeMin().getValue();
        }

        return myWords;
    }

    private void dfs(TrieNode curr, char[][] boggle, int i, int j, boolean[][] visited, String word, List<Location> path) {
        visited[i][j] = true;
        path.add(new Location(i, j));

        if (curr.isEndOfWord && word.length() > 2 && uniqueWords.add(word)) {
            if (heapPQ.size() == 20) heapPQ.removeMin();
            Word w = new Word(word);
            w.setPath(new ArrayList<>(path));
            heapPQ.insert(word.length(), w);
        }

        int[] dR = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dC = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int newRow = i + dR[k], newCol = j + dC[k];
            if (isSafe(newRow, newCol, visited)) {
                char nextChar = boggle[newRow][newCol];
                if (curr.children[nextChar - 'A'] != null) {
                    String nextWord = nextChar == 'Q' ? word + "QU" : word + nextChar;
                    dfs(curr.children[nextChar - 'A'], boggle, newRow, newCol, visited, nextWord, path);
                }
            }
        }

        visited[i][j] = false;
        path.remove(path.size() - 1);
    }

    private boolean isSafe(int i, int j, boolean[][] visited) {
        return (i >= 0 && i < M && j >= 0 && j < N && !visited[i][j]);
    }
}
