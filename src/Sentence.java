public class Sentence {
    public SentenceMember[] sentenceMmembers;

    public Sentence(String s) {
        String[] split = s.split("((?<=[;,: \"?.!()])|(?=[;,: \"?.!()]))");
        sentenceMmembers = new SentenceMember[split.length];
        int j = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].isEmpty()) {
                continue;
            }
            if (split[i].contains("[") || split[i].contains("]") || split[i].contains(";")
                    || split[i].contains(",")|| split[i].contains(":")|| split[i].contains("\"")
                    || split[i].contains("?")|| split[i].contains(".")|| split[i].contains("!")
                    || split[i].contains("(")|| split[i].contains(")")) {
                sentenceMmembers[j++] = new Punctuation(split[i]);
            }
            else {
                sentenceMmembers[j++] = new Word(split[i]);
            }
        }

    }
    public String str() {
        String result = "";
        for (int i = 0; i < sentenceMmembers.length; i++) {
            result += sentenceMmembers[i].str();
        }
        return result;
    }
    public int length() {
        return sentenceMmembers.length;
    }
}