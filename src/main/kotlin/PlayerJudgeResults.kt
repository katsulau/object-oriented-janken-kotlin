import java.lang.StringBuilder

class PlayerJudgeResults(
    private val values: List<PlayerJudgeResult>
) {
    fun plus(others: PlayerJudgeResults): PlayerJudgeResults {
        val mergedResults = values.plus(others.values)
        return PlayerJudgeResults(mergedResults)
    }

    fun isDraw(): Boolean {
        return values.first().value.second == MatchResultType.DRAW
    }

    fun filterWinners(): PlayerJudgeResults {
        val results = values.filter { it.value.second == MatchResultType.WIN }.toList()
        return PlayerJudgeResults(results)
    }

    fun filterLosers(): PlayerJudgeResults {
        val results = values.filter { it.value.second == MatchResultType.LOSE }.toList()
        return PlayerJudgeResults(results)
    }

    fun size(): Int {
        return values.size
    }

    fun createJankenPlayerGroup(): JankenPlayerGroup {
        val list = values.map {  it.value.first }.toList()
        return JankenPlayerGroup(list)
    }

    fun getPlayerNames(): String {
        val stringBuilder = StringBuilder()
        values.forEach { stringBuilder.append(it.value.first.name).append(" ") }
        return stringBuilder.toString()
    }
}