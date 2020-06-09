import java.util.Scanner;
public class Main_tasks {
    private int word_length;
    private Sentence [] array_questions;
    private String []result_w;

    private void scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть довжину слів, які треба вивести із питальних речень: ");
        try {
            word_length = scanner.nextInt();
        } catch (Exception exception) {
            System.out.println("\nВиникла помилка: " + exception);
        }
    }


    private void array_questions(Text t) {
        int ask_count = 0;
        for (int i = 0; i < t.sentences.length; i++) {
            if (t.sentences[i].sentenceMmembers[t.sentences[i].sentenceMmembers.length - 1].str().equals("?")) {
                ask_count += 1;
            }
        }
        array_questions = new Sentence[ask_count];
        int k = 0;
        for (int i = 0; i < t.sentences.length; i++) {
            if (t.sentences[i].sentenceMmembers[t.sentences[i].sentenceMmembers.length-1].str().contains("?")) {
                array_questions[k] = t.sentences[i];
                k+=1;
            }
        }
    }


    private void necessary_words() {
        int k =0;
        int counter = 0;
        for (int i = 0; i < array_questions.length; i++) {
            for (int j = 0; j < array_questions[i].sentenceMmembers.length; j++) {
                if ((array_questions[i].sentenceMmembers[j] instanceof Word)) { /// за допомогою instanceof перевіряю чи був там об'єкт створений на онові класу Word
                    counter += 1;
                }
            }
        }

        result_w = new String[counter];
        for (int i = 0; i < array_questions.length; i++) {
            for (int j = 0; j < array_questions[i].length(); j++) {
                outerloop: ///вирвався з вкладених циклів
                if ((array_questions[i].sentenceMmembers[j] instanceof Word)
                        &&
                        (array_questions[i].sentenceMmembers[j].length() == word_length)) {
                    for (int f = 0; f < k; f++) {
                        if (result_w[f].equals(array_questions[i].sentenceMmembers[j].str())) {
                            break outerloop; ///
                        }
                    }
                    result_w[k] = array_questions[i].sentenceMmembers[j].str();
                    k+=1;
                }
            }
        }
    }


    public void result(Text text) {
        this.scan();
        this.array_questions(text);
        this.necessary_words();
        System.out.println("\nВивід слів заданої довжини: ");
        for (int i = 0; i < result_w.length; i++) {
            if (result_w[i] == null) {
                continue;
            }
            System.out.println(result_w[i]);
        }
    }


}