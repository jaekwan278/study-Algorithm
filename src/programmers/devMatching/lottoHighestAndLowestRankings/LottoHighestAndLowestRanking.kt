package programmers.devMatching.lottoHighestAndLowestRankings

import kotlin.math.min

// 로또의 최고 순위와 최저 순위

class LottoHighestAndLowestRanking {

    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val answer = IntArray(2)

        val map = mutableMapOf<Int, Int>()
        for (i in 0 until 6) {
            map.put(lottos[i], map.getOrDefault(lottos[i], 0) + 1)
        }

        var idx = 0;
        for (cur in win_nums) {
            if (map.contains(cur)) idx++
        }

        answer[1] = min((7 - idx), 6);
        answer[0] = min((7 - (idx + map.getOrDefault(0, 0))), 6)

        return answer
    }

    fun solution2(lottos: IntArray, win_nums: IntArray): IntArray {
        val winSet = win_nums.toSet()

        println(winSet)

        val zero = lottos.count { it == 0 }
        val match = lottos.count { it -> winSet.contains(it) }

        val answer = intArrayOf(
            min((7 - (match + zero)), 6),
            min((7 - match), 6)
        )

        return answer
    }

    fun solution3(lottos: IntArray, winNums: IntArray): IntArray {
        return intArrayOf(
            (lottos.size.plus(1)) - lottos.filter { winNums.contains(it) || it == 0 }.size,
            (lottos.size.plus(1)) - lottos.filter(winNums::contains).size
        ).map { if (it > 6) it - 1 else it }.toIntArray()
    }
}

fun main() {
    val task = LottoHighestAndLowestRanking();

    val lottos = intArrayOf(44, 1, 0, 0, 31, 25)
    val win_nums = intArrayOf(31, 10, 45, 1, 6, 19)

    println(task.solution2(lottos, win_nums).contentToString())
}