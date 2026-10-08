import sys
import unittest
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[3] / "main" / "java" / "Stack"))

from Q1021 import Q1021


class TestQ1021(unittest.TestCase):
    def setUp(self):
        self.solution = Q1021()

    def test_examples(self):
        cases = (
            ("(()())(())", "()()()"),
            ("(()())(())(()(()))", "()()()()(())"),
            ("()()", ""),
        )
        for s, expected in cases:
            with self.subTest(s=s):
                self.assertEqual(self.solution.removeOuterParentheses(s), expected)

    def test_only_single_pairs(self):
        for s in ("()", "()()()", "()()()()"):
            with self.subTest(s=s):
                self.assertEqual(self.solution.removeOuterParentheses(s), "")

    def test_nested_parentheses(self):
        cases = (
            ("(())", "()"),
            ("((()))", "(())"),
            ("(((())))", "((()))"),
        )
        for s, expected in cases:
            with self.subTest(s=s):
                self.assertEqual(self.solution.removeOuterParentheses(s), expected)

    def test_single_primitive_with_multiple_inner_groups(self):
        cases = (
            ("(()()())", "()()()"),
            ("((())())", "(())()"),
            ("(()(()))", "()(())"),
        )
        for s, expected in cases:
            with self.subTest(s=s):
                self.assertEqual(self.solution.removeOuterParentheses(s), expected)

    def test_mixed_primitives(self):
        cases = (
            ("()(())()", "()"),
            ("(())((()))", "()(())"),
            ("(()())()((()))(())", "()()(())()"),
        )
        for s, expected in cases:
            with self.subTest(s=s):
                self.assertEqual(self.solution.removeOuterParentheses(s), expected)

    def test_long_inputs(self):
        cases = (
            ("()" * 5000, ""),
            ("(" * 5000 + ")" * 5000, "(" * 4999 + ")" * 4999),
            ("(()())(())" * 1000, "()()()" * 1000),
        )
        for s, expected in cases:
            with self.subTest(length=len(s), prefix=s[:10]):
                self.assertEqual(self.solution.removeOuterParentheses(s), expected)


if __name__ == "__main__":
    unittest.main()
