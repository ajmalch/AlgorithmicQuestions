package com.example;


/*
  Write a function that takes in a non-empty string and returns its run-length encoding.
  From Wikipedia, "run-length encoding is a form of lossless data compression in which runs of data are stored as a single data value and count,
  rather than as the original run." For this problem, a run of data is any sequence of consecutive, identical characters.
  So the run "AAA" would be run-length-encoded as "3A".
  To make things more complicated, however, the Input string can contain all sorts of special characters, including numbers.
  And since encoded data must be decodable, this means that we can't naively run-length-encode long runs.
  For example, the run "AAAAAAAAAAAA" (12 A s), can't nalvely be encoded as "12A",
  since this string can be decoded as either "AAAAAAAAAAAA" or "1AA".
  Thus, long runs (runs of 10 or more characters) should be encoded in a split fashion; the aforementioned run should be encoded as “9A3A”
  */

class StringCompression2 {

    //O(n) time complexity and O(1) space complexity
    public String runLengthEncoding(String string) {

        int count = 0;
        char currChar = string.charAt(0);

        StringBuilder sb = new StringBuilder();

        for(char c: string.toCharArray()){

            if(count==9 || currChar != c){
                sb.append(count);
                sb.append(currChar);
                count = 0;
                currChar = c;
            }
            count++;
        }

        sb.append(count);
        sb.append(currChar);

        return sb.toString();
    }
}
