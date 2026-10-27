import sys
import unittest
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[3] / "main" / "java" / "HashTable"))

from Q2506 import Q2506


class TestQ2506(unittest.TestCase):
    def setUp(self):
        self.solution = Q2506()

    def test_examples(self):
        cases = (
            (["aba", "aabb", "abcd", "bac", "aabc"], 2),
            (["aabb", "ab", "ba"], 3),
            (["nba", "cba", "dba"], 0),
        )
        for words, expected in cases:
            with self.subTest(words=words):
                self.assertEqual(self.solution.similarPairs(words), expected)

    def test_single_word(self):
        self.assertEqual(self.solution.similarPairs(["abc"]), 0)

    def test_character_order_does_not_matter(self):
        self.assertEqual(self.solution.similarPairs(["abc", "bca", "cab"]), 3)

    def test_character_frequency_does_not_matter(self):
        self.assertEqual(self.solution.similarPairs(["a", "aa", "aaa", "aaaa"]), 6)

    def test_different_character_sets(self):
        self.assertEqual(self.solution.similarPairs(["ab", "ac", "bc", "abc"]), 0)

    def test_interleaved_groups(self):
        words = ["ab", "abc", "ba", "xyz", "bca", "aab", "zyx", "d"]
        # Three pairs in the {a, b} group, one each in {a, b, c} and {x, y, z}.
        self.assertEqual(self.solution.similarPairs(words), 5)

    def test_many_identical_words(self):
        self.assertEqual(self.solution.similarPairs(["abc"] * 100), 4950)


if __name__ == "__main__":
    unittest.main()
