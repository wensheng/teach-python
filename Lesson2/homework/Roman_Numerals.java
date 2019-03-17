import java.util.*;

class Roman_Numerals{
  
  public static void main(String[] args){
    Scanner console = new Scanner(System.in);
    // 1 
    String[] s = {"Hello", "Goodbye", "Computer", "Science", "Um", "Do", "What", "Now"};
    
    // 2. Print the number of elements in s to the console
    System.out.println("The length of s is: " + s.length);
    
    // 3. Print the first letter of each String in s, separated by a space and on the same line
    int i;
    for(i=0; i<s.length; i++){
      System.out.print(s[i].charAt(0) + " ");
      //System.out.print(s[i].substring(0, 1) + " ");
    }
    System.out.println("");
    
    // 4. Print the number of Strings in s that end in an "e"
    int count = 0;
    for(i=0; i<s.length; i++){
      //int slen = s[i].length();
      //if(s[i].substring(slen-1, slen).equals("e")){
      if(s[i].endsWith("e")){
        count++;
      }
    }
    System.out.println("The number of strings that ends in 'e' is: " + count);
    
    // 5. Print the total number of characters in all the Strings in s to the console
    count = 0;
    for(String ss: s){ //google "java for each"
      count += ss.length();
    }
    System.out.println("The total number of characters in s is: " + count);
    
    // 6. Print "Two length 7!" if at least two Strings in s have a length of 7 or more, "Under 2 length 7" if not
    count = 0;
    for(String ss: s){
      if(ss.length() >= 7){
       count++;
      }
    }
    
    if(count>=2){
      System.out.println("Two length 7!");
    }else{
      System.out.println("Under 2 length 7");
    }
    
    // 7. (Riddle) Someone at a party introduces you to your mother's only sister's husband's sister in law.  
    //    He has no brothers.  What do you call this lady?
    // why would anyone introduce you to your mother?
    
    // 8. Print the number of Strings in s that contain an "e".
    count = 0;
    for(String ss: s){
      if(ss.indexOf("e")!=-1){
       count++;
      }
    }
    System.out.println("The number of strings in s that contain 'e' is: " + count);
    
    // 9. Print "No o's!" if none of the Strings in s contain an "o" character, and "At least one o" if not.
    // skipped
    
    // 10 magic-8 ball
    String[] magic8s = {
      "It is certain", 
      "It is decidedly so",
      "Without a doubt",
      "Yes - definitely",
      "You may rely on it",
      "As I see it, yes",
      "Most likely",
      "Reply hazy, try again",
      "Ask again later",
      "Better not tell you now",
      "Cannot predict now",
      "Concentrate and ask again",
      "Don't count on it",
      "My reply is no",
      "My sources say no",
      "Outlook not so good",
      "Very doubtful"};
    System.out.print("Please ask your question: ");
    console.nextLine();
    Random rand = new Random();
    i = rand.nextInt(magic8s.length);
    System.out.println("Magic-8 ball answers: " + magic8s[i]);
    
    // Roman numeral conversion app
    System.out.print("Enter a number less than 4000 >>>");
    try{
      i = console.nextInt();
    }catch(InputMismatchException e){
      System.out.println("invalid input");
      return;
    }
    if(i>4000 || i<1){
      System.out.println("Number must be in (1, 4000)");
    }
    else{
      System.out.println("The roman numeral for the number " + i + " is: " + roman_num(i));
    }
  }
  
  public static String roman_num(int n){
    final int[] NUMBERS = {  1000,  900, 500,  400, 100,   90,  50,   40,  10,    9,   5,    4,  1};
    final String[] LETTERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int i;
    String rn = "";
    while(n>0){
      for(i=0; i<NUMBERS.length; i++){
        if(NUMBERS[i] <= n){
          break;
        }
      }
      rn += LETTERS[i];
      //System.out.println(rn);
      n -= NUMBERS[i];
    }
    return rn;
  }
}