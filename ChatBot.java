
/**
 * ZachowBot.java
 * @author Josh Mathew, Scott Comin
 * ZachowBot is a chatbot that responds to questions inputed by the user
 */
public class ZachowBot
{
    /**
      * Method that returns a greeting to the user
      * @return greeting
      */
    public static String Greeting()
    {
        return "So today guys... you will be asking me questions";
    }
    
    /**
     * @parameter input: the user input
     * @return a output based on the if statements
     */
    public String Response(String input)
    {
        String output = "";
        input= input.trim();
        if (input.length()<1)
        {
            output="Ask me a question";
        }else if(input.indexOf("teach")>=0)
        {
            output="I teach physics ";
        }else if(input.indexOf("joke")>=0)
        {
            output="Have you heard of that new anti-gravity textbook?\nIt's impossible to put down";
        }else if(input.indexOf("help")>=0)
        {
            output="Let me explain it again";
        }else if(input.indexOf("restroom")>=0)
        {
            output="Sure just get a pass";
        }else if(input.indexOf("due")>=0)
        {
            output="By the end of class";
        }else if(input.indexOf("work")>=0)
        {
            output="Then it should be correct";
        }else
        {
            // Look for a two word (you <something> me)
            // pattern
            int psn = findKeyword(input, "I", 0);

            if (psn >= 0
                    && findKeyword(input, "answer", psn) >= 0)
            {
                output = transformIAnswerStatement(input);
            }
            else
            {
            output=otherResponse();
            }
        }   
        return output;
    
    }
    /**
    //@retuns a random generic response when no keywords are found
    */
    public String otherResponse()
    {
        final int NUMBER_OF_RESPONSES = 4;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        if (whichResponse == 0)
        {
            response = "Im not sure I understand";
        }
        else if (whichResponse == 1)
        {
            response = "I don't know";
        }
        else if (whichResponse == 2)
        {
            response = "Ummm...";
        }
        else if (whichResponse == 3)
        {
            response = "Try asking Mr.Wang";
        }

        return response;
    }
    
    /**
     * @parameter statement
     * @returns a question
     * turns the users question into another question
     */
    private String transformIAnswerStatement(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        
        int psnOfI = findKeyword (statement, "I", 0);
        int psnOfAnswer = findKeyword (statement, "answer", psnOfI + 1);
        
        String restOfStatement = statement.substring(psnOfI + 1, psnOfAnswer).trim();
        return "What makes you " + restOfStatement + " answer?";
    }
        
    /**
     * @parameter statement: the string to search
     * @parameter goal: string to search for
     * @parameter startPos: position of String to begin
     * @return: index of the first occurance of the string your searching for, else -1 if not found
     * search for a word in a given string
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(
                        psn + goal.length(),
                        psn + goal.length() + 1);
            }

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0) || (before
                    .compareTo("z") > 0)) // before is not a
                                            // letter
                    && ((after.compareTo("a") < 0) || (after
                            .compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal, psn + 1);

        }

        return -1;
    }
}
