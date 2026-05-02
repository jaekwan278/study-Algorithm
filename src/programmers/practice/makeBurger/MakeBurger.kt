package programmers.practice.makeBurger

// 햄버거 만들기

class MakeBurger {

    fun solution(ingredient: IntArray): Int {
        var answer = 0

        val stack = ArrayDeque<Int>()

        for (cur in ingredient) {
            stack.addLast(cur)

            if (stack.size >= 4) {
                val recipe = stack.takeLast(4)

                if (recipe.equals(listOf(1, 2, 3, 1))) {
                    answer++
                    repeat(4) { stack.removeLast() }
                }
            }

            println(stack)
        }

        return answer
    }

    fun solution2(ingredient: IntArray): Int {
        var answer = 0;

        val sb = StringBuilder()

        for (cur in ingredient) {
            sb.append(cur)

            if (sb.length >= 4) {
                if (sb.substring(sb.length - 4, sb.length).equals("1231")) {
                    answer++;
                    sb.removeRange(sb.length - 4, sb.length)
                }
            }
        }

        return answer
    }

    fun solution3(ingredient: IntArray): Int {
        var answer = 0;

        val arr = IntArray(ingredient.size)

        var top = 0;

        for (cur in ingredient) {
            arr[top++] = cur

            if (top >= 4 && (arr[top - 4] == 1 && arr[top - 3] == 2 && arr[top - 2] == 3 && arr[top - 1] == 1)) {
                top -= 4
                answer++
            }
        }

        return answer
    }
}

fun main() {
    val task = MakeBurger()

    val ingredient = intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)

    println(task.solution3(ingredient))
}