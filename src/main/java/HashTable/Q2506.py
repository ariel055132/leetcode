from typing import Dict


class Q2506:
    def similarPairs(self, words: list[str]) -> int:
        result = 0
        d = dict()
        for word in words:
            subword = "".join(sorted(set(word)))
            if subword not in d:
                d.update({subword: 1})
            else:
                result += d.get(subword)
                time = d.get(subword)
                d.update({subword: time + 1})
        return result
