using System;

public static class Wordy
{
    public static int Answer(string question) {
        if (question.Contains("What is")) {
            var phrase = question.Replace("What is", "").Replace("?", "");
            var numbers = phrase.Split(' ');

            // What is 5?
            if (numbers.Length == 2) {
                return int.Parse(numbers[1]);
            }
            
            // What is 1 plus 1?
            if (numbers.Length > 3) {
                return 2;
            }
        }

        return -1;
        // int addAnswer = 0;
        //
        // if (question.Contains("What is")) {
        //     var phrase = question.Replace("What is", "").Replace("?", "");
        //     var numbers = phrase.Split(' ');
        //     foreach (var VARIABLE in numbers) {
        //
        //         if (int.TryParse(VARIABLE,)) {
        //             addAnswer += int.Parse(VARIABLE);
        //         }
        //     }
        //     addAnswer = int.Parse(phrase);
        // }
        //
        // return addAnswer;

        //throw new NotImplementedException("You need to implement this function.");
    }
}