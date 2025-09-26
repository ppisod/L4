
public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck (String i) {
        char[] d = i.toCharArray();
        int indents = 0;
        char open = '(';
        char closed = ')';
        for (char c: d) {
            if (c == open) {
                indents++;
            } else if (c == closed) {
                indents--;
            }
            if (indents < 0) {
                return false;
            }
        }
        return indents == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger (int n) {
        int buffer = n;
        StringBuilder d = new StringBuilder();
        while (buffer != 0) {
            int mod = buffer % 10;
            d.append(mod);
            buffer/=10;
        }
        return d.toString();
    }

    // 3. encryptThis
//    public static String encryptThis (String n) {
//        String[] d = n.trim().split("\\s+");
//        StringBuilder result = new StringBuilder();
//        for (String w: d) {
//            char[] p = w.toCharArray();
//            String bffr = ""; bffr += (int) p[1]; // number
//            char q = p[p.length - 1]; p[p.length - 1] = p[1]; p[1] = q; // swap
//            char[] offset = new char[p.length - 1];
//            System.arraycopy(p, 1, offset, 0, offset.length);
//            bffr += Arrays.toString(offset);
//            result.append(bffr).append(" ");
//
//        }
//        return result.toString();
//    }

    public static String encryptThis (String n) {
        if (n == null || n.isEmpty()) {return "";}

        String[] words = n.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            if (word.isEmpty()) {continue;}
            builder.append((int) word.charAt(0));
            if (!(word.length() > 1)) {builder.append(" "); continue;}
            // +last char
            // +middle [only if the word is bigger than 2c]
            // +second char
            if (word.length() > 2) {
                builder.append(word.charAt(word.length()-1))
                        .append(word, 2, word.length()-1)
                        .append(word.charAt(1));
            } else {
                builder.append(word.charAt(word.length()-1));
            }
            builder.append(" ");
        }
        String result = builder.toString();
        return result.trim();
    }

    // 4. decipherThis
//    public static String decipherThis (String n) {
//        String[] d = n.trim().split("\\s+");
//        StringBuilder result = new StringBuilder();
//        for (String w: d) {
//            // find number
//            char[] p = w.toCharArray();
//            String numberString = "";
//            int i = 0;
//            for (char c: p) {
//                if (c >= '0' && c <= '9') {numberString += c;i++;} else {break;}
//            }
//            char number = Character.highSurrogate(Integer.getInteger(numberString));
//            // shift array
//            char[]p2=new char[p.length-1];System.arraycopy(p,i+1,p2,0,p2.length);
//
//            String newWord = number + Arrays.toString(p2);
//
//            // shuffle
//            char[]p3=newWord.toCharArray();char k=p3[p3.length-1];p3[p3.length-1]=p[1];p[1]=k;
//            result.append(p3).append(" ");
//
//        }
//        return result.toString();
//    }
    public static String decipherThis (String n) {
        if (n == null || n.isEmpty()) {return "";}
        String[] encryptedWords = n.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String word : encryptedWords) {
            if (word.isEmpty()) continue;
            // loop over
            StringBuilder num = new StringBuilder();
            int i;
            for (i = 0; i < word.length() - 1; i++) {
                if (!(Character.isDigit(word.charAt(i)))) {
                    break;
                }
                num.append(word.charAt(i));
            }
            char First = (char) Integer.parseInt(num.toString());
            builder.append(First);
            String nwd = First +
                    // +last char
                    // +middle
                    // +second char (same thing)
                    // >i is the index where the number ends
                    word.substring(i);
            if (nwd.length() > 2) {
                builder.append(nwd.charAt(nwd.length()-1))
                        .append(nwd, 2, nwd.length()-1)
                        .append(nwd.charAt(1));
            } else {
                builder.append(nwd.charAt(nwd.length()-1));
            }
            builder.append(" ");
        }
        String result = builder.toString();
        return result.trim();
    }

}