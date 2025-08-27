Algorithm WordAnalyzer:
    Initialize wordCount as Map<String, Integer>
    
    Function analyzeText(text):
        words = text.toLowerCase().split(" ")
        FOR each word in words
            word = cleanWord(word) // Remove punctuation
            IF word not empty THEN
                IF wordCount contains word THEN
                    INCREMENT count for word
                ELSE
                    Add word to wordCount with count 1
    
    Function displayResults():
        Sort wordCount by value descending
        FOR each entry in wordCount
            PRINT word + " → " + count
    
    Function cleanWord(word):
        Remove punctuation
        Remove special characters
        RETURN cleaned word