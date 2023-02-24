import java.lang.StringBuilder

class Player(
    val name: String,
) {
    private val record: MutableList<MatchResultType> = mutableListOf()

    fun showHand(): PlayerHand {
        // じゃんけんの手を選択する
        val handType = HandType.getRandom()

        val result = Pair(this, handType)
        // じゃんけんの手を伝える
        return PlayerHand(result)
    }

    fun recordResult(result: MatchResultType) {
        // じゃんけんの勝敗を記録する
        record.add(result)
    }


    /**
     * 勝敗記録を文字列で返す
     */
    fun showPlayResult(): String {
        val builder = StringBuilder()
        record.forEach { builder.append(it.value) }
        return builder.toString()
    }
}