public class Text {
    Sentence[] sentences;

    public Text(String s) {
        String[] split = s.split("((?<=[;,:\"?.!]))");
        sentences = new Sentence[split.length];
        for (int i = 0; i < split.length; i++) {
            sentences[i] = new Sentence(split[i]);
        }
    }
    public Text without_spaces() {
        String t_ext = this.str();
        for (int i = 0; i < t_ext.length(); i++) {
            if (t_ext.charAt(i) == ' ') {

                if (i+1<t_ext.length()) {
                    int j = 1;
                    while (t_ext.charAt(i + j) == ' ') {
                        t_ext = t_ext.substring(0, i + j) + "" + t_ext.substring(i + j + 1);

                    }
                }
            }
        }
        return new Text(t_ext);
    }
    public String str() {
        String result = "";
        for (int i = 0; i < sentences.length; i++) {
            result += sentences[i].str();
        }
        return result;
    }
    public void print() {
        System.out.println(this.str());
    }
}