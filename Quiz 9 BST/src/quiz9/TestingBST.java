package quiz9;

import quiz9.BST;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestingBST {


    public static String randomString(){
        StringBuilder str=new StringBuilder();

        for(int i=0;i< (int) (Math.random()*5)+5;i++){
            char c = (char) (Math.random()*74);
            c+='0';
            str.append(c);
        }
        return str.toString();
    }

    public static List<String> addRand(BST bst, int n){
        List<String> stringsAdded = new ArrayList<>();
        for(int i=0;i<n;i++){
            String string = randomString();
            stringsAdded.add(string);
            bst.insert(string);
        }
        return stringsAdded;
    }
    public static void testSize(BST bst, List<String> strs){
        int size = bst.size();
        if(size!=strs.size()){
            System.err.println("Invalid size!");
        }
        int n = (int) (Math.random()*50);
        strs.addAll(addRand(bst,n));
        size = bst.size();
        if(size!=strs.size()){
            System.err.println("Invalid size!");
        }
    }
    public static void testContains(BST bst, List<String> strs){
        Set<String> strsSet = new HashSet<>(strs);

        for(int i=0;i<strs.size();i++){
            if(!bst.contains(strs.get(i))){
                System.err.println("should contain!");
            }
        }
        for(int i=0;i<100;i++){
            String s = randomString();
            if(!strsSet.contains(s) && bst.contains(s)){
                System.err.println("should not contain!");
            }
        }
    }
    public static void testDelete(BST bst, List<String> strs){
        int deleteNum = strs.size()/4;
        for(int i=0;i<deleteNum;i++){
            String randString = strs.get((int) (Math.random()*strs.size()));
            bst.delete(randString);
            strs.remove(randString);
            if(bst.contains(randString)){
                System.err.println("Deletion didn't work!");
            }
        }

        testSize(bst, strs);
        testContains(bst,strs);


    }


    public static void main(String... args){
        BST bst = new BST();

        List<String> strs = addRand(bst,100);
        testContains(bst,strs);
        testSize(bst,strs);
        testDelete(bst,strs);


        BSTInOrderIterator it = new BSTInOrderIterator(bst.root);
        while(it.hasNext()){
            System.out.println(it.next()+" ");
        }
    }
}
