import random

s = ["Hello", "Goodbye", "Computer", "Science", "Um", "Do", "What", "Now"]
    
# 2. Print the number of elements in s to the console
print("The length of s is: ", len(s))
    
# 3. Print the first letter of each String in s, separated by a space and on the same line
first_letters = [a[0] for a in s]
print(" ".join(first_letters))
    
# 4. Print the number of Strings in s that end in an "e"
strings_that_ends_with_e = [a for a in s if a.endswith("e")]
print("The number of strings that ends in 'e' is: ", len(strings_that_ends_with_e))

# 5. Print the total number of characters in all the Strings in s to the console
print("The total number of characters in s is: ", len("".join(s)))

# 6. Print "Two length 7!" if at least two Strings in s have a length of 7 or more, "Under 2 length 7" if not
strings_7 = [a for a in s if len(a)>=7]
if len(strings_7) >= 2:
    print("Two length 7!")
else:
    print("Under 2 length 7");

# 8. Print the number of Strings in s that contain an "e".
print("The number of strings in s that contain 'e' is: ",  len([a for a in s if 'e' in a]));

# 10 magic-8 ball
magic8s = [
      "Reply hazy, try again",
      "Ask again later",
      "Better not tell you now",
      "Cannot predict now",
      "Concentrate and ask again",
      "Don't count on it",
      "My reply is no",
      "My sources say no",
      "Outlook not so good",
      "Very doubtful"]

input("Please ask your question: ")
rand_idx = random.randrange(len(magic8s))
print("Magic-8 ball answers: " + magic8s[rand_idx])

# Roman numeral conversion app
def roman_num(n):
    rn_map = {1000: 'M',
              900: 'CM', 500: "D", 400: "CD", 100: "C",
              90: "XC", 50: "L", 40: "XL", 10: "X", 
              9: "IX", 5: "V", 4: "IV", 1: "I"};
    rn = "";
    while n > 0:
        for i in rn_map:
            if(i <= n):
                break;
        rn += rn_map[i];
        n -= i;
    return rn;

i = input("Enter a number less than 4000 >>>")
try:
    i = int(i)
except ValueError:
    exit("invalid number")

if i > 4000 or i < 1:
    print("Number must be in (1, 4000)")
else:
    print("The roman numeral for the number %d is %s" % (i,  roman_num(i)))
