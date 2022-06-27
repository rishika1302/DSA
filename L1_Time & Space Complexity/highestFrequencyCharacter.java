// import java.util.*;

// public class highestFrequencyCharacter {
//     public static void main(String[] args)
//     {
//         Scanner scn = new Scanner(System.in);
//         String str = scn.nextLine();

//         int[] farr = new int[26]; //integer array of size 26 to store frequency of characters, each has value of 0 as default at first.
//         for(int i=0;i<str.length();i++)
//         {
//             char ch = str.charAt(i); //checking frequency of each character in the string
//             int idx = ch - 'a'; //getting index of the character we checked in the farr
//             farr[idx]++; //increase freqeuncy of the character in the farr
//         }
//         //to find maximum frequency element in the frequency array
//         int maxIdx = 0; 
//         for(int i=0;i<farr.length;i++)
//         {
//             if(farr[i] > farr[maxIdx]){
//                 maxIdx = i; //this gives i as the maxIdx = index at which that character is present which has maximum frequency in the string
//             }
//         }
//         char maxFreqChar = (char)(maxIdx+'a'); 
//         //maxIdx+'a' = to get the ascii of character with max frequency
//         //we want character from the ascii above => typecast int into char : (char)(maxIdx+'a')
//         //storing this character int a char variable as int got typecasted to char
//         System.out.println("Character with maximum frequency is : "+maxFreqChar);
//     }
// }
