
using System;

class Program
{
    static void Main()
    {
        Console.Write("Enter a string: ");
        string input = Console.ReadLine();

        Console.Write("Enter a character: ");
        char ch = Console.ReadKey().KeyChar;
        Console.WriteLine();

        int position = input.IndexOf(ch);

        int count = 0;
        foreach (char c in input)
        {
            if (c == ch)
                count++;
        }

        Console.WriteLine("Position: " + position);
        Console.WriteLine("Count: " + count);
    }
}
