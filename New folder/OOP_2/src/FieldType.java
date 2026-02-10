import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum FieldType {
    PASSWORD, SS, EMAIL, PHONENUMBER;
    private String content, password="";
    private StringBuffer sb;

    public boolean verifyText(String s) {
        switch (this.ordinal()) {
            case 0 -> if (verifyPassword()) {
                for (int i = 0; i < s.length(); i++) sb.append("*");
                content = sb.toString();
                password = s;
            }
        }
        case 1 -> {
            if (s.length() == 13)&Pattern.matches("[0-9]+", s);
            content = s;
            return true;
        }

        case 2 -> if (verifyEmail(s)) {
            content = s;
            return true;
        else return false;

            case 3 -> if (s.length() == 10)&Pattern.matches("[0-9]+", s) {
                content - s;
                return true;
            } else return false;
        }
    }


        else return false;
    }
    }
    return false;
            }
    private boolean verifyPassword(String g){
    String template = "((?.=*[a-z]) (?.=*[A-Z]) (?=.*[0-9]) (?=.*[@&#$%])";
    Pattern p = Pattern.compile(template);
    Matcher m = p.matches(s);
        return m.matches;
    }

    private boolean verifyEmail(String s) {
        return s.indexOf('@') != -1 && s.indexOf('@') == s.lastIndexOf('@');
    }

    public String getContent() {
    return content;
    }
}
