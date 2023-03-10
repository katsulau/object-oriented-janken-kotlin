class Judgement {

    /**
     * じゃんけんの勝敗を判定する
     */
    fun judge(playerHands: PlayerHands): PlayerJudgeResults {

        // もし、全員が同じ手を出していたらドロー
        if (playerHands.isAllSameHandType()) {
            return draw(playerHands)
        }

        // グー、チョキ、パー全ての手が存在したとしたらドロー
        if (playerHands.existsAllHandTypes()) {
            return draw(playerHands)
        }


        // グー、チョキの場合
        if (playerHands.existsRockAndScissors()) {
            return winAndLose(playerHands, HandType.ROCK, HandType.SCISSORS)
        }


        // チョキ、パーの場合
        if (playerHands.existsScissorsAndPaper()) {
            return winAndLose(playerHands, HandType.SCISSORS, HandType.PAPER)
        }

        // パー、グーの場合
        if (playerHands.existsPaperAndRock()) {
            return winAndLose(playerHands, HandType.PAPER, HandType.ROCK)
        }

        throw IllegalArgumentException("勝敗処理ができませんでした")
    }

    /**
     * 勝敗処理を行う
     */
    private fun winAndLose(
        playerHands: PlayerHands, winHandType: HandType, loseHandType: HandType
    ): PlayerJudgeResults {

        val winPlayerHands = playerHands.filterPlayerHands(winHandType)
        winPlayerHands.recordResult(MatchResultType.WIN)
        val winPlayerJudgeResults = winPlayerHands.getPlayerJudgeResult(MatchResultType.WIN)

        val losePlayerHands = playerHands.filterPlayerHands(loseHandType)
        losePlayerHands.recordResult(MatchResultType.LOSE)
        val losePlayerJudgeResults = losePlayerHands.getPlayerJudgeResult(MatchResultType.LOSE)

        return winPlayerJudgeResults.plus(losePlayerJudgeResults)
    }


    /**
     * 引き分け処理を行う
     */
    private fun draw(playerHands: PlayerHands): PlayerJudgeResults {
        // 引き分け処理を各プレイヤーで記録する
        playerHands.recordResult(MatchResultType.DRAW)
        return playerHands.getPlayerJudgeResult(MatchResultType.DRAW)
    }
}