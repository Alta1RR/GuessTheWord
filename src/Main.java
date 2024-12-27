import java.util.Scanner;

public class Main {

    // Генерация массива, отслеживающего прогресс игры
    public static char[] generateProgressArr(int arrLength) {
        char[] progress = new char[arrLength];
        for (int i = 0; i < arrLength; i++) {
            progress[i] = '_';
        }
        return progress;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создание scanner для ввода с клавиатуры
        char letter;

        while (true) {
            // Выбор сложности и объявление объекта
            System.out.println("Выберете сложность от 1 до 3: ");
            int difficulty = scanner.nextInt();
            WordGenerator secretWord = new WordGenerator(difficulty);

            int countOfErrors = 0;
            boolean isProcessActive = true;
            //String secretWord = generateWord();
            char[] progressArr = generateProgressArr(secretWord.getWordLength());

            System.out.println("Слово загадано. Его длина: " + secretWord.getWordLength() + " Введите букву: ");
            while (isProcessActive) {
                letter = scanner.next().charAt(0); // Ввод буквы

                boolean foundLetter = false;
                // Цикл перебора слова по буквам и поиск совпадений по letter
                for (int i = 0; i < secretWord.getWordLength(); i++) {
                    if (secretWord.getGeneratedWord().charAt(i) == letter) {
                        System.out.println("найдена буква");
                        progressArr[i] = secretWord.getGeneratedWord().charAt(i);
                        foundLetter = true;
                    }
                }

                // в случае, если введена неверная буква
                if (!foundLetter) {
                    countOfErrors++;
                    System.out.println("Такой буквы нет! У вас осталось " + (secretWord.getWordLength() - countOfErrors) + " попыток. Введите другую букву: ");
                    if(countOfErrors == secretWord.getWordLength()){
                        System.out.println("Вы проиграли! Ваше слово: " + secretWord.getGeneratedWord()+ " вы допустили " + countOfErrors + " ошибок");
                        isProcessActive  = false;
                    }
                }

                // в случае победы
                System.out.println(progressArr);
                if (secretWord.getGeneratedWord().equals(String.valueOf(progressArr))) {
                    System.out.println("Победа! Количество ошибок: " + countOfErrors);
                    isProcessActive  = false;
                }
            }
        }
    }
}