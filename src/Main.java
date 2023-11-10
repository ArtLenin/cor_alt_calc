import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите выражение: ");

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char dei;
        String[] wn;

        if (str.contains(" + ")) {
            wn = str.split(" \\+ ");
            dei = '+';
        } else if (str.contains(" - ")) {
            wn = str.split(" - ");
            dei = '-';
        } else if (str.contains(" * ")) {
            wn = str.split(" \\* ");
            dei = '*';
        } else if (str.contains(" / ")) {
            wn = str.split(" / ");
            dei = '/';
        } else {
            throw new RuntimeException("Действие не распознанно.");
        }

        if (wn[0].length()>10)
            throw new RuntimeException("Нельзя использовать больше 10 символов!");
        if (wn[1].length()>10)
            throw new RuntimeException("Нельзя использовать больше 10 символов!");
        if (Character.isDigit(str.charAt(0)))
            throw new RuntimeException("Первым агрументом выражения должна являться только строка, а не число.");

        if (dei == '*' || dei == '/') {
            if (wn[1].contains("\"")) throw new RuntimeException("Делить, умножать строку можно только на число");
        }
        for (int i = 0; i < wn.length; i++) {
            wn[i] = wn[i].replace("\"", "");
            }

        int ind;
        if (dei == '+') {
            RESULTaT(wn[0] + wn[1]);
        }
        else if (dei == '*') {
            int mt = Integer.parseInt(wn[1]);
            String res = "";
            for (int i = 0; i < mt; i++)
                res += wn[0];

            RESULTaT(res);
        }
        else if (dei == '-') {
            ind = wn[0].indexOf(wn[1]);
            if (ind == -1) {
                RESULTaT(wn[0]);
            }
        else {
            String res = wn[0].substring(0, ind);
            res += wn[0].substring(ind+wn[1].length());
            RESULTaT(res);
        }
        }
        else {
            int po = wn[0].length()/Integer.parseInt(wn[1]);
            String res = wn[0].substring(0, po);
            RESULTaT(res);
        }
    }

    public static void RESULTaT (String text){
        char[] MaxInp = text.toCharArray();

        if (MaxInp.length > 40) {
            System.out.println("\""+text.substring(0 , 40)+"..." + "\"");
        } else {
            System.out.println("\""+text+"\"");
        }

    }
}

