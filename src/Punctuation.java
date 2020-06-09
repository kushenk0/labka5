public class Punctuation extends SentenceMember{
    private char Sign;
    public Punctuation (String sign){
        Sign = sign.charAt(0);
    }

    @Override ///перевизначаю метод
    public int length() {
        return 1;
    }
    @Override
    public String str() {
        return "" + Sign;
    }
}