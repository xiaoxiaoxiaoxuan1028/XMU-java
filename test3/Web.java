import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Web {
    public static void main(String[] args){
        try{
            java.net.URL url1 = new java.net.URL("https://www.xmu.edu.cn");
            int count = 1;
            Scanner input = new Scanner(url1.openStream());

            while(input.hasNext()) {
                String line = input.nextLine();

                String regex = "<a.*?/a>";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);

                while(matcher.find()) {
                    String title = ">[^<].*?[^>]</a>";
                    String href = "href=\"http://.*?\"";

                    Pattern patternTitle = Pattern.compile(title);
                    Matcher matcherTitle = patternTitle.matcher(matcher.group());
                    Pattern patternHref = Pattern.compile(href);
                    Matcher matcherHref = patternHref.matcher(matcher.group());

                    while(matcherTitle.find() && matcherHref.find()) {
                        System.out.print("[" + count + "] ");
                        ++count;
                        System.out.print(matcherTitle.group().replaceAll(">|</a>", "") + " ");
                        System.out.println(matcherHref.group().replaceAll("href=\"|\"|>", ""));
                    }

                }
            }
        }
        catch (java.net.MalformedURLException ex){
            System.out.println("Invalid URL. ");
        }
        catch(java.io.IOException ex){
            System.out.println("I/O Errors: no such file. ");
        }
    }
}
