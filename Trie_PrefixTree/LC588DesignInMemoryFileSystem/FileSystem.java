package Trie_PrefixTree.LC588DesignInMemoryFileSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FileSystem {
    public final int FILE = 1;
    public final int DIR = 2;
    class File{
        int type = DIR;//default is a directory file
        String name;//fileName or dirName
        StringBuilder content = new StringBuilder();//only applies to file
        HashMap<String,File> nexts = new HashMap<>();
        File(String name){
            this.name = name;
        }
    }
    class Trie{
        File root;
        Trie(){
            this.root = new File("");
        }
        File insertOrSearch(String s){
            String[] files = s.split("/");
            File cur = root;
            for(int i=1;i<files.length;++i){
                if(!cur.nexts.containsKey(files[i])){
                    cur.nexts.put(files[i],new File(files[i]));
                }
                cur = cur.nexts.get(files[i]);
            }
            return cur;
        }
    }
    public Trie t;

    public FileSystem() {
        t = new Trie();
    }

    public List<String> ls(String path) {
        File file = t.insertOrSearch(path);
        if(file.type==FILE) return List.of(file.name);
        List<String> ans = new ArrayList<>(file.nexts.keySet());
        Collections.sort(ans);
        return ans;
    }

    public void mkdir(String path) {
        t.insertOrSearch(path);
    }

    public void addContentToFile(String filePath, String content) {
        File file = t.insertOrSearch(filePath);
        file.type = FILE;
        file.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        return t.insertOrSearch(filePath).content.toString();
    }
}


