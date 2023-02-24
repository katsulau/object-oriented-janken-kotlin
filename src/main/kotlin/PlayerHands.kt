class PlayerHands(
    private val values: List<PlayerHand>
) {
    fun isAllSameHandType(): Boolean {
        val playerHandTypeList = values.map { it.value.second  }.toList()
        return playerHandTypeList.all { playerHandTypeList[0] == it }
    }

    fun existsAllHandTypes(): Boolean {
        val playerHandTypeList = values.map { it.value.second  }.toList()
        return playerHandTypeList.contains(HandType.PAPER)
                && playerHandTypeList.contains(HandType.ROCK)
                && playerHandTypeList.contains(HandType.SCISSORS)
    }

    fun existsROCKAndSCISSORS(): Boolean {
        val playerHandTypeList = values.map { it.value.second  }.toList()
        return playerHandTypeList.contains(HandType.ROCK)
                && playerHandTypeList.contains(HandType.SCISSORS)
    }

    fun existsScissorsAndPaper(): Boolean {
        val playerHandTypeList = values.map { it.value.second  }.toList()
        return playerHandTypeList.contains(HandType.SCISSORS)
                && playerHandTypeList.contains(HandType.PAPER)
    }

    fun existsPaperAndRock(): Boolean {
        val playerHandTypeList = values.map { it.value.second  }.toList()
        return playerHandTypeList.contains(HandType.PAPER)
                && playerHandTypeList.contains(HandType.ROCK)
    }

    fun filterPlayerHands(handType: HandType): PlayerHands {
        val filteredList = values.filter { it.value.second == handType }.toList()
        return PlayerHands(filteredList)
    }

    /**
     * 結果を記録する
     */
    fun recordResult(matchResultType: MatchResultType) {
        values.forEach { it.value.first.recordResult(matchResultType) }
    }

    fun getPlayerJudgeResult(matchResultType: MatchResultType): List<PlayerJudgeResult> {
        return values.map { playerHand ->
            val pair = Pair(playerHand.value.first, matchResultType)
            PlayerJudgeResult(pair)
        }.toList()
    }
}