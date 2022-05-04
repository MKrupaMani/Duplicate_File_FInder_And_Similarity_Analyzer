import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetSimilarityPercent {
    public static String main(String[] args) throws IOException {
        String path1 = args[0];
        String path2 = args[1];
        char[] file1 = ReadFileToCharArray(path1);
        char[] file2 = ReadFileToCharArray(path2);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder matchedCharacters = new StringBuilder();

        for (int i = 0; i < file1.length; i++) {
            sb1.append(file1[i]);
        }

        for (int i = 0; i < file2.length; i++) {
            sb2.append(file2[i]);
        }
        int totalPreviousLength = sb1.length() + sb2.length();

        matchedCharacters = checkSimilarity(sb1, sb2);

        double percent = (double)((matchedCharacters.length() * 2) * 100) / totalPreviousLength;
        double roundOff = (double) Math. round(percent * 100) / 100;
        System.out.println(matchedCharacters);
        return matchedCharacters.length() + " "+roundOff;
    }

    private static StringBuilder checkSimilarity(StringBuilder sb1, StringBuilder sb2) {
        StringBuilder matchedCharacters = new StringBuilder();
        int start = 0;
        while(start < sb1.length()){
            char ch = sb1.charAt(start);
            boolean flag = true;
            int start2 = 0;
            while(start2 < sb2.length()){
                if(ch == sb2.charAt(start2)){
                    sb1.deleteCharAt(start);
                    sb2.deleteCharAt(start2);
                    matchedCharacters.append(ch);
                    flag = false;
                    break;
                }
                start2++;
            }
            if(flag){
                start++;
            }
        }
        return matchedCharacters;
    }


    public static char[] ReadFileToCharArray(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        BufferedReader bufferedReader = Files.newBufferedReader(path);

        String finalString = "";
        String curLine;
        while ((curLine = bufferedReader.readLine()) != null) {
            String temp = curLine.replaceAll("\\s+","");
            finalString += temp;
        }

        return finalString.toCharArray();
    }
}
