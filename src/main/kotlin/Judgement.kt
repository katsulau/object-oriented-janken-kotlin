class Judgement {

    /**
     * じゃんけんの勝敗を判定する
     */
    fun judge(playerHands: List<PlayerHand>): List<PlayerJudgeResult> {

        // もし、全員が同じ手を出していたらドロー
        val playerHandTypeList = playerHands.map { it.value.second  }.toList()
        val isAllSameHands = playerHandTypeList.all { playerHandTypeList[0] == it }
        if (isAllSameHands) {
            return draw(playerHands)
        }


        // グー、チョキ、パー全ての手が存在したとしたらドロー
        if (playerHandTypeList.contains(HandType.PAPER)
            && playerHandTypeList.contains(HandType.ROCK)
            && playerHandTypeList.contains(HandType.SCISSORS)) {
            return draw(playerHands)
        }


        // グー、チョキの場合
        if (playerHandTypeList.contains(HandType.ROCK)
            && playerHandTypeList.contains(HandType.SCISSORS)) {
            return winAndLose(playerHands, HandType.ROCK, HandType.SCISSORS)
        }


        // チョキ、パーの場合
        if (playerHandTypeList.contains(HandType.SCISSORS)
            && playerHandTypeList.contains(HandType.PAPER)) {
            return winAndLose(playerHands, HandType.SCISSORS, HandType.PAPER)
        }

        // パー、グーの場合
        if (playerHandTypeList.contains(HandType.PAPER)
            && playerHandTypeList.contains(HandType.ROCK)) {
            return winAndLose(playerHands, HandType.PAPER, HandType.ROCK)
        }

        throw IllegalArgumentException("勝敗処理ができませんでした")
    }

    /**
     * 勝敗処理を行う
     */
    private fun winAndLose(
        playerHands: List<PlayerHand>, winHandType: HandType, loseHandType: HandType
    ): List<PlayerJudgeResult> {

        val winPlayerJudgeResult = playerHands.filter { it.value.second == winHandType }
            .map {
                // 勝ちを各プレイヤーで記録する
                it.value.first.recordResult(MatchResultType.WIN)
                val pair = Pair(it.value.first, MatchResultType.WIN)
                PlayerJudgeResult(pair)
            }.toList()

        val losePlayerJudgeResult = playerHands.filter { it.value.second == loseHandType }
            .map {
                // 負けを各プレイヤーで記録する
                it.value.first.recordResult(MatchResultType.LOSE)
                val pair = Pair(it.value.first, MatchResultType.LOSE)
                PlayerJudgeResult(pair)
            }.toList()

        return winPlayerJudgeResult.plus(losePlayerJudgeResult)
    }


    /**
     * 引き分け処理を行う
     */
    private fun draw(playerHands: List<PlayerHand>): List<PlayerJudgeResult> {
        // 引き分け処理を各プレイヤーで記録する
        playerHands.forEach { it.value.first.recordResult(MatchResultType.DRAW) }

        return playerHands.map { playerHand ->
            val pair = Pair(playerHand.value.first, MatchResultType.DRAW)
            PlayerJudgeResult(pair)
        }.toList()
    }
}