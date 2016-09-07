package leetcode;


import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangbenpeng on 9/3/16.
 *
 * @author benpeng.jiang
 * @version 1.0.0
 */
public class Solution {
    public static void main(String[] args) {
        String str =  " ";
        Answer answer = new Answer();
        System.out.println(answer.reverseWords(str));
    }

    static class Answer {


        private List<Pair<Integer, Integer>> findWorkIndex(String s) {
            List<Pair<Integer, Integer>> pair = new ArrayList<>();
            for (int i = 0; i < s.length();) {
                int start = getFirstIndex(s, i);
                int end = getLastIndex(s, start);
                pair.add(new Pair<>(start, end));
                i = end + 1;
            }
            return pair;
        }

        private int getFirstIndex(String s, int start) {
            for (int i = start; i < s.length(); i++) {
                if (!Character.isSpaceChar(s.charAt(i))) {
                    return i;
                }
            }
            return s.length() - 1;
        }

        private int getLastIndex(String s, int start) {
            for (int i = start; i < s.length() - 1; i++) {
                if (Character.isSpaceChar(s.charAt(i + 1))) {
                    return i;
                }
            }
            return s.length() - 1;
        }

        public String reverseWords(String s) {
            List<Pair<Integer, Integer>> wordsIndex = findWorkIndex(s);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = wordsIndex.size() - 1; i >= 0; i--) {
                Pair<Integer, Integer> pair = wordsIndex.get(i);
                if (pair.fst == pair.snd && Character.isSpaceChar(s.charAt(pair.fst))) {
                    continue;
                }
                stringBuilder.append(s.substring(pair.fst, pair.snd + 1));
                if(i > 0) {
                    stringBuilder.append(' ');
                }
            }
            return stringBuilder.toString();
        }
    }
}
