package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: huangd
 * Date: 2/18/13
 * Time: 11:13 AM
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> justifiedText = new ArrayList<String>();
        boolean isFirstWord = true;
        int lineStartIndex = 0;
        int spaceUsed = 0;
        for (int i = 0; i < words.length; ++i) {
            if (isFirstWord) {
                lineStartIndex = i;
                isFirstWord = false;
                spaceUsed += words[i].length();
            } else {
                if (spaceUsed + words[i].length() + 1 <= L) {
                    spaceUsed = spaceUsed + words[i].length() + 1;
                } else {
                    isFirstWord = true;
                    spaceUsed = 0;
                    justifiedText.add(justify(Arrays.copyOfRange(words, lineStartIndex, i), L));
                    --i;
                }
            }
        }
        justifiedText.add(justifyLastLine(Arrays.copyOfRange(words, lineStartIndex, words.length), L));
        return justifiedText;
    }

    private String justifyLastLine(String[] words, int L) {
        int totoalSpace = L;
        String line = words[0];
        totoalSpace -= words[0].length();
        for (int i = 1; i < words.length; ++i) {
            line = line + " " + words[i];
            totoalSpace = totoalSpace - words[i].length() - 1;
        }
        return line + getSpace(totoalSpace);
    }

    private String justify(String[] words, int L) {
        int totalSpace = L;
        for (String word : words) {
            totalSpace -= word.length();
        }
        if (words.length == 1) {
            String space = getSpace(totalSpace);
            return words[0] + space;
        } else {
            int minGap = totalSpace / (words.length - 1);
            int mod = totalSpace % (words.length - 1);
            String line = words[0];
            for (int i = 1; i < words.length; ++i, --mod) {
                if (mod > 0) {
                    line = line + getSpace(minGap + 1) + words[i];
                } else {
                    line = line + getSpace(minGap) + words[i];
                }
            }
            return line;
        }
    }

    private String getSpace(int n) {
        String space = "";
        for (int i = 0; i < n; ++i) {
            space += " ";
        }
        return space;
    }
}