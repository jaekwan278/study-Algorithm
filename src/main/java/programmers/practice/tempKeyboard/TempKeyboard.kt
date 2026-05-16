package programmers.practice.tempKeyboard

// 대충 만든 자판

class TempKeyboard {

    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {

        val cost = IntArray(26) { Int.MAX_VALUE }

        for(str in keymap){
            for((i, c) in str.withIndex()){
                val idx = c - 'A'
                cost[idx] = minOf(cost[idx], i + 1)
            }
        }

        return IntArray(targets.size) { i ->
            targets[i].fold(0) { acc, c ->
                val v = cost[c - 'A']
                if(v == Int.MAX_VALUE) return@IntArray -1
                acc + v
            }
        }
    }
}

fun main(){
    val task = TempKeyboard();

    val keymap = arrayOf("ABACD", "BCEFD");
    val target = arrayOf("ABCD","AABB");

    println(task.solution(keymap, target).contentToString())
}