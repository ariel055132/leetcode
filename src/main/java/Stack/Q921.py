class Q921:
    # Match parentheses as we can scan from left to left, using two counters instead of a stack

    def minAddToMakeValid(self, s: str) -> int:
        # unmatch ( seen so far
        openBrackets = 0
        # unmatch ) seen so far-each requires inserting a (
        closeBrackets = 0
        # Traverse the string
        for ch in s:
            # If it is (, increment openBrackets
            if ch == "(":
                openBrackets += 1
            else:
                # if it is ) and an unmatched ( exists, pair them by decrementing openBrackets
                if openBrackets > 0:
                    openBrackets -= 1
                # Otherwise, ) has no opening parentheses, so increment closeBrackets
                else:
                    closeBrackets += 1
        return closeBrackets + openBrackets
