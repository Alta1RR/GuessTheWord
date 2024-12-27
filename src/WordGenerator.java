import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordGenerator {
    private final List<String> easyWords = Arrays.asList("кот", "дом", "лес");
    private final List<String> mediumWords = Arrays.asList("яблоко", "молоко", "город", "ягода");
    private final List<String> hardWords = Arrays.asList("дипломатия", "программирование", "компьютер", "инкапсуляция");
    private String generatedWord;
    private int wordLength;

    public WordGenerator(int difficulty){
        generateWord(difficulty);
    }

    private void generateWord(int difficulty){
        Random random = new Random();
        switch (difficulty){
            case 1:
                this.generatedWord = easyWords.get(random.nextInt(easyWords.size()));
                break;
            case 2:
                this.generatedWord = mediumWords.get(random.nextInt(mediumWords.size()));
                break;
            case 3:
                this.generatedWord = hardWords.get(random.nextInt(hardWords.size()));
                break;
            default:
                System.out.println("Уровень введён неверно!");
        }

        this.wordLength = this.generatedWord.length();
    }

    public String getGeneratedWord(){
        return generatedWord;
    }
    public int getWordLength(){
        return wordLength;
    }
}
