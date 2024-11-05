import java.util.Stack;

public class P66ReverseWord {

    public static String reverseWords(String sentence) {
        Stack<String> stack = new Stack<>();
        String reversedSentence = "";
        String[] words = sentence.split(" ");  // Split the sentence into words

        // Push each word onto the stack
        for (String word : words) {
            stack.push(word);
        }

        // Pop each word from the stack to form the reversed sentence
        while (!stack.isEmpty()) {
            reversedSentence += stack.pop();
            if (!stack.isEmpty()) {
                reversedSentence += " ";  // Add space between words, but not after the last word
            }
        }

        return reversedSentence;
    }

    public static void main(String[] args) {
        String sentence = "hello world";
        System.out.println("Original Sentence: " + sentence);
        System.out.println("Reversed Sentence: " + reverseWords(sentence));
    }
}

