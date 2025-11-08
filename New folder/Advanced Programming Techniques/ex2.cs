

using System;
using System.IO;
using System.Linq;
using System.Collections.Generic;

class Program
{
    static void Main()
    {
        // arhiva
        var arhivaLines = File.ReadAllLines("arhiva.txt");

        List<int[]> arhiva = arhivaLines
            .Select(l => l.Split(' ', StringSplitOptions.RemoveEmptyEntries)
                          .Skip(1) // skip date
                          .Take(6)
                          .Select(int.Parse).ToArray())
            .ToList();

        Console.Write("Cate extrageri noi sa generez? ");
        int n = int.Parse(Console.ReadLine());

        Console.Write("Cate maxim asemanari ai voie cu ORICE veche? ");
        int limit = int.Parse(Console.ReadLine());

        Random rnd = new Random();
        List<int[]> rezultate = new List<int[]>();

        while (rezultate.Count < n)
        {
            int[] gen = Enumerable.Range(1, 49)
                         .OrderBy(x => rnd.Next())
                         .Take(6)
                         .ToArray();

            bool ok = true;
            foreach (var old in arhiva)
            {
                int same = gen.Intersect(old).Count();
                if (same > limit) { ok = false; break; }
            }

            if (ok)
            {
                rezultate.Add(gen);
                Console.WriteLine("acceptat: " + string.Join(" ", gen));
            }
        }

        using var sw = new StreamWriter("extrageri.txt");
        foreach (var r in rezultate)
            sw.WriteLine(string.Join(" ", r));
    }
}