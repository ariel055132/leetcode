import sys
import unittest
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[3] / "main" / "java" / "Stack"))

from Q921 import Q921


class TestQ921(unittest.TestCase):
    def setUp(self):
        self.solution = Q921()

    def test_balanced_parentheses(self):
        for s in ("()", "(())", "()()", "(()())", "((()))()"):
            with self.subTest(s=s):
                self.assertEqual(self.solution.minAddToMakeValid(s), 0)

    def test_empty_string(self):
        self.assertEqual(self.solution.minAddToMakeValid(""), 0)

    def test_only_unmatched_parentheses(self):
        for s, expected in (("(", 1), (")", 1), ("(((", 3), (")))", 3)):
            with self.subTest(s=s):
                self.assertEqual(self.solution.minAddToMakeValid(s), expected)

    def test_mixed_parentheses(self):
        cases = (
            ("())", 1),       # One unmatched closing parenthesis.
            ("(()", 1),       # One unmatched opening parenthesis.
            (")(", 2),        # Equal counts do not guarantee valid ordering.
            ("()))((", 4),    # Unmatched parentheses on both sides.
            ("())(()", 2),    # Valid pairs mixed with unmatched parentheses.
            ("()))((()", 4),  # Matching later pairs preserves earlier deficits.
        )
        for s, expected in cases:
            with self.subTest(s=s):
                self.assertEqual(self.solution.minAddToMakeValid(s), expected)

    def test_long_inputs(self):
        cases = (
            ("(" * 1000, 1000),
            (")" * 1000, 1000),
            ("(" * 500 + ")" * 500, 0),
            (")" * 500 + "(" * 500, 1000),
            ("()" * 500, 0),
        )
        for s, expected in cases:
            with self.subTest(length=len(s), prefix=s[:10], expected=expected):
                self.assertEqual(self.solution.minAddToMakeValid(s), expected)


if __name__ == "__main__":
    unittest.main()
