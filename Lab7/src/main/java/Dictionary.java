import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Dictionary  {
    List<String> words = new ArrayList<>();

    Dictionary() {
        try {
            FileReader fileReader = new FileReader(("C:\\Users\\ciobo\\Desktop\\facultate\\an_2\\sem_2\\PA\\Laboratoare\\PA_2022_2B4_CIOBOTARU_COSMIN\\Lab7\\src\\main\\resources\\words.txt"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                words.add(currentLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isWord(String str) {
            for( String word :words)
            {
                if(word.compareTo(str)==0){
                    return true;
                }
            }
            return false;
    }

}
