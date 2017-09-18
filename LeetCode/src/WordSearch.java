import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tang on 2017/9/12.
 */
public class WordSearch {

    boolean visited[][];

    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0) return false;
        visited=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++)
            for (int j=0;j<board[i].length;j++){
                if((word.charAt(0) == board[i][j])&&search(board, word, i, j, 0))
                    return true;
            }
        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        if(board==null||board.length==0) return null;
        List<String> result=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(exist(board,words[i])&&!result.contains(words[i]))
                result.add(words[i]);
        }
        return result;
    }

    public boolean search(char[][] board,String word,int i,int j,int index){
        if(index == word.length()){
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public Trie buildTrie(String[] words){
        Trie root = new Trie();
        for (String w : words) {
            Trie p=root;
            char[] array=w.toCharArray();
            for(char c:w.toCharArray()){
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new Trie();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
    class Trie{
        Trie[] next=new Trie[26];
        String word;
    }

    public static void main(String[] args){
        char[][] board=new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words={"oath","pea","eat","rain"};
        System.out.println(new WordSearch().exist(board,"ABCCED"));
        System.out.println(new WordSearch().findWords(board,words));
    }
}
