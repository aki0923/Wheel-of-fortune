package myProjects;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class WheelOfFortune {
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> userNameList = new ArrayList<>();
    static ArrayList<String> wordsExplanation = new ArrayList<>();
    static ArrayList<String> wordsList = new ArrayList<>();


    static int amountOfPlayers = 0;
    static int userNameListSize = 0;
    public static void callIntroduction() {
        System.out.println(YELLOW + "Добро пожаловать в Поле Чудес!");
        System.out.println(YELLOW + "Сегодня мы узнаем кто самый интеллектуальный среди вас. Правила очень просты: первый кто отгадает загаданное слово тот выигрывает!");
        System.out.println("*   *   *   *   *   *   *   *");

        System.out.println(YELLOW + "Сколько же людей собралось сегодня играть?");
        amountOfPlayers= sc.nextInt();

        for (int i = 0; i < amountOfPlayers; i++) {
            System.out.println(YELLOW + "Здравствуйте, как вас зовут?");
            userNameList.add(sc.next());
        }
        userNameListSize = userNameList.size();
        setRandomQueue(userNameList);
    }
    public static void setRandomQueue(ArrayList<String> userNameList) {
        Collections.shuffle(userNameList);
    }

    public static void rules(String wonderedWord, String wonderedWordExplanation ){

        System.out.println("Напоминаю правила! Слово имеет 1000 очков, за каждую правильно отгаданную букву вам начисляются очки");
        System.out.println("Если вы решитесь отгадать слово полностью: за правильную попытку вы сразу выигрываете, а если нет то извините");
        System.out.println("Отлично! Тогда начинаем нашу игру!");
        System.out.println("Загаданное слово состоит из " + wonderedWord.length() + " букв");
        System.out.println(wonderedWordExplanation);
    }


    public static void play(String wonderedWord, String wonderedWordExplanation) {
        String input;

        char[] charArrayOfWonderedWord = wonderedWord.toCharArray();
        String[] arrayOfWonderedWord = new String[wonderedWord.length()];

        for (int i = 0; i < arrayOfWonderedWord.length; i++) {
            arrayOfWonderedWord[i] = charArrayOfWonderedWord[i] + "";
        }

        String[] arrayOfHiddenWord = new String[wonderedWord.length()];
        ArrayList<Integer> usersScoreList = new ArrayList<>(userNameList.size());

        for (int i = 0; i < arrayOfWonderedWord.length; i++) {
            System.out.print(arrayOfWonderedWord[i] + " ");
        }
        for (int i = 0; i < arrayOfWonderedWord.length; i++) {
            arrayOfHiddenWord[i] = " [ ] ";
        }
        int numberOfLettersInWonderedWord = wonderedWord.length();
        int totalScore = 1000;

        while(numberOfLettersInWonderedWord != 0){

            input = sc.nextLine();
            boolean inputContainsLetterOfWonderedWord = wonderedWord.contains(input);
            boolean inputIsLetter = input.length() == 1;

            if(inputIsLetter){
                if(inputContainsLetterOfWonderedWord){
                    for (int i = 0; i < arrayOfWonderedWord.length; i++) {
                        if(arrayOfWonderedWord[i].equals(input)){
                            arrayOfHiddenWord[i] = " " + arrayOfWonderedWord[i] + " ";
                            numberOfLettersInWonderedWord--;
                            int userScore = usersScoreList.get(i);
                            userScore += 100;
                            usersScoreList.add(i, userScore);
                        }

                    }
                }
            }
            for (int i = 0; i < arrayOfWonderedWord.length; i++) {
                System.out.print(arrayOfHiddenWord[i]);
            }
        }



    }


    public static void main(String[] args) {
        wordsList.add( "кенгуру");wordsList.add("бумага");wordsList.add( "пряник");wordsList.add( "фарфор");wordsList.add( "бетон");wordsList.add( "замок");wordsList.add("телеграф");wordsList.add("кислород");wordsList.add("велосипед");wordsList.add("космос");
        wordsExplanation.add("Любой современный человек знает, как на языке австралийских аборигенов звучит фраза “Я тебя не понимаю”.");
        wordsExplanation.add("В древнем Китае размоченную кору тутового дерева расщепляли на тонкие листы и варили в растворе извести 2 часа. Затем полученную массу разбивали молотками, добавляли в неё клей, заливали водой и пропускали сквозь сито. Массу, осевшую в сите, опрокидывали на доску, прессовали и просушивали. Так в древнем Китае получали то, чем мы пользуемся сейчас каждый день.");
        wordsExplanation.add("На Руси этот продукт пряный, необычного вкуса, занимал почётное место и в свадебном угощении и поминальном обряде. Он был очень сладок и дорог. О каком продукте идёт речь?");
        wordsExplanation.add("Это изобретение было сделано в древнем Китае. Секрет изготовления хранился под страхом смертной казни.");
        wordsExplanation.add(" Древнейшие каменные здания возводились из обтёсанных каменных глыб, а это изобретение позволило зодчим древнего Рима возвести шедевры архитектуры, поражавшие воображение и их современников и туристов наших дней.");
        wordsExplanation.add("Этот предмет изобрели в Древнем Египте. Тогда 1он полностью изготовлялся из дерева. По идее египетских мастеров в 19 веке Линиус Йейл изготовил современную металлическую модель, сохранив полностью принцип действия. У нас он обычно называется “английским”.");
        wordsExplanation.add("В конце 18 века француз Клод Шапп изобрёл систему, название которой переводится как “пишу на расстоянии”. Эта система включала в себя цепь построенных на вершинах холмов башен. На этих башнях устанавливали конструкции с двумя длинными планками, способными принимать 49 различных положений. Сегодня этим словом называется совсем другая “конструкция”.");
        wordsExplanation.add("В 1744 году английский химик Джозеф Пристли заметил, что при нагревании окиси ртути выделяется газ. Если поднести к нему свечу, пламя вспыхивает ярче. В те времена учёные полагали, что при горении вещества теряют особую субстанцию – “флогистон” (от греч. “пламя”). Пристли назвал открытый им газ “обезфлогистоженным воздухом”. Как этот газ называют современные химики?");
        wordsExplanation.add("Что раньше называли “костотрясом”, “пауком”, а теперь называют “быстрой ногой”?");
        wordsExplanation.add("Это слово в переводе с греческого языка означает “украшенный мир, прекрасно устроенный мир”. А в том значении, к которому мы привыкли, его впервые стал употреблять Пифагор.");


        callIntroduction();


        int wonderedIndex = random.nextInt(wordsList.size());
        String wonderedWord = wordsList.get(wonderedIndex);
        String wonderedWordExplanation = wordsExplanation.get(wonderedIndex);
        rules(wonderedWord, wonderedWordExplanation);
        play(wonderedWord, wonderedWordExplanation);

    }
}
