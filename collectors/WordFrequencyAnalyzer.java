package collectors;

import java.util.*;
import static java.util.stream.Collectors.*;

public class WordFrequencyAnalyzer {
    public Map<String, Long> analyzeWordFrequency(String text) {
        return Arrays.stream(text.toLowerCase().split("\\s+"))
            .collect(toMap(
                word -> word,
                word -> 1L,
                Long::sum
            ));
    }

    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog";
        WordFrequencyAnalyzer analyzer = new WordFrequencyAnalyzer();
        Map<String, Long> frequency = analyzer.analyzeWordFrequency(text);
        
        frequency.forEach((word, count) -> 
            System.out.println(word + ": " + count));
    }
}