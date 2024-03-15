import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        System.out.println(calc(in));
    }
    public static String calc(String input)  {
        class Argument {
            String source;
            public Argument(String source){
                this.source = source;
            }
            boolean rim() {
                boolean rimCheck;
                rimCheck= (source.equals("I") || source.equals("II") || source.equals("III") || source.equals("IV") || source.equals("V") || source.equals("VI") || source.equals("VII") || source.equals("VIII") || source.equals("IX") || source.equals("X"));
                return rimCheck;
            }
            int value() {
                switch (source) {
                    case "I":
                        return 1;
                    case "II":
                        return 2;
                    case "III":
                        return 3;
                    case "IV":
                        return 4;
                    case "V":
                        return 5;
                    case "VI":
                        return 6;
                    case "VII":
                        return 7;
                    case "VIII":
                        return 8;
                    case "IX":
                        return 9;
                    case "X":
                        return 10;
                    case "1":
                        return 1;
                    case "2":
                        return 2;
                    case "3":
                        return 3;
                    case "4":
                        return 4;
                    case "5":
                        return 5;
                    case "6":
                        return 6;
                    case "7":
                        return 7;
                    case "8":
                        return 8;
                    case "9":
                        return 9;
                    case "10":
                        return 10;
                    default:
                        throw new RuntimeException("//т.к. Калькулятор работает с целыми числами от 0 до 10 и от I до X");
                }
            }
        }

        String[] arguments = input.split(" ");
        if (arguments.length != 3){
            throw new RuntimeException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        String znak = arguments[1];

        if (!(znak.equals("+") || znak.equals("-") || znak.equals("*") || znak.equals("/"))){
            throw new RuntimeException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        Argument argument1 = new Argument(arguments[0]);    //Argument(arguments[0])
        Argument argument2 = new Argument(arguments[2]);
        if (!(argument1.rim() == argument2.rim())){
            throw new RuntimeException("//т.к. используются одновременно разные системы счисления");
        }

        int answer=0;
        switch (znak){
            case "+":
                answer = argument1.value() + argument2.value();
                break;
            case "-":
                answer = argument1.value() - argument2.value();
                break;
            case "*":
                answer = argument1.value() * argument2.value();
                break;
            case "/":
                answer = argument1.value() / argument2.value();
                break;
            default:
                throw new RuntimeException("//т.к. строка не является математической операцией");
        }
        if (!argument1.rim()){
            return Integer.toString(answer);
        } else {
            if(answer>0){
                return RimNum.values()[answer].toString();
            } else {
                throw new RuntimeException("//т.к. в римской системе нет отрицательных чисел");
            }
        }
    }
    enum RimNum {
        O, I, II, III, IV, V, VI, VII, VIII, IX, X, XI, XII, XIII, XIV, XV, XVI, XVII, XVIII, XIX, XX, XXI, XXII, XXIII, XXIV, XXV, XXVI, XXVII, XXVIII, XXIX, XXX, XXXI, XXXII, XXXIII, XXXIV, XXXV, XXXVI, XXXVII, XXXVIII, XXXIX, XL, XLI, XLII, XLIII, XLIV, XLV, XLVI, XLVII, XLVIII, XLIX, L, LI, LII, LIII, LIV, LV, LVI, LVII, LVIII, LIX, LX, LXI, LXII, LXIII, LXIV, LXV, LXVI, LXVII, LXVIII, LXIX, LXX, LXXI, LXXII, LXXIII, LXXIV, LXXV, LXXVI, LXXVII, LXXVIII, LXXIX, LXXX, LXXXI, LXXXII, LXXXIII, LXXXIV, LXXXV, LXXXVI, LXXXVII, LXXXVIII, LXXXIX, XC, XCI, XCII, XCIII, XCIV, XCV, XCVI, XCVII, XCVIII, XCIX, C
    }
}